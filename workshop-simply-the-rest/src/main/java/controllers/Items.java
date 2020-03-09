package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class Items {

    @GET
    @Path("/items-text")
    @Produces("text/plain")
    public Response responseText() {
        return Response.status(200).entity("bread, butter").build();
    }

    @GET
    @Path("/items-json")
    @Produces("application/json")
    public Response responseJson() {
        return Response.status(200).entity("[\"bread\", \"butter\"]").build();
    }
}
