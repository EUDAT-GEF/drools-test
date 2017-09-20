package eu.eudat.drools.resources;

import org.json.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import eu.eudat.drools.core.RuleChecker;

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
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String acceptEvent(String json) {
        JSONObject eventData = new JSONObject(json);
        JSONObject systemEnvironment = new JSONObject();
        JSONObject systemStatistics = new JSONObject();
        if (eventData.has("environment")) {
            systemEnvironment = eventData.optJSONObject("environment");
        }
        if (eventData.has("statistics")) {
            systemStatistics = eventData.optJSONObject("statistics");
        }


        System.out.println(eventData);
        System.out.println(systemEnvironment);
        System.out.println(systemStatistics);
        System.out.println("");

        RuleChecker rc = new RuleChecker();
        rc.FireRules(systemEnvironment, systemStatistics);
        return systemEnvironment.toString();
    }
}







