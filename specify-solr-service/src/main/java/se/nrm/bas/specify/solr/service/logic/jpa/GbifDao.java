package se.nrm.bas.specify.solr.service.logic.jpa;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author idali
 */ 
@Slf4j
public class GbifDao implements Serializable {
  
  
  
  @PersistenceContext(unitName = "jpaGbifPU")
  private EntityManager entityManager;
  
  public GbifDao() {
    
  }
  
}
