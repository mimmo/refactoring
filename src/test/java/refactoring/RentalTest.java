package refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
	private Movie _childrensMovie, _newReleaseMovie, _regularMovie;

	@Before
	public void setUp() throws Exception {
		_regularMovie = new Movie("The movie", 0);
		_newReleaseMovie = new Movie("The movie", 1);
		_childrensMovie = new Movie("The movie", 2);
	}

	@Test
	public void RegularMovieOneDayRental() {
		Rental _regularOneDayRental = new Rental(_regularMovie, 1);
		assertEquals(_regularOneDayRental.getCharge(), 2.0, 0);
		assertEquals(_regularOneDayRental.getFrequentRenterPoints(), 1);
	}

	@Test
	public void RegularMovieLongRental() {
		Rental _regularLongRental = new Rental(_regularMovie, 5);
		assertEquals(_regularLongRental.getCharge(), 6.5, 0);
		assertEquals(_regularLongRental.getFrequentRenterPoints(), 1);
	}

	@Test
	public void NewReleaseMovieOneDayRental() {
		Rental _newReleaseOneDayRental = new Rental(_newReleaseMovie, 1);
		assertEquals(_newReleaseOneDayRental.getCharge(), 3.0, 0);
		assertEquals(_newReleaseOneDayRental.getFrequentRenterPoints(), 1);
	}

	@Test
	public void NewReleaseMovieLongRental() {
		Rental _newReleaseLongRental = new Rental(_newReleaseMovie, 5);
		assertEquals(_newReleaseLongRental.getCharge(), 15.0, 0);
		assertEquals(_newReleaseLongRental.getFrequentRenterPoints(), 2);
	}

	@Test
	public void ChildrensMovieOneDayRental() {
		Rental _childrensOneDayRental = new Rental(_childrensMovie, 1);
		assertEquals(_childrensOneDayRental.getCharge(), 1.5, 0);
		assertEquals(_childrensOneDayRental.getFrequentRenterPoints(), 1);
	}

	@Test
	public void ChildrensMovieLongRental() {
		Rental _childrensLongRental = new Rental(_childrensMovie, 5);
		assertEquals(_childrensLongRental.getCharge(), 4.5, 0);
		assertEquals(_childrensLongRental.getFrequentRenterPoints(), 1);
	}
}
