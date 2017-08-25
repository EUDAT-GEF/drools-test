package eu.eudat.drools.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class DroolsBackendResource {

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooks() {
        return "Text for testing";
    }
}







