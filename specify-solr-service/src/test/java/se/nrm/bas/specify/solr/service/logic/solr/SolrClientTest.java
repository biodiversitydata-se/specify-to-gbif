package se.nrm.bas.specify.solr.service.logic.solr;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when; 
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner; 

/**
 *
 * @author idali
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpClients.class, IOUtils.class})
@PowerMockIgnore({"javax.management.*", 
  "org.apache.http.conn.ssl.*", 
  "com.amazonaws.http.conn.ssl.*", 
  "javax.net.ssl.*"})   
public class SolrClientTest {
  
  private SolrClient instance;
   
  @Mock
  private URIBuilder builder;
  @Mock
  private HttpGet httpGet;
  private final String utf8 = "UTF-8"; 
  
  @Mock
  private CloseableHttpClient client;
  
  public SolrClientTest() {
  }
   
  @Before
  public void setUp() throws URISyntaxException { 
    
    URI uri = new URI("sdsadf"); 
    when(builder.build()).thenReturn(uri);
    
  }
  
  @After
  public void tearDown() {
    instance = null;
  }

  /**
   * Test of searchSolrData method, of class SolrClient.
   * @throws java.io.IOException
   */
  @Test
  public void testSearchSolrData() throws IOException {
    System.out.println("searchSolrData");
      
    CloseableHttpResponse response = mock(CloseableHttpResponse.class);    
    StatusLine statusLine = mock(StatusLine.class);
    when(statusLine.getStatusCode()).thenReturn(200); 
    when(response.getStatusLine()).thenReturn(statusLine);
    
    Header header = mock(Header.class);
    when(header.getName()).thenReturn(utf8);
    
    HttpEntity httpEntity = mock(HttpEntity.class);
    when(httpEntity.getContentEncoding()).thenReturn(header);
    when(response.getEntity()).thenReturn(httpEntity);
    String text = "test text";
    PowerMockito.mockStatic(IOUtils.class);  
     
    when(IOUtils.toString(any(InputStream.class), any(String.class))).thenReturn(text); 
     
    when(client.execute(any(HttpGet.class))).thenReturn(response);
    PowerMockito.mockStatic(HttpClients.class);  
    Mockito.when(HttpClients.createDefault()).thenReturn(client);
     
    
    int start = 0;
    int maxFetchSize = 20;
    instance = new SolrClient(); 
    String result = instance.searchSolrData(builder, start, maxFetchSize);
    assertEquals(text, result);
  }
  
}
