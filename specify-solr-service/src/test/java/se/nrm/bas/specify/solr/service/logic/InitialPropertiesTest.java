package se.nrm.bas.specify.solr.service.logic;

import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author idali
 */
public class InitialPropertiesTest {
  
  private InitialProperties instance;
  private String solrPath;
  
  public InitialPropertiesTest() {
  }
 
  @Before
  public void setUp() { 
    solrPath = "http://localhost:8983/solr";
  }
  
  @After
  public void tearDown() {
    instance = null;
  }
  
  @Test
  public void testDefaultConstructor() {
    instance = new InitialProperties();
    assertNotNull(instance);
  }
  
  @Test(expected = RuntimeException.class)
  public void testDefaultConstructorThrowException() {
    instance = new InitialProperties(); 
    instance.getSolrPath();
  }

  /**
   * Test of getSolrPath method, of class InitialProperties.
   */
  @Test
  public void testGetSolrPath() {
    System.out.println("getSolrPath");  
    
    instance = new InitialProperties(solrPath);
    String result = instance.getSolrPath();
    assertEquals(solrPath, result); 
  }
   
  @Test(expected = RuntimeException.class)
  public void testGetSolrPathException() {
    System.out.println("getSolrPath");
    
    instance = new InitialProperties(null); 
    instance.getSolrPath(); 
  }
  
}
