package ooad.aaron;

public class Movie {
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;
    public static final int CHILDREN = 3;

    private String title;
    private int releaseyear;
    private int pricecode;
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
