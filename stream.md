# 📓 Aantekeningen

## Stream voorbeelden
**Filter langer dan 3 karakters**

 List<String> filterStringsLongerThanThreeCharacters(List<String> input) {
        return input.stream().filter(string -> string.length() <= 3).collect(Collectors.toList());
    }
                                                                                                 
**Filter string met alleen nummbers**
                                                                                                 
    List<String> filterStringsThanContainOnlyNumerals(List<String> input) {
        return input.stream()
                .filter(string -> string
                        .matches("[0-9]+"))
                .collect(Collectors.toList());
    }
    
 
**haal de kortste string er uit**

    String findShortestString(List<String> input) {
        return input.stream().reduce(" ", (i, result) -> {
            if (i.length() < result.length())
                result = i;

            return result;
        });
    }

**Plak alle items uit array aan mekaar**

    String createAFullSentenceFromTheList(List<String> input) {
        return input.stream().map(n -> n.toString()).collect(Collectors.joining(" "));
    }
 
**Tell alles bij elkaar op**

    int calculateTotalCostOfAllProducts(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).reduce(0, (p1, p2) -> p1+ p2);
    }
