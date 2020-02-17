package org.example;

import java.util.ArrayList;

public class Spel {
    private ArrayList<Karakter> karakters = new ArrayList<>();
    Spelbord bord = new Spelbord(3);

    public void meldAan(String naamKarakter) {
        System.out.println(naamKarakter + " wordt aangemeld!");
        Karakter k = new Karakter(naamKarakter);
        karakters.add(k);
        bord.plaatsOpVrijVakje(k);
        System.out.println(naamKarakter + " is succesvol aangemeld met " + k.getEnergie() + " energie!\n------------");
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