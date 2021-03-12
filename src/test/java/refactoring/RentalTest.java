package refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
	private Movie _regularMovie, _newReleaseMovie, _childrensMovie;
	private Rental _regularOneDayRental, _regularLongRental, _newReleaseOneDayRental, _newReleaseLongRental, _childrensOneDayRental, _childrensLongRental;

	@Before
	public void setUp() throws Exception {
		_regularMovie = new Movie("The movie", 0);
		_regularOneDayRental = new Rental(_regularMovie, 1);
		_regularLongRental = new Rental(_regularMovie, 5);

		_newReleaseMovie = new Movie("The movie", 1);
		_newReleaseOneDayRental = new Rental(_newReleaseMovie, 1);
		_newReleaseLongRental = new Rental(_newReleaseMovie, 5);

		_childrensMovie = new Movie("The movie", 2);
		_childrensOneDayRental = new Rental(_childrensMovie, 1);
		_childrensLongRental = new Rental(_childrensMovie, 5);
	}

	@Test
	public void RegularMovieOneDayRental() {
		assertEquals(rentalCharge(_regularOneDayRental), 2.0, 0);
		assertEquals(rentalPoints(_regularOneDayRental), 1);
	}

	@Test
	public void RegularMovieLongRental() {
		assertEquals(rentalCharge(_regularLongRental), 6.5, 0);
		assertEquals(rentalPoints(_regularLongRental), 1);
	}

	@Test
	public void NewReleaseMovieOneDayRental() {
		assertEquals(rentalCharge(_newReleaseOneDayRental), 3.0, 0);
		assertEquals(rentalPoints(_newReleaseOneDayRental), 1);
	}

	@Test
	public void NewReleaseMovieLongRental() {
		assertEquals(rentalCharge(_newReleaseLongRental), 15.0, 0);
		assertEquals(rentalPoints(_newReleaseLongRental), 2);
	}

	@Test
	public void ChildrensMovieOneDayRental() {
		assertEquals(rentalCharge(_childrensOneDayRental), 1.5, 0);
		assertEquals(rentalPoints(_childrensOneDayRental), 1);
	}

	@Test
	public void ChildrensMovieLongRental() {
		assertEquals(rentalCharge(_childrensLongRental), 4.5, 0);
		assertEquals(rentalPoints(_childrensLongRental), 1);
	}

	private double rentalCharge(Rental rental) {
		return rental.getCharge();
	}

	private int rentalPoints(Rental rental) {
		return rental.getFrequentRenterPoints();
	}
}
