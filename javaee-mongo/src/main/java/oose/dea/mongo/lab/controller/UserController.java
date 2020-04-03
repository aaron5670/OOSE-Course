package oose.dea.mongo.lab.controller;

import com.google.gson.Gson;
import oose.dea.mongo.lab.dao.IUserDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserController {

    @Inject
    private IUserDAO iUserDAO;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.status(200).entity(userDTO()).build();
    }

    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser() {
        iUserDAO.addUser();
        return Response.status(200).entity(userDTO()).build();
    }

    @PUT
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsers() {
        iUserDAO.updateUser();
        return Response.status(200).entity(userDTO()).build();
    }

    @DELETE
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser() {
        iUserDAO.deleteUser();
        return Response.status(200).entity(userDTO()).build();
    }

    public String userDTO() {
        return new Gson().toJson(iUserDAO.getUsers());
    }
}
