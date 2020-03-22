package org.example;

import org.example.voertuigen.Auto;
import org.example.voertuigen.Fiets;
import org.example.voertuigen.Scooter;
import org.example.voertuigen.Step;

public class VoertuigenFactory {

    public IVervoermiddel createVervoermiddel(String voertuigtype) {
        switch (voertuigtype) {
            case "Auto":
                return new Auto();

            case "Fiets":
                return new Fiets();

            case "Scooter":
                return new Scooter();

            case "Step":
                return new Step();

            default:
                return null;
        }
    }
}
