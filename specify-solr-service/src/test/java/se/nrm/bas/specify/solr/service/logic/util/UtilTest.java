package se.nrm.bas.specify.solr.service.logic.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.utils.URIBuilder;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author idali
 */
public class UtilTest {
  
  private Util instance;
  
  private final String collectionCodeKey = "collectionCode";
  private final String modifiedKey = "modified";   
  
  public UtilTest() {
  }
  
  @Before
  public void setUp() {
    instance = Util.getInstance();
  }
  
  @After
  public void tearDown() {
    instance = null;
  }

  /**
   * Test of getInstance method, of class Util.
   */
  @Test
  public void testGetInstance() {
    System.out.println("getInstance"); 
     
    assertNotNull(instance); 
  }

  /**
   * Test of buildFilterMap method, of class Util.
   */
  @Test
  public void testBuildFilterMap() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = "2019-01-01";
    String toDate = "2019-02-02";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }
   
  @Test
  public void testBuildFilterMap1() {
    System.out.println("buildFilterMap");
    String collectionCode = null;
    String fromDate = "2019-01-01";
    String toDate = "2019-02-02";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size());  
    assertFalse(result.containsKey(collectionCodeKey));
    assertTrue(result.containsKey(modifiedKey));
  }
  
  @Test
  public void testBuildFilterMap2() {
    System.out.println("buildFilterMap");
    String collectionCode = " ";
    String fromDate = "2019-01-01";
    String toDate = "2019-02-02";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size());  
    assertTrue(result.containsKey(modifiedKey));
  }
 
  @Test
  public void testBuildFilterMap3() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = null;
    String toDate = "2019-02-02";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap4() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = " ";
    String toDate = "2019-02-02";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap5() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = "2019-01-01";
    String toDate = null;  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap6() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = "2019-01-01";
    String toDate = " ";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap7() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = "2019-01-01";
    String toDate = " ";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(2, result.size()); 
  }

  @Test
  public void testBuildFilterMap8() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = null;
    String toDate = null;  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size()); 
  }

  @Test
  public void testBuildFilterMap9() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = " ";
    String toDate = null;  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap10() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = null;
    String toDate = " ";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size()); 
  }
  
  @Test
  public void testBuildFilterMap11() {
    System.out.println("buildFilterMap");
    String collectionCode = "123";
    String fromDate = " ";
    String toDate = " ";  
    Map<String, String> result = instance.buildFilterMap(collectionCode, fromDate, toDate);
    assertEquals(1, result.size()); 
  }
  
  
  /**
   * Test of buildSearchQuery method, of class Util.
   */
  @Test
  public void testBuildSearchQuery() {
    System.out.println("buildSearchQuery");
    Map<String, String> filters = null; 
    String expResult = "*:*";
    String result = instance.buildSearchQuery(filters);
    assertEquals(expResult, result); 
  }
  
  @Test
  public void testBuildSearchQuery1() {
    System.out.println("buildSearchQuery");
    Map<String, String> filters = new HashMap<>(); 
    String expResult = "*:*";
    String result = instance.buildSearchQuery(filters);
    assertEquals(expResult, result); 
  }
  
  @Test
  public void testBuildSearchQuery2() {
    System.out.println("buildSearchQuery");
    Map<String, String> filters = new HashMap<>(); 
    filters.put("test", "test");
    String expResult = "+test:test";
    String result = instance.buildSearchQuery(filters);
    assertEquals(expResult, result); 
  }

  /**
   * Test of getUriBuilder method, of class Util.
   */
  @Test
  public void testGetUriBuilder() {
    System.out.println("getUriBuilder");
    String solrPath = "http://localhost:8983/solr";
    String core = "nrm";
    String searchQuery = "q:*";  
    URIBuilder result = instance.getUriBuilder(solrPath, core, searchQuery);
    System.out.println("result..." + result);
    System.out.println("result..." + result.getPath() + "...." + result.getQueryParams() + " .... " + result.getHost());
    assertNotNull(result); 
    assertEquals(8983, result.getPort());
    assertEquals("localhost", result.getHost());
    assertEquals("/solr/nrm/select", result.getPath());
    assertEquals(1, result.getQueryParams().size());
  } 
}
