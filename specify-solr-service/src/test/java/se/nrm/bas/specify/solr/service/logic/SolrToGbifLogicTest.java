package se.nrm.bas.specify.solr.service.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import org.mockito.Mock;
import org.mockito.Mockito; 
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; 
import org.powermock.api.mockito.PowerMockito; 
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import se.nrm.bas.specify.gbif.datamodel.Logs;
import se.nrm.bas.specify.gbif.datamodel.SimpleDwc;
import se.nrm.bas.specify.solr.service.logic.jpa.GbifDao;
import se.nrm.bas.specify.solr.service.logic.json.JsonConverter;
import se.nrm.bas.specify.solr.service.logic.solr.SolrClient;
import se.nrm.bas.specify.solr.service.logic.util.Util;

/**
 *
 * @author idali
 */ 
@RunWith(PowerMockRunner.class)
@PrepareForTest({Util.class, JsonConverter.class})
@PowerMockIgnore({"javax.management.*", 
  "org.apache.http.conn.ssl.*", 
  "com.amazonaws.http.conn.ssl.*", 
  "javax.net.ssl.*"})
public class SolrToGbifLogicTest {
  
  private SolrToGbifLogic instance;
  
  @Mock
  private SolrClient solr;  
  @Mock
  private InitialProperties properties;  
  @Mock
  private GbifDao dao;
  
  private URIBuilder mockBuilder;
   
  private Map<String, String> filters;
  private String solrPath;
  private JsonObject json;
  private JsonConverter mockConverter;
  private String solrSearchResult;
  
  public SolrToGbifLogicTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() { 
    filters = new HashMap<>(); 
    solrPath = "http://localhsot:8983/solr";
    
    solrSearchResult = "{\"response\": "
            + "{\"numFound\": 2, \"docs\": [{\"id\": \"2\", \"type\": \"test\", \"language\": \"en\"},"
            + "{\"id\": \"6\", \"type\": \"test\", \"language\": \"sv\"}]}}";
     
    when(properties.getSolrPath()).thenReturn(solrPath); 
     
    mockBuilder = mock(URIBuilder.class);
    Util mockUtil = PowerMockito.mock(Util.class); 
    PowerMockito.mockStatic(Util.class);  
    when(Util.getInstance()).thenReturn(mockUtil);  
    
    Mockito.when(mockUtil.getUriBuilder(any(String.class), any(String.class), any(String.class)))
            .thenReturn(mockBuilder);  
    
    mockConverter = PowerMockito.mock(JsonConverter.class);
    PowerMockito.mockStatic(JsonConverter.class);  
    when(JsonConverter.getInstance()).thenReturn(mockConverter);  
    
    json = mock(JsonObject.class);
    Mockito.when(mockConverter.buildResponseJson(any(String.class))).thenReturn(json);  
     
    Mockito.when(mockConverter.getSolrDocs(json)).thenReturn(any(JsonArray.class)); 
     
    instance = new SolrToGbifLogic(solr, properties, dao);
  }
  
  @After
  public void tearDown() {
    instance = null;
  }
  
  @Test
  public void testDefaultConstructor() {
    instance = new SolrToGbifLogic();
    assertNotNull(instance);
  }
   
  /**
   * Test of run method, of class SolrToGbifLogic.
   */
  @Test
  public void testRunNrm() {
    System.out.println("run"); 
    
    Mockito.when(mockConverter.getTotalNumberFound(json)).thenReturn(2); 
    
    List<SimpleDwc> list = new ArrayList();
    list.add(new SimpleDwc("1"));
    list.add(new SimpleDwc("8"));
    Mockito.when(mockConverter.mapEntities(json)).thenReturn(list); 
    
    when(solr.searchSolrData(eq(mockBuilder), any(Integer.class), any(Integer.class)))
            .thenReturn(solrSearchResult);  
    
    SimpleDwc dwc = new SimpleDwc("18");
    Logs logs = new Logs();
    when(dao.merge(isA(SimpleDwc.class), isA(boolean.class))).thenReturn(dwc);
    when(dao.createLogs(isA(Logs.class), isA(boolean.class))).thenReturn(logs);
     
    instance.run("gnm", filters); 
    verify(dao, times(2)).merge(any(SimpleDwc.class), any(boolean.class));  
    verify(dao, times(1)).createLogs(any(Logs.class), any(boolean.class));  
    verify(solr, times(1)).searchSolrData(eq(mockBuilder), any(Integer.class), any(Integer.class));  
    verify(properties, times(1)).getSolrPath();  
  }
  
  @Test
  public void testRunNrmLargeData() {
    System.out.println("run"); 
    
    Mockito.when(mockConverter.getTotalNumberFound(json)).thenReturn(200); 
    List<SimpleDwc> list = new ArrayList();
    for(int i = 0; i < 100; i++) {
      list.add(new SimpleDwc(String.valueOf(i))); 
    }
    
    Mockito.when(mockConverter.mapEntities(json)).thenReturn(list); 
    
    when(solr.searchSolrData(eq(mockBuilder), any(Integer.class), any(Integer.class)))
            .thenReturn(solrSearchResult);  
    
    SimpleDwc dwc = new SimpleDwc("18");
    Logs logs = new Logs();
    when(dao.merge(isA(SimpleDwc.class), isA(boolean.class))).thenReturn(dwc);
    when(dao.createLogs(isA(Logs.class), isA(boolean.class))).thenReturn(logs);
    
    instance.run("nrm", filters); 
    verify(dao, times(200)).merge(any(SimpleDwc.class), any(boolean.class));  
    verify(dao, times(1)).createLogs(any(Logs.class), any(boolean.class));  
    verify(solr, times(2)).searchSolrData(eq(mockBuilder), any(Integer.class), any(Integer.class));  
    verify(properties, times(1)).getSolrPath();  
  }
  
  
}
