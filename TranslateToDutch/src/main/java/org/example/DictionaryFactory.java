package org.example;

public class DictionaryFactory {
    private static DictionaryFactory instance;

    private DictionaryFactory() {

    }

    public IDictionary createDictionary(DictionaryType dictionaryType) {
        switch (dictionaryType) {
            case KOENEN:
                return new KoenenDictionaryAdapter();

            case KRAMERS:
                return new KramersDictionaryAdapter();

            default:
                return null;
        }
    }

    public static DictionaryFactory getInstance() {
        if (instance == null)
            return new DictionaryFactory();

        return instance;
    }
}
