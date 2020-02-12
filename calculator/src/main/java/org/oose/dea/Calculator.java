package org.oose.dea;

public class Calculator {
    public int add(int value1, int value2) {
        return value1 + value2;
    }

    public int minus(int value1, int value2) {
        return value1 - value2;
    }

    public double divide(double value1, double value2) {
        if (value2 == 0)
            throw new IllegalArgumentException("Delen door nul is flauwekul");
        return value1 / value2;
    }

    public int times(int value1, int value2) {
        return value1 * value2;
    }
}
