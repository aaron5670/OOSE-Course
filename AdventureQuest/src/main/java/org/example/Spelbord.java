package org.example;

import java.util.ArrayList;

public class Spelbord {
    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();
    private int aantalVakjes;

    public Spelbord(int aantalVakjes) {
        this.aantalVakjes = aantalVakjes;
        maakVakjesAan();
    }

    private void maakVakjesAan() {
        for (int i = 0; i < aantalVakjes; i++) {
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
                    k.getVakje().setKarakter(null);

                    //Zet speler op het nieuwe vakje
                    k.setVakje(vakje);

                    //Verminder energie
                    verminderEnergie(k,20);

                    System.out.println(k.getNaam() + " is geteleporteerd naar " + vaknr + ", energie is nu " + k.getEnergie());
                    vrijeVakjes();
                    System.out.println("------------");
                } else {
                    System.out.println("Vakje " + vaknr + " is al bezet door een andere speler!");
                }
            }
        }
    }

    public void wisselVakje(Karakter k, int doelVak) {
        for (Vakje vakje : vakjes) {
            if (doelVak == vakje.getVaknr()) {
                if (vakje.getKarakter() != null) {
                    if (k.getVakje().getVaknr() == doelVak) {
                        System.out.println("Je staat zelf al op dit vakje!");
                        break;
                    }

                    if (k.getEnergie() >= 20) {
                        Karakter huidigeSpeler = vakje.getKarakter();
                        huidigeSpeler.setVakje(k.getVakje());
                        k.setVakje(vakje);

                        //Verminder energie
                        verminderEnergie(k, 20);
                        System.out.println(k.getNaam() + " is gewisseld, energie is: " + k.getEnergie());

                        bezetteVakjes();
                        System.out.println("------------");
                    }else {
                        System.out.println("Initiatiefnemende speler heeft te weinig energie om te wisselen!");
                    }
                } else {
                    System.out.println("Op vakje " + doelVak + " staat geen speler!");
                }
            }
        }
    }

    private void verminderEnergie(Karakter k, int energie) {
        k.setEnergie(k.getEnergie() - energie);
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
