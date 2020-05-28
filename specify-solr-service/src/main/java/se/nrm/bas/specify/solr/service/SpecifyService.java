package se.nrm.bas.specify.solr.service;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import se.nrm.bas.specify.solr.service.logic.SolrToGbifLogic;
import se.nrm.bas.specify.solr.service.logic.util.Util;

/**
 *
 * @author idali
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class SpecifyService {

  private final String success = "Done";
  private final String processRunning = "Process running .....";
  
  private final int badRequestStatusCode = 400; 
  private final String badRequestInstitution = "Bad Request. Institution code is required"; 
  private final String badRequestCollection = "Bad Request. Collection code is required"; 

  @Inject
  private SolrToGbifLogic logic;

  @GET
  @Path("/run")
  @Produces(MediaType.APPLICATION_JSON)
  public synchronized void run(@QueryParam("inst") String institution,
          @QueryParam("coll") String collectionCode,
          @QueryParam("from") String fromDate, @QueryParam("to") String toDate,
          @Suspended AsyncResponse asycResponse) {
    
    log.info("run.... {} --- {}", institution, collectionCode);
    
    Response response;
    if(institution == null || institution.isEmpty()) {
      response = Response.status(badRequestStatusCode)
              .entity(badRequestInstitution).build();
      asycResponse.resume(response);
      return;
    } 
    if(collectionCode == null || collectionCode.isEmpty()) {
      response = Response.status(badRequestStatusCode)
              .entity(badRequestCollection).build();
      asycResponse.resume(response);
      return;
    } 

    asycResponse.setTimeout(10, TimeUnit.SECONDS);
    //client will recieve a HTTP 408 (timeout error) after 10 seconds
    asycResponse.setTimeoutHandler((asyncResp) -> {
      asyncResp.resume(Response.status(Response.Status.OK).entity(processRunning).build());
    });

    new Thread() {
      @Override
      public void run() {
        logic.run(institution, Util.getInstance().buildFilterMap(collectionCode, fromDate, toDate));
        Response response = Response.ok().entity(success).build();
        asycResponse.resume(response);
      }
    }.start();
  
//    return Response.ok(success).build();
  }
}
