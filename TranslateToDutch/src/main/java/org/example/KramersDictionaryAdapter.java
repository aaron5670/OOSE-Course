package org.example;

import nl.oose.dea.koenenkramers.KoenenDictionary;
import nl.oose.dea.koenenkramers.KramersDictionary;

public class KramersDictionaryAdapter implements IDictionary {
    private KramersDictionary kramersDictionary = new KramersDictionary();

    public String translate(String word) {
        return kramersDictionary.find(word);
    }

    public String getType() {
        return "KRAMERS";
    }
}
