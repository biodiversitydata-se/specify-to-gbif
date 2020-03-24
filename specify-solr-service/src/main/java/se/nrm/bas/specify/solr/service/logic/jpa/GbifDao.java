package se.nrm.bas.specify.solr.service.logic.jpa;

import java.io.Serializable; 
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import se.nrm.bas.specify.gbif.datamodel.Logs;
import se.nrm.bas.specify.gbif.datamodel.SimpleDwc;

/**
 *
 * @author idali
 */ 
@Slf4j
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GbifDao implements Serializable {
   
  @PersistenceContext(unitName = "jpaGbifNrmPU")
  private EntityManager nrmEntityManager;
  
  @PersistenceContext(unitName = "jpaGbifGnmPU")
  private EntityManager gnmEntityManager;
  
  private EntityManager entityManager;
   
  
  public GbifDao() { 
  }
  
  public GbifDao(EntityManager nrmEntityManager, EntityManager gnEntityManager) {
    this.nrmEntityManager = nrmEntityManager;
    this.gnmEntityManager = gnEntityManager;
  }
   
  @Transactional
  public Logs createLogs(Logs logs, boolean isNrm) {
    log.info("createLogs : {}", logs);

    entityManager = getEntityManager(isNrm);
    Logs tmp = logs;
    try { 
      entityManager.persist(logs);
      entityManager.flush();
    } catch (ConstraintViolationException e) {
      log.error(e.getMessage()); 
    } catch (Exception e) {
      log.error(e.getMessage()); 
    } 
    return tmp;
  }

  @Transactional
  public SimpleDwc merge(SimpleDwc entity, boolean isNrm)
          throws OptimisticLockException, ConstraintViolationException{
    log.info("create(T) : {}", entity);
    
    entityManager = getEntityManager(isNrm); 
    SimpleDwc tmp = entity;

    try {
      tmp = entityManager.merge(entity);
      entityManager.flush();                              // this one used for throwing OptimisticLockException if method called with web service 
    } catch (OptimisticLockException | ConstraintViolationException e) {
      log.error(e.getMessage());
      throw e;
    } 
    return tmp;
  }

  private EntityManager getEntityManager(boolean isNrm) {
    return isNrm ? nrmEntityManager : gnmEntityManager;
  }
}
