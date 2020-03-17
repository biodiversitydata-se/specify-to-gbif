package se.nrm.bas.specify.solr.service;
 
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 
import javax.ws.rs.QueryParam;
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
   
  @Inject
  private SolrToGbifLogic logic;
  
  @GET
  @Path("/run") 
  @Produces(MediaType.APPLICATION_JSON)
  public Response run(@QueryParam("inst") String institution, @QueryParam("coll") String collectionCode,
          @QueryParam("from") String fromDate, @QueryParam("to") String toDate) { 
     
    logic.run(institution, Util.getInstance().buildFilterMap(collectionCode, fromDate, toDate));
     
    return Response.ok(success).build();
  }
}
