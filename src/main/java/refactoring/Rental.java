package refactoring;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public static Rental.Builder builder(Movie movie) {
		return new Builder(movie);
	}

	public static class Builder {
		private Movie movie;
		private int days;

		public Rental build() {
			Rental rental = new Rental();
			rental._movie = movie;
			rental._daysRented = days;

			return rental;
		}

		public Builder days(int days) {
			this.days = days;
			return this;
		}

		private Builder(Movie movie) {
			days = 1;
			this.movie = movie;
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

	private Rental() {}
}
