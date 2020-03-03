package oose.dea;

import oose.dea.api.StarWars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
