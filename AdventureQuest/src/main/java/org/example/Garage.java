package org.example;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Vervoermiddel> garage = new ArrayList<Vervoermiddel>();
    
    public Garage() {

    }

    public void zetVervoermiddelInGarage(Vervoermiddel vervoermiddel) {
        garage.add(vervoermiddel);
    }

    public Vervoermiddel getVervoermiddel() {
        return garage.get(1);
    }
}
