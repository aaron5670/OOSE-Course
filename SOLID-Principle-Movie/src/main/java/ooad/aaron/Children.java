package ooad.aaron;

public class Children implements IMovieType {

    @Override
    public double getCharge(int daysRented) {
        if (daysRented > 3) {
            return (daysRented - 3) * 1.5;
        }
        else {
            return 1.5;
        }
    }
}
