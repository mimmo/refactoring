package refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
	private Movie _movie, _newReleaseMovie, _childrensMovie;
	private Rental _oneDayRental, _longMovieRental, _newReleaseRental, _longNewReleaseRental, _childrensRental, _longChildrensRental;

	@Before
	public void setUp() throws Exception {
		_movie = new Movie("The movie", 0);
		_oneDayRental = new Rental(_movie, 1);
		_longMovieRental = new Rental(_movie, 5);

		_newReleaseMovie = new Movie("The movie", 1);
		_newReleaseRental = new Rental(_newReleaseMovie, 1);
		_longNewReleaseRental = new Rental(_newReleaseMovie, 5);

		_childrensMovie = new Movie("The movie", 2);
		_childrensRental = new Rental(_childrensMovie, 1);
		_longChildrensRental = new Rental(_childrensMovie, 5);
	}

	// RegularMovie Rental
	@Test
	public void considerRegularMovieRental() {
		assertEquals(rentalCharge(_oneDayRental), 2.0, 0);
	}

	@Test
	public void considerRegularMovieRentalFiveDaysLong() {
		assertEquals(rentalCharge(_longMovieRental), 6.5, 0);
	}

	@Test
	public void earnOnePointWithRegularMovieRental() {
		assertEquals(rentalPoints(_oneDayRental), 1);
	}

	@Test
	public void earnOnePointWithRegularMovieRentalForMoreThanOneDay() {
		assertEquals(rentalPoints(_longMovieRental), 1);
	}

	// NewReleaseMovie Rental
	@Test
	public void considerNewReleaseMovieRental() {
		assertEquals(rentalCharge(_newReleaseRental), 3.0, 0);
	}

	@Test
	public void considerNewReleaseMovieRentalFiveDaysLong() {
		assertEquals(rentalCharge(_longNewReleaseRental), 15.0, 0);
	}

	@Test
	public void earnOnePointWithNewReleaseMovieRental() {
		assertEquals(rentalPoints(_newReleaseRental), 1);
	}

	@Test
	public void earnDoublePointsWithNewReleaseMovieRentalForMoreThanOneDay() {
		assertEquals(rentalPoints(_longNewReleaseRental), 2);
	}

	// ChildrensMovie Rental
	@Test
	public void considerChildrensMovieRental() {
		assertEquals(rentalCharge(_childrensRental), 1.5, 0);
	}

	@Test
	public void considerChildrensMovieRentalFiveDaysLong() {
		assertEquals(rentalCharge(_longChildrensRental), 4.5, 0);
	}

	@Test
	public void earnOnePointWithChildrensMovieRental() {
		assertEquals(rentalPoints(_childrensRental), 1);
	}

	@Test
	public void earnOnePointWithChildrensMovieRentalForMoreThanOneDay() {
		assertEquals(rentalPoints(_longChildrensRental), 1);
	}

	private double rentalCharge(Rental rental) {
		return rental.getMovie().getCharge(rental.getDaysRented());
	}

	private int rentalPoints(Rental rental) {
		return rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
	}
}
