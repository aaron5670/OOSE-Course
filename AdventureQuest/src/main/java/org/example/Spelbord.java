package org.example;

import java.util.ArrayList;

public class Spelbord implements ITypeSpelbord {
    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();
    private int aantalVakjes;

    public Spelbord() {
        this.aantalVakjes = 64;
        maakVakjesAan();
    }

    private void maakVakjesAan() {
        for (int i = 0; i < aantalVakjes; i++) {
            vakjes.add(new Vakje(i));
        }
    }

    public void plaatsOpVrijVakje(Karakter k) {
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() == null) {
                vakje.setKarakter(k);
                break;
            }
        }
    }

    public void teleporteer(Karakter k, int vaknr) {
        vakjes.forEach(vakje -> {
            if (k == vakje.getKarakter() && vaknr != vakje.getVaknr()) {
                vakje.leegVakje();
            } else if (vaknr == vakje.getVaknr()) {
                if (vakje.getKarakter() == null) {
                    vakje.setKarakter(k);
                    k.verminderEnergie(20);
                } else {
                    System.out.println("Vakje " + vaknr + " is al bezet door een andere speler!");
                }
            }
        });

        //For testing purpose
        vrijeVakjes();
    }

    public void wisselVakje(Karakter k, int targetVak) {
        if (k.getEnergie() >= 20) {
            Karakter targetKarakter = null;
            for (Vakje v : vakjes) {
                if (v.getVaknr() == targetVak) {
                    targetKarakter = v.getKarakter();
                    v.setKarakter(k);
                }
            }
            for (Vakje v : vakjes) {
                if (k == v.getKarakter() && v.getVaknr() != targetVak) {
                    v.setKarakter(targetKarakter);
                }
            }

            k.verminderEnergie(20);
        }

        //For testing purpose
        bezetteVakjes();
    }

    @Override
    public Vakje getVakje(int i) {
        return null;
    }

    /**
     * For testing purpose
     */
    private void vrijeVakjes() {
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() == null) {
                System.out.println("vakje " + vakje.getVaknr() + " is nu vrij!");
            }
        }
    }

    /**
     * For testing purpose
     */
    private void bezetteVakjes() {
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() != null) {
                System.out.println("vakje " + vakje.getVaknr() + " is bezet door  " + vakje.getKarakter().getNaam());
            }
        }
    }
}
