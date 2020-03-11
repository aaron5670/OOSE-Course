package org.example;

public class Karakter {
    private String naam;
    private int energie = 1000;
    private Vervoermiddel vervoermiddel;

    public Karakter(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public void verminderEnergie(int energie) {
        setEnergie(getEnergie() - energie);
    }

    public void haalVervoermiddelUitGarage() {
        this.vervoermiddel = vervoermiddel.haalVervoermiddelUitGarage();
    }

    public Vervoermiddel getVervoermiddel() {
        return vervoermiddel;
    }
}