package ooad.aaron;

public interface IMovieType {
    /**
     *
     * @param daysRented total days rented
     * @return movieType.getCharge(daysRented)
     */
    double getCharge(int daysRented);
}
