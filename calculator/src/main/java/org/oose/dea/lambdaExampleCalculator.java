package org.oose.dea;

public class lambdaExampleCalculator {
    private CustomCalculation customCalculation;

    public static void main(String[] args) {
        lambdaExampleCalculator lambdaCalculator = new lambdaExampleCalculator();

        lambdaCalculator.setCustomCalculation((x, y) -> {
            int z = 100;
            return 2 * x + y + z;
        });

        System.out.println(lambdaCalculator.performCustomCalculation(5, 6));
    }

    /*
    /* Deze twee methodes hieronder zijn nodig voor een Lambda Expression met @FunctionalInterface
     */
    public int performCustomCalculation(int x, int y) {
        return customCalculation.calculate(x, y);
    }

    public void setCustomCalculation(CustomCalculation customCalculation) {
        this.customCalculation = customCalculation;
    }
}
