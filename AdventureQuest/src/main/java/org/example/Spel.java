package org.example;

import java.util.ArrayList;

public class Spel {
    private ArrayList<Karakter> karakters = new ArrayList<>();
    Spelbord bord = new Spelbord();

    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.meldAan("Aaron");
        spel.teleporteer("Aaron", 1);
        spel.teleporteer("Aaron", 2);
        spel.teleporteer("Aaron", 0);
        spel.teleporteer("Aaron", 1);
        spel.teleporteer("Aaron", 0);
        spel.teleporteer("Aaron", 2);
    }

    public void meldAan(String naamKarakter) {
        System.out.println(naamKarakter + " wordt aangemeld!");
        Karakter k = new Karakter(naamKarakter);
        karakters.add(k);
        bord.plaatsOpVrijVakje(k);
        System.out.println(naamKarakter + " is succesvol aangemeld met " + k.getEnergie() + " energie!\n------------");
    }

    public void teleporteer(String naamKarakter, int vaknr) {
        for (Karakter karakter: karakters) {
            if (naamKarakter.equals(karakter.getNaam())) {
                bord.plaatsOpVakje(karakter, vaknr);
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