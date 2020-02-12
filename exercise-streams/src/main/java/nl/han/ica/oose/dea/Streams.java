package nl.han.ica.oose.dea;
import nl.han.ica.oose.dea.helpers.Product;
import java.util.List;
import java.util.stream.Collectors;

class Streams {

    List<String> filterStringsLongerThanThreeCharacters(List<String> input) {
        return input.stream().filter(string -> string.length() < 3).collect(Collectors.toList());
    }

    List<String> filterStringsThanContainOnlyNumerals(List<String> input) {
        return input.stream().filter(string -> string.matches("[0-9]+")).collect(Collectors.toList());
    }

    String findShortestString(List<String> input) {
        // implement
        return input.stream().reduce(String.valueOf(0), (i, string) -> {
            if (i.length() < string.length())
                string = i;

            return string;
        });
    }

    String createAFullSentenceFromTheList(List<String> input) {
        return input.stream().collect(Collectors.joining(" "));
    }

    int calculateTotalCostOfAllProducts(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).sum();
    }
}
