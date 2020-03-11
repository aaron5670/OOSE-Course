package ooad.aaron;

public class Movie {
    private String title;
    private int releaseyear;
    private IMovieType movieType;

    public Movie(String title, int year, IMovieType movieType) {
        this.title = title;
        this.releaseyear = year;
        this.movieType = movieType;
    }

    public double getCharge(int daysRented) {
        return movieType.getCharge(daysRented);
    }
}
