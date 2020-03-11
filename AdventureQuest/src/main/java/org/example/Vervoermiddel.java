package org.example;

public class Vervoermiddel {
    private Garage garage;

    public void zetVervoermiddelInGarage() {
        garage.zetVervoermiddelInGarage(this);
    }

    public Vervoermiddel haalVervoermiddelUitGarage() {
        return garage.getVervoermiddel();
    }
}
