package se.nrm.bas.specify.solr.service.logic;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

/**
 *
 * @author idali
 */ 
@ApplicationScoped
@Slf4j
public class InitialProperties implements Serializable  {
  
  private final static String CONFIG_INITIALLISING_ERROR = "Property not initialized";
  
  private String solrPath;
  
   public InitialProperties() {
  }

  @Inject
  public InitialProperties(@ConfigurationValue("swarm.solr.path") String solrPath  ) { 
    this.solrPath = solrPath; 
    log.info("test injection : {} ", solrPath);
  }
  
  public String getSolrPath() {
    if (solrPath == null) {
      throw new RuntimeException(CONFIG_INITIALLISING_ERROR);
    }
    return solrPath;
  }  
}
