package org.example;

public class Garage {
    VoertuigenFactory voertuigFactory = new VoertuigenFactory();

    // ... other code ...

    public IVervoermiddel createVervoermiddel(String voertuigtype) {
        return voertuigFactory.createVervoermiddel(voertuigtype);
    }
}
