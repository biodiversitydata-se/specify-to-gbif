package se.nrm.bas.specify.solr.service.logic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.validation.ConstraintViolationException;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when; 
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import se.nrm.bas.specify.gbif.datamodel.Logs;
import se.nrm.bas.specify.gbif.datamodel.SimpleDwc;

/**
 *
 * @author idali
 */
@RunWith(MockitoJUnitRunner.class)   
public class GbifDaoTest {
  
  private GbifDao instance;
  
  @Mock
  private EntityManager nrmEntityManager;
  @Mock
  private EntityManager gnmEntityManager;
   
  private Logs logs;
  private SimpleDwc dwc;
  
  public GbifDaoTest() {
  }
    
  @Before
  public void setUp() { 
    
    Mockito.doNothing().when(nrmEntityManager).flush();
    Mockito.doNothing().when(gnmEntityManager).flush();
    dwc = new SimpleDwc("1");  
  }
  
  @After
  public void tearDown() {
  }
  
  @Test
  public void testDefaultConstructor() {
    instance = new GbifDao();
    assertNotNull(instance);
  }
 

  /**
   * Test of createLogs method, of class GbifDao.
   */
  @Test
  public void testCreateLogs() {
    System.out.println("createLogs");
    
    Mockito.doNothing().when(nrmEntityManager).persist(any(Logs.class));
    Mockito.doNothing().when(gnmEntityManager).persist(any(Logs.class));
      
    logs = new Logs();
    boolean isNrm = true;
    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
    Logs result = instance.createLogs(logs, isNrm); 
    assertNotNull(result); 
        
    verify(nrmEntityManager, times(1)).persist(logs);
    verify(nrmEntityManager, times(1)).flush();
    
    verify(gnmEntityManager, never()).persist(logs);
    verify(gnmEntityManager, never()).flush();
  }
  
  @Test
  public void testCreateLogsWithConstraintViolationException() {
    System.out.println("createLogs");
    
    Mockito.doThrow(ConstraintViolationException.class).when(nrmEntityManager).persist(any(Logs.class));
    Mockito.doThrow(ConstraintViolationException.class).when(gnmEntityManager).persist(any(Logs.class));
     
    logs = new Logs();
    boolean isNrm = true;
    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
    Logs result = instance.createLogs(logs, isNrm); 
    assertNotNull(result); 
        
    verify(nrmEntityManager, times(1)).persist(logs);
    verify(nrmEntityManager, never()).flush();
    
    verify(gnmEntityManager, never()).persist(logs);
    verify(gnmEntityManager, never()).flush();
  }

  @Test
  public void testCreateLogsWithException() {
    System.out.println("createLogs");
    
    Mockito.doThrow(Exception.class).when(nrmEntityManager).persist(any(Logs.class));
    Mockito.doThrow(Exception.class).when(gnmEntityManager).persist(any(Logs.class));
    
    Mockito.doNothing().when(nrmEntityManager).flush();
    Mockito.doNothing().when(gnmEntityManager).flush();
 
    logs = new Logs();
    boolean isNrm = false;
    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
    Logs result = instance.createLogs(logs, isNrm); 
    assertNotNull(result); 
        
    verify(nrmEntityManager, never()).persist(logs);
    verify(nrmEntityManager, never()).flush();
    
    verify(gnmEntityManager, times(1)).persist(logs);
    verify(gnmEntityManager, never()).flush();
  }

  
  /**
   * Test of merge method, of class GbifDao.
   */
//  @Test
//  public void testMerge() {
//    System.out.println("merge");
//     
//    when(nrmEntityManager.merge(any(SimpleDwc.class))).thenReturn(dwc);
//    when(gnmEntityManager.merge(any(SimpleDwc.class))).thenReturn(dwc); 
//     
//    boolean isNrm = false;
//    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
//    SimpleDwc result = instance.merge(dwc, isNrm);
//    assertNotNull(result);  
//    verify(gnmEntityManager, times(1)).merge(dwc);
//    verify(gnmEntityManager, times(1)).flush();
//    
//    verify(nrmEntityManager, never()).merge(dwc);
//    verify(nrmEntityManager, never()).flush();
//  }
  
//  @Test(expected = ConstraintViolationException.class)
//  public void testMergeConstraintViolationException() {
//    System.out.println("merge");
//     
//    Mockito.doThrow(ConstraintViolationException.class).when(nrmEntityManager).merge(any(Logs.class));
//    Mockito.doThrow(ConstraintViolationException.class).when(gnmEntityManager).merge(any(Logs.class));
//     
//    boolean isNrm = false;
//    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
//    instance.merge(dwc, isNrm); 
//  }
  
//  @Test(expected = OptimisticLockException.class)
//  public void testMergeOptimisticLockException() {
//    System.out.println("merge");
//     
//    Mockito.doThrow(OptimisticLockException.class).when(nrmEntityManager).merge(any(Logs.class));
//    Mockito.doThrow(OptimisticLockException.class).when(gnmEntityManager).merge(any(Logs.class));
//      
//    boolean isNrm = true;
//    instance = new GbifDao(nrmEntityManager, gnmEntityManager); 
//    instance.merge(dwc, isNrm); 
//  }
//  
}
