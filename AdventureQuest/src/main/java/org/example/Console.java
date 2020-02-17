package org.example;

public class Console {

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.meldAan("Aaron");
        spel.meldAan("John");

        spel.wisselVakje("Aaron", 1);
        spel.teleporteer("Aaron", 2);
    }
}
