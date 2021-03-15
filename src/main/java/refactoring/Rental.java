package refactoring;

public class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;

		if (_daysRented <= 0) {
		    throw new IllegalArgumentException("Days must be greater than 0!");
		}
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}

	public int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
