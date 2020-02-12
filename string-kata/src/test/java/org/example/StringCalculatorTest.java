package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void addEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addSingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void addSum() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(62, stringCalculator.add("12,50"));
        assertEquals(82, stringCalculator.add("12\n50,10\n10"));
        assertEquals(12, stringCalculator.add("6\n6"));
        assertEquals(5, stringCalculator.add("1001\n5"));
        assertEquals(0, stringCalculator.add("2000,1500"));
    }
}
