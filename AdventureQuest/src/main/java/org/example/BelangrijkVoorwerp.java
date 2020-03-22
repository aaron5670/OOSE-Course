package org.example;

/**
 * Dit is een "extern" vierkant voorwerp wat niet past bij onze ronde voorwerpen.
 * Hier moet dus een Adapter voor gemaakt worden.
 */
public class BelangrijkVoorwerp {
    private double width;

    public BelangrijkVoorwerp(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
