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
   
  @Transactional
  public Logs createLogs(Logs logs, String institution) {
    log.info("createLogs : {}", logs);

    entityManager = getEntityManager(institution);
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
  public SimpleDwc merge(SimpleDwc entity, String institution) {
    log.info("create(T) : {}", entity);
    
    entityManager = getEntityManager(institution); 
    SimpleDwc tmp = entity;

    try {
      tmp = entityManager.merge(entity);
      entityManager.flush();                              // this one used for throwing OptimisticLockException if method called with web service 
    } catch (OptimisticLockException e) {
      log.error(e.getMessage());
    } catch (ConstraintViolationException e) {
      log.error(e.getMessage()); 
    } catch (Exception e) {
      log.error(e.getMessage());
    } 
    return tmp;
  }

  private EntityManager getEntityManager(String institution) {
    return institution.equals("nrm") ? nrmEntityManager : gnmEntityManager;
  }
}
