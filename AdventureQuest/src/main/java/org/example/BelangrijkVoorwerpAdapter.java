package org.example;

public class BelangrijkVoorwerpAdapter extends RondVoorwerp {
    private BelangrijkVoorwerp belangrijkVoorwerp;

    public BelangrijkVoorwerpAdapter(BelangrijkVoorwerp belangrijkVoorwerp) {
        this.belangrijkVoorwerp = belangrijkVoorwerp;
    }

    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow((belangrijkVoorwerp.getWidth() / 2), 2) * 2)); // <-- Niet getest of het ook echt werkt..
    }
}
