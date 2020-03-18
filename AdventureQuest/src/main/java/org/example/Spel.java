package org.example;

import java.util.ArrayList;

public class Spel {
    private ArrayList<Karakter> karakters = new ArrayList<>();
    private Spelbord bord = new Spelbord();
    private Garage garage = new Garage();

    public void meldAan(String naamKarakter) {
        Karakter k = new Karakter(naamKarakter);

        karakters.add(k);
        bord.plaatsOpVrijVakje(k);
    }

    public void teleporteer(String naamKarakter, int doelVak) {
        for (Karakter karakter : karakters) {
            if (naamKarakter.equals(karakter.getNaam())) {
                bord.teleporteer(karakter, doelVak);
            }
        }
    }

    public void wisselVakje(String naamKarakter, int vaknr) {
        for (Karakter karakter : karakters) {
            if (naamKarakter.equals(karakter.getNaam())) {
                bord.wisselVakje(karakter, vaknr);
            }
        }
    }
}