package org.example;

public class Garage {
    // ... other code ...

    public IVervoermiddel createVervoermiddel(String voertuigtype) {
        VoertuigenFactory voertuigFactory = new VoertuigenFactory();
        return voertuigFactory.createVervoermiddel(voertuigtype);
    }
}
