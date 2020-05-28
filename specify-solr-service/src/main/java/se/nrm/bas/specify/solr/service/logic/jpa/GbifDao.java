package se.nrm.bas.specify.solr.service.logic.jpa;

import java.io.Serializable; 
import java.util.List;
import javax.ejb.Stateless;
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
@Stateless
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
   
//  @Transactional
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

  public void merge(List<SimpleDwc> entities, boolean isNrm)
          throws OptimisticLockException, ConstraintViolationException {
    log.info("merge : {}", entities.size());

    entityManager = getEntityManager(isNrm);

    entities.stream()
            .forEach(entity -> {
              SimpleDwc tmp = entity; 
              try {
                tmp = entityManager.merge(entity);
                entityManager.flush();                              // this one used for throwing OptimisticLockException if method called with web service 
              } catch (OptimisticLockException | ConstraintViolationException e) {
                log.error(e.getMessage()); 
                throw e;
              } 
            }); 
  }

  
  
//  @Transactional
  public SimpleDwc merge(SimpleDwc entity, boolean isNrm)
          throws OptimisticLockException, ConstraintViolationException{
    log.info("create(T) : {}", entity);
     
    if(entity.getId().equals("0a199703-685a-4558-8804-f95e4ec1708a") ) {
      log.info("find... {} -- {}", entity.getDecimalLatitude(), entity.getDecimalLongitude());
    }
    entityManager = getEntityManager(isNrm); 
    SimpleDwc tmp = entity;

    try {
      tmp = entityManager.merge(entity);
      entityManager.flush();                              // this one used for throwing OptimisticLockException if method called with web service 
    } catch (OptimisticLockException | ConstraintViolationException e) {
      log.error(e.getMessage());
      System.out.println("throw...");
      throw e;
    } 
    return tmp;
  }

  private EntityManager getEntityManager(boolean isNrm) {
    return isNrm ? nrmEntityManager : gnmEntityManager;
  }
}
