package controller;

import dao.IItemDAO;
import dto.ItemDTO;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
@Singleton  // <-- Hiermee maak je maar één instantie aan, die over verschillende requests wordt hergebruikt.
            // Hiermee kan ik met de POST request een item toevoegen, en met het GET request het resultaat bekijken.
public class ItemController {

    private IItemDAO IItemDAO;

    @GET
    @Path("/items-text")
    @Produces("text/plain")
    public String getTextItems() {
        return "bread, butter";
    }

    @GET
    @Path("/items-dto")
    @Produces("application/json")
    public Response getJsonItems() {
        return Response.ok().entity(IItemDAO.getAll()).build();
    }

    @GET
    @Path("/items-dto/{id}")
    @Produces("application/json")
    public Response getItem(@PathParam("id") int id) {
        return Response.ok().entity(IItemDAO.getItem(id)).build();
    }

    @POST
    @Path("/items-dto")
    @Consumes("application/json")
    public Response addItem(ItemDTO itemDTO) {
        IItemDAO.addItem(itemDTO);

        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteItem(@PathParam("id") int id) {
        IItemDAO.deleteItem(id);

        return Response.ok().build();
    }

    @Inject
    public void setItemDAO(IItemDAO IItemDAO) {
        this.IItemDAO = IItemDAO;
    }
}
