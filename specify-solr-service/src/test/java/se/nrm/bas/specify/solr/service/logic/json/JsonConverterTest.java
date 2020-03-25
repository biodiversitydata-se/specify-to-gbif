package se.nrm.bas.specify.solr.service.logic.json;

import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import static org.junit.Assert.*;
import se.nrm.bas.specify.gbif.datamodel.SimpleDwc;

/**
 *
 * @author idali
 */
public class JsonConverterTest {
  
  private JsonConverter instance;
  private String jsonString;
  
  public JsonConverterTest() {
  }
 
  @Before
  public void setUp() {
    jsonString = "{\"response\": "
            + "{\"numFound\": 2, \"docs\": [{\"id\": \"2\", \"type\": \"test\", \"language\": \"en\"},"
            + "{\"id\": \"6\", \"type\": \"test\", \"language\": \"sv\"}]}}";
 
    instance = JsonConverter.getInstance();
  }
  
  @After
  public void tearDown() {
    instance = null;
  }

  /**
   * Test of getInstance method, of class JsonConverter.
   */
  @Test
  public void testGetInstance() {
    System.out.println("getInstance"); 
    assertNotNull(instance);
  }

  /**
   * Test of buildResponseJson method, of class JsonConverter.
   */
  @Test
  public void testBuildResponseJson() {
    System.out.println("buildResponseJson");
   
    JsonObject result = instance.buildResponseJson(jsonString);
    assertNotNull(result);
    assertEquals(2, result.getInt("numFound")); 
  }

  /**
   * Test of getTotalNumberFound method, of class JsonConverter.
   */
  @Test
  public void testGetTotalNumberFound() {
    System.out.println("getTotalNumberFound"); 
    JsonObject json = instance.buildResponseJson(jsonString);
    int expResult = 2;
    int result = instance.getTotalNumberFound(json);
    assertEquals(expResult, result); 
  }

  /**
   * Test of getSolrDocs method, of class JsonConverter.
   */
  @Test
  public void testGetSolrDocs() {
    System.out.println("getSolrDocs");
    JsonObject json = instance.buildResponseJson(jsonString);  
    JsonArray result = instance.getSolrDocs(json);
    assertEquals(2, result.size()); 
  }

  /**
   * Test of mapEntities method, of class JsonConverter.
   */
  @Test
  public void testMapEntities() {
    System.out.println("mapEntities"); 
    JsonObject json = instance.buildResponseJson(jsonString);  
    List<SimpleDwc> result = instance.mapEntities(json);
    assertEquals(2, result.size()); 
  }
   
  @Test
  public void testMapEntitiesException() {
    System.out.println("mapEntities");
    
    jsonString = "{\"response\": "
            + "{\"numFound\": 2, \"docs\": [{\"id\": 2, \"type\": \"test\", \"language\": \"en\"},"
            + "{\"id\": \"6\", \"type\": \"test\", \"language\": {\"id\": 2, \"type\": \"test\", \"language\": \"en\"}}]}}";
     
    JsonObject json = instance.buildResponseJson(jsonString);  
    List<SimpleDwc> result = instance.mapEntities(json);
    assertNull(result); 
  } 
}
