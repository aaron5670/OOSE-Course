package org.example;

public class TranslateToDutch {
    private final DictionaryFactory dictionaryFactory = DictionaryFactory.getInstance();

    public String translate(String word) {
        IDictionary[] dictionaries = new IDictionary[]{
                dictionaryFactory.createDictionary(DictionaryType.KOENEN),
                dictionaryFactory.createDictionary(DictionaryType.KRAMERS)
        };

        for (IDictionary d : dictionaries) {
            String translation = d.translate(word);
            if (translation != null) {
                return d.getType() + ": " + translation;
            }
        }

        return "Vertaling niet gevonden voor:" + word;
    }
}
