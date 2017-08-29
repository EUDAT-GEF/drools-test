package eu.eudat.drools.resources;

import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
public class DroolsBackendResource {

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return "This is Drools system API";
    }

    /**
     * Accepts JSON with event information from the GEF
     * By parsing this JSON the system has to decide which rule can be applied
     * @param json event from the GEF
     */
    @POST
    @Path("/events")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void acceptEvent(String json) {
        JSONObject object = new JSONObject(json);
        System.out.println(object);
    }
}







