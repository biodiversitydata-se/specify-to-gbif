package se.nrm.bas.specify.solr.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author idali
 */
@Path("/") 
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class SpecifyService {
   
  private final String success = "Done";
  
  @GET
  @Path("/run") 
  @Produces(MediaType.APPLICATION_JSON)
  public Response run() {  
    return Response.ok(success).build();
  }
}
