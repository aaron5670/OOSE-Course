package oose.dea.api;

import oose.dea.api.dto.JediDTO;
import oose.dea.api.dto.LightSaberDTO;
import oose.dea.dao.IJediDAO;
import oose.dea.dao.ILightsaberDAO;
import oose.dea.domain.Jedi;
import oose.dea.domain.Lightsaber;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("starwars")
public class StarWars {

    private ILightsaberDAO ILightsaberDAO;

    private IJediDAO IJediDAO;
    @GET
    @Path("hello")
    public String hello() {
        return "May the force be with you.";
    }

    @POST
    @Path("lightsaber")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    /*
     * Huiswerk, laat het gebruik maken van een DAO (Data Access Object).
     * En maak hier een test van (100% Code Covarage) + Workshop
     */
    public Response getLightSaber(JediDTO jedi) {
        Lightsaber lightsaber = ILightsaberDAO.getLightsaber();
        if (lightsaber == null)
            return Response.status(404).build();

        LightSaberDTO lightSaberDTO = new LightSaberDTO();
        lightSaberDTO.color = lightsaber.getColor();
        lightSaberDTO.sides = lightsaber.getSides();

        return Response.status(200).entity(lightSaberDTO).build();
    }

    @GET
    @Path("customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJedi(@PathParam("id") int id) {
        Jedi jedi = IJediDAO.getJedi(id);
        if (jedi == null)
            return Response.status(404).build();

        JediDTO jediDTO = new JediDTO();
        jediDTO.customerId = jedi.getCustomerId();
        jediDTO.name = jedi.getName();

        return Response.status(200).entity(jediDTO).build();
    }

    //Hiermee injecteer ik de implementatie van de Interface,
    //Omdat er twee verschillende Interface implementaties zijn, moet ik er een @Default maken, en de rest @Alternative
    //Als er dus meer dan 1 Interface is, moet ik in webapp/WEB-INF/beans.xml aangeven welke Interface ik wil gebruiken.
    @Inject
    public void setILightsaberDAO(ILightsaberDAO ILightsaberDAO) {
        this.ILightsaberDAO = ILightsaberDAO;
    }

    @Inject
    public void setJediDAO(IJediDAO IJediDAO) {
        this.IJediDAO = IJediDAO;
    }
}
