package ooad.aaron;

public class Movie {
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;
    public static final int CHILDREN = 3;

    private String title;
    private int releaseyear;
    private int pricecode;

    public Movie(String title, int year, int pricecode) {
        this.title = title;
        this.releaseyear = year;
        this.pricecode = pricecode;
    }

    public double getCharge(int daysRented) {
        IMovieType movieType;

        switch (pricecode) {
            case Movie.REGULAR:
                movieType = new Regular();

                break;
            case Movie.NEW_RELEASE:
                movieType = new NewRelease();

                break;
            case Movie.CHILDREN:
                movieType = new Children();
                break;
            default:
                return 0;
        }

        return movieType.getCharge(daysRented);
    }
}
