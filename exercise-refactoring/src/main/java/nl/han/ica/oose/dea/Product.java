package nl.han.ica.oose.dea;

public class Product {
    private String code;
    private String color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, String color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    String determineSize() {
        switch (size) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    String getColor() {
        switch (color) {
            case "blue":
                return "blue";
            case "red":
                return "red";
            case "yellow":
                return "yellow";
            default:
                return "no color";
        }
    }
}
