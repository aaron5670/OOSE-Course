package controller;

import dao.ItemDAO;
import dto.ItemDTO;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
@Singleton  // <-- Hiermee maak je maar één instantie aan, die over verschillende requests wordt hergebruikt.
            // Hiermee kan ik met de POST request een item toevoegen, en met het GET request het resultaat bekijken.
public class ItemController {

    private ItemDAO itemDAO;

    public ItemController() {
        this.itemDAO = new ItemDAO();
    }

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

    @GET
    @Path("/items-dto")
    @Produces("application/json")
    public Response responseDTO() {
        return Response.ok().entity(itemDAO.getAll()).build();
    }

    @GET
    @Path("/items-dto/{id}")
    @Produces("application/json")
    public Response getItem(@PathParam("id") int id) {
        return Response.ok().entity(itemDAO.getItem(id)).build();
    }

    @POST
    @Path("/items-dto")
    @Consumes("application/json")
    public Response addItem(ItemDTO itemDTO) {
        itemDAO.addItem(itemDTO);

        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteItem(@PathParam("id") int id) {
        itemDAO.deleteItem(id);

        return Response.ok().build();
    }
}
