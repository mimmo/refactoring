package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(_regularOneDayRental.getCharge()).isEqualTo(2.0);
		assertThat(_regularOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void RegularMovieLongRental() {
		Rental _regularLongRental = new Rental(_regularMovie, 5);
		assertThat(_regularLongRental.getCharge()).isEqualTo(6.5);
		assertThat(_regularLongRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void NewReleaseMovieOneDayRental() {
		Rental _newReleaseOneDayRental = new Rental(_newReleaseMovie, 1);
		assertThat(_newReleaseOneDayRental.getCharge()).isEqualTo(3.0);
		assertThat(_newReleaseOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void NewReleaseMovieLongRental() {
		Rental _newReleaseLongRental = new Rental(_newReleaseMovie, 5);
		assertThat(_newReleaseLongRental.getCharge()).isEqualTo(15.0);
		assertThat(_newReleaseLongRental.getFrequentRenterPoints()).isEqualTo(2);
	}

	@Test
	public void ChildrensMovieOneDayRental() {
		Rental _childrensOneDayRental = new Rental(_childrensMovie, 1);
		assertThat(_childrensOneDayRental.getCharge()).isEqualTo(1.5);
		assertThat(_childrensOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void ChildrensMovieLongRental() {
		Rental _childrensLongRental = new Rental(_childrensMovie, 5);
		assertThat(_childrensLongRental.getCharge()).isEqualTo(4.5);
		assertThat(_childrensLongRental.getFrequentRenterPoints()).isEqualTo(1);
	}
}
