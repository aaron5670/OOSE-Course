package org.example;

import java.util.ArrayList;

public class Spelbord {
    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();

    public Spelbord() {
        maakVakjesAan();
    }

    private void maakVakjesAan() {
        for (int i = 0; i < 3; i++) {
            vakjes.add(new Vakje(i));
        }
    }

    public void plaatsOpVrijVakje(Karakter k) {
        Vakje v = kiesVrijVakje();

        if (v != null) {
            k.setVakje(v);
            System.out.println(k.getNaam() + " is geplaatst op een vrij vakje!");
        } else {
            System.out.println("Er zijn geen vrije vakjes meer!");
        }
    }

    public void plaatsOpVakje(Karakter k, int vaknr) {
        for (Vakje vakje : vakjes) {
            if (vaknr == vakje.getVaknr()) {
                if (vakje.getKarakter() == null) {
                    //vrijeVakjes();

                    //Verwijder speler het oude vakje
                    Vakje oudeVakje = k.getVakje();
                    oudeVakje.setKarakter(null);

                    //Zet speler op het nieuwe vakje
                    vakje.setKarakter(k);

                    //Verander energie
                    k.setEnergie(k.getEnergie() - 20);

                    System.out.println(k.getNaam() + " is geteleporteerd naar " + vaknr + ", energie is nu " + k.getEnergie());
                    vrijeVakjes();
                    System.out.println("------------");
                } else {
                    System.out.println("Vakje " + vaknr + " is al bezet door een andere speler!");
                }
            }
        }
    }

    private void vrijeVakjes() {
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() == null) {
                System.out.println("vakje " + vakje.getVaknr() + " is vrij!");
            }
        }
    }

    private Vakje kiesVrijVakje() {
        System.out.println("Controleren of er nog een vrij vakje is...");
        Vakje v = null;
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() == null) {
                v = vakje;
                break;
            }
        }
        return v;
    }
}
