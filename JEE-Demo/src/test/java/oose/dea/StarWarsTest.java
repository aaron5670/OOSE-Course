package oose.dea;

import oose.dea.api.StarWars;
import oose.dea.api.dto.JediDTO;
import oose.dea.api.dto.LightSaberDTO;
import oose.dea.dao.IJediDAO;
import oose.dea.dao.ILightsaberDAO;
import oose.dea.dao.LightsaberExcelDAO;
import oose.dea.domain.Jedi;
import oose.dea.domain.Lightsaber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StarWarsTest {
    private static StarWars starWars;

    @BeforeAll
    public static void setup() {
        starWars = new StarWars();
    }

    @Test
    public void helloTest() {
        String expected = "May the force be with you.";
        assertEquals(expected, starWars.hello());
    }

    @Test
    public void getJediTest() {
        // Setup Mock
        IJediDAO jediDAO = mock(IJediDAO.class);
        Jedi jedi = new Jedi();
        jedi.setName("testJedi");
        jedi.setCustomerId(1);
        jedi.setRank(1);
        jedi.setDarkside(true);
        when(jediDAO.getJedi(1)).thenReturn(jedi);

        starWars.setJediDAO(jediDAO);

        // actual test
        Response response = starWars.getJedi(1);
        JediDTO jediDTO = (JediDTO) response.getEntity();

        assertEquals(200, response.getStatus());
        assertEquals("testJedi", jediDTO.name);
        assertEquals(1, jediDTO.customerId);
    }

    @Test
    public void getJediWithNullTest() {
        // Setup Mock
        IJediDAO jediDAO = mock(IJediDAO.class);
        when(jediDAO.getJedi(13)).thenReturn(null);

        starWars.setJediDAO(jediDAO);

        // actual test
        Response response = starWars.getJedi(13);
        assertEquals(404, response.getStatus());
    }

    @Test
    public void getLightsaberTest() {
        // Setup Mock
        ILightsaberDAO lightsaberDAO = mock(ILightsaberDAO.class);
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setSides(4);
        lightsaber.setColor("green");
        when(lightsaberDAO.getLightsaber()).thenReturn(lightsaber);

        starWars.setILightsaberDAO(lightsaberDAO);

        Response response = starWars.getlightsaber();
        LightSaberDTO lightSaberDTO = (LightSaberDTO) response.getEntity();

        assertEquals(200, response.getStatus());
        assertEquals("green", lightSaberDTO.color);
        assertEquals(4, lightSaberDTO.sides);
    }
}
