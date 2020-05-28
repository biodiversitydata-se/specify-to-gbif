package se.nrm.bas.specify.solr.service.logic;
 
import java.util.Date;
import java.util.List;
import java.util.Map;  
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder; 
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
@Slf4j
public class SolrToGbifLogic {
  
  @Inject
  private SolrClient solr;  
  @Inject
  private InitialProperties properties; 
  
  @EJB
  private GbifDao dao;
  
  private final int maxFetchSize = 100; 
  private final String nrm = "nrm"; 
  private final String nrmCore = "nrm_index";
  private final String gnmCore = "gnm_index";
  
  public SolrToGbifLogic() {
    
  }

  public SolrToGbifLogic(SolrClient solr, InitialProperties properties, GbifDao dao) {
    this.solr = solr;
    this.properties = properties;
    this.dao = dao;
  }
  
  public void run(String institution, Map<String, String> filters) { 
    log.info("run : {} - {}", institution, filters);
    
    boolean isNrm = institution.equals(nrm);
    String searchQuery = Util.getInstance().buildSearchQuery(filters);
    String core = isNrm ? nrmCore : gnmCore; 
    URIBuilder builder = Util.getInstance().getUriBuilder(properties.getSolrPath(), core, searchQuery); 
     
    String result = solr.searchSolrData(builder, 0, maxFetchSize);   
    JsonObject json = JsonConverter.getInstance().buildResponseJson(result);   
    int numFound = JsonConverter.getInstance().getTotalNumberFound(json);
    log.info(" numFound : {}", numFound);
    List<SimpleDwc> beans = JsonConverter.getInstance().mapEntities(json); 
    dao.merge(beans, isNrm);
//    saveEntities(beans, isNrm);
    
    if (numFound > maxFetchSize) {
      for (int i = maxFetchSize; i < numFound; i += maxFetchSize) {
        result = solr.searchSolrData(builder, i, maxFetchSize);
        json = JsonConverter.getInstance().buildResponseJson(result); 
        beans = JsonConverter.getInstance().mapEntities(json); 
        dao.merge(beans, isNrm);
//        saveEntities(beans, isNrm);
      }
    }
    saveLogs(numFound, isNrm); 
  }
   
  private void saveEntities(List<SimpleDwc> beans, boolean isNrm) {
     beans.stream()
            .forEach(bean -> { 
              dao.merge(bean, isNrm);
            });
  }
  
  private void saveLogs(int numFound, boolean isNrm) {
    Logs logs = new Logs();
    logs.setTimestamp(new Date());
    logs.setTotalRecords(numFound);
    dao.createLogs(logs, isNrm);
  }
}
