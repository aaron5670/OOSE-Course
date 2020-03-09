package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/health")
public class HealthCheckController {

    @GET
    public String healthy() {
        return "Up & Running";
    }
}
