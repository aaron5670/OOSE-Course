package ooad.aaron;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class MovieTest {

    private static Movie movieA;
    private static Movie movieB;
    private static Movie movieC;

    @BeforeAll
    public static void init(){
        movieA = new Movie("Homeland", 2002, 1);
        movieB = new Movie("The Apes", 2010, 2);
        movieC = new Movie("The Rampage", 1998, 3);
    }

    @Test
    public void regularMovieChargeTest() {
        assertEquals(4.5, movieA.getCharge(5));
        assertEquals(1.5, movieA.getCharge(3));
    }

    @Test
    public void childrenMovieChargeTest() {
        assertEquals(15, movieB.getCharge(5));
        assertEquals(9, movieB.getCharge(3));
    }

    @Test
    public void newReleaseMovieChargeTest() {
        assertEquals(3, movieC.getCharge(5));
        assertEquals(1.5, movieC.getCharge(3));
    }
}
