package ooad.aaron;

public class Regular implements IMovieType {

    @Override
    public double getCharge(int daysRented) {
        if (daysRented > 2) {
            return (daysRented - 2) * 1.5;
        }
        else {
            return 2;
        }
    }
}
