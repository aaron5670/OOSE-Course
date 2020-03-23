package org.example;

import nl.oose.dea.koenenkramers.KoenenDictionary;

public class KoenenDictionaryAdapter implements IDictionary {
    private KoenenDictionary koenenDictionary = new KoenenDictionary();

    public KoenenDictionaryAdapter() {
        koenenDictionary.openEnglishDutch();
    }

    public String translate(String word) {
        return koenenDictionary.lookUp(word);
    }

    public String getType() {
        return "KOENEN";
    }
}
