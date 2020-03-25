package se.nrm.bas.specify.solr.service.logic.solr;

import java.io.IOException;
import java.io.InputStream;  
import java.net.URISyntaxException;  
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity; 
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients; 

/**
 *
 * @author idali
 */
@Slf4j
public class SolrClient {
    
  private CloseableHttpClient client; 
  private final String utf8 = "UTF-8"; 
  private HttpGet httpget; 
  private CloseableHttpResponse response;
  private HttpEntity httpEntity;
  private String encoding;
  private String responseText;
  private Header header;

  private final String startKey = "start";
  private final String rowsKey = "rows";
 
  public String searchSolrData(URIBuilder builder, int start, int maxFetchSize) {
    log.info("getData: start = {}", start);

    client = HttpClients.createDefault();
    
    builder.setParameter(startKey, String.valueOf(start));
    builder.setParameter(rowsKey, String.valueOf(maxFetchSize));

    try {  
      httpget = new HttpGet(builder.build()); 
      response = client.execute(httpget);
      if (response.getStatusLine().getStatusCode() == 200) {
        httpEntity = response.getEntity();
        header = httpEntity.getContentEncoding();
        encoding = header == null ? utf8 : header.getName();
        try (InputStream input = httpEntity.getContent()) {
          encoding = encoding == null ? utf8 : encoding;
          responseText = IOUtils.toString(input, encoding);
        }
      }
    } catch (IOException | URISyntaxException ex) {
      log.error(ex.getMessage());
    }
    return responseText;
  }
}  