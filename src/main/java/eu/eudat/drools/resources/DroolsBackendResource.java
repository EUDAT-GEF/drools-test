package eu.eudat.drools.resources;

import com.oracle.javafx.jmx.json.JSONException;
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
    //@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void acceptEvent(String json) throws JSONException {
        JSONObject object = new JSONObject(json);
        System.out.println(object);
    }
}







