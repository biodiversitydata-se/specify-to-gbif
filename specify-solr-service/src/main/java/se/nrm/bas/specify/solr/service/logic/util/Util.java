package se.nrm.bas.specify.solr.service.logic.util;

import java.net.URI;
import java.net.URISyntaxException;  
import java.util.HashMap;
import java.util.Map; 
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author idali
 */
@Slf4j
public class Util {

  private final String solr = "/solr/";
  private final String select = "/select";
  private final String q = "q"; 
  private StringBuilder sb;
  private StringBuilder queryBuilder; 
  private StringBuilder dateSb;
  private final String timeZoon = "T00:00:00Z";
  private final String startSquareBracket = "[";
  private final String endSquareBracket = "]";
  private final String wildCard = "*";
  private final String plusSign = "+";
  private final String wildCardQuery = "*:*"; 
  private final String to = " TO ";
  private final String now = "NOW";
  
  private final String emptySpace = " ";
  private final String querySeparator = ":";
   
  private final String collectionCodeKey = "collectionCode";
  private final String modifiedKey = "modified";        
  
  private static Util instance = null;
   
  public static Util getInstance() {
    synchronized (Util.class) {
      if (instance == null) {
        instance = new Util();
      }
    }
    return instance;
  }
   
  public Map<String, String> buildFilterMap(String collectionCode, String fromDate, String toDate) { 
    Map<String, String> map = new HashMap<>();
    if(collectionCode != null && !collectionCode.trim().isEmpty()) {
      map.put(collectionCodeKey, collectionCode);
    }
    
    if((fromDate == null || fromDate.trim().isEmpty())
            && (toDate == null || toDate.trim().isEmpty())) {
      return map;
    }
    
    dateSb = new StringBuilder();
    dateSb.append(startSquareBracket);
    if(fromDate != null && !fromDate.trim().isEmpty()) {
      dateSb.append(fromDate);
      dateSb.append(timeZoon);
    } else {
      dateSb.append(wildCard);
    }
    dateSb.append(to);
    if(toDate != null && !toDate.trim().isEmpty()) {
      dateSb.append(toDate);
      dateSb.append(timeZoon);
    } else {
      dateSb.append(now);
    } 
    dateSb.append(endSquareBracket);
    
    map.put(modifiedKey, dateSb.toString().trim());    
    return map;
  }

  public String buildSearchQuery(Map<String, String> filters) {
    queryBuilder = new StringBuilder();
    if (filters != null && !filters.isEmpty()) {
      filters.entrySet()
              .stream()
              .forEach(e -> {
                queryBuilder.append(plusSign);
                queryBuilder.append(e.getKey());
                queryBuilder.append(querySeparator);
                queryBuilder.append(e.getValue());
                queryBuilder.append(emptySpace);
              });
      return queryBuilder.toString().trim(); 
    } else {
      return wildCardQuery;
    }
  }

  public URIBuilder getUriBuilder(String solrPath, String core, String searchQuery) {
    log.info("getUriBuilder : {}", solrPath);
    sb = new StringBuilder();
    sb.append(solr);
    sb.append(core);
    sb.append(select);
    try {  
      URIBuilder builder = new URIBuilder(new URI(solrPath));
      builder.setPath(sb.toString().trim()); 
      builder.setParameter(q, searchQuery);  
      return builder;
    }  catch (URISyntaxException ex) { 
      return null;
    } 
  } 
}
