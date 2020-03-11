package ooad.aaron;

public class NewRelease implements IMovieType {

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
