package org.example;

public class Karakter {
    private String naam;
    private int energie = 1000;
    private Vakje vakje;
    private Vervoermiddel vervoermiddel;

    public Karakter(String naam) {
        this.naam = naam;
        vervoermiddel = new Vervoermiddel();
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

    void verminderEnergie(int energie) {
        setEnergie(getEnergie() - energie);
    }
}