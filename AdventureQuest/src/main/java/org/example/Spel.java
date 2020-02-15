package org.example;

import java.util.ArrayList;

public class Spel {
    private ArrayList<Karakter> karakters = new ArrayList<>();
    Spelbord bord = new Spelbord(3);

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.meldAan("Aaron");
        spel.meldAan("John");

        spel.teleporteer("Aaron", 2);
        spel.wisselVakje("Aaron", 1);
        spel.wisselVakje("Aaron", 2);
        spel.teleporteer("John", 0);
        spel.wisselVakje("John", 2);
        spel.wisselVakje("John", 2); // <-- error
    }

    public void meldAan(String naamKarakter) {
        System.out.println(naamKarakter + " wordt aangemeld!");
        Karakter k = new Karakter(naamKarakter);
        karakters.add(k);
        bord.plaatsOpVrijVakje(k);
        System.out.println(naamKarakter + " is succesvol aangemeld met " + k.getEnergie() + " energie!\n------------");
    }

    public void teleporteer(String naamKarakter, int doelVak) {
        for (Karakter karakter: karakters) {
            if (naamKarakter.equals(karakter.getNaam())) {
                bord.plaatsOpVakje(karakter, doelVak);
            }
        }
    }

    public void wisselVakje(String naamKarakter, int vaknr) {
        for (Karakter karakter: karakters) {
            if (naamKarakter.equals(karakter.getNaam())) {
                bord.wisselVakje(karakter, vaknr);
            }
        }
    }

    public Karakter getKarakter(String naam) {
        for (Karakter k : karakters) {
            if (naam.equals(k.getNaam())) {
                return k;
            }
        }
        return null;
    }
}