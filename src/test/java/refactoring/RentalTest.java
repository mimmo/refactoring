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
		Rental regularOneDayRental = Rental.builder(_regularMovie).build();
		assertThat(regularOneDayRental.getCharge()).isEqualTo(2.0);
		assertThat(regularOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void RegularMovieLongRental() {
		Rental regularLongRental = Rental.builder(_regularMovie).days(5).build();
		assertThat(regularLongRental.getCharge()).isEqualTo(6.5);
		assertThat(regularLongRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void NewReleaseMovieOneDayRental() {
		Rental newReleaseOneDayRental = Rental.builder(_newReleaseMovie).build();
		assertThat(newReleaseOneDayRental.getCharge()).isEqualTo(3.0);
		assertThat(newReleaseOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void NewReleaseMovieLongRental() {
		Rental newReleaseLongRental = Rental.builder(_newReleaseMovie).days(5).build();
		assertThat(newReleaseLongRental.getCharge()).isEqualTo(15.0);
		assertThat(newReleaseLongRental.getFrequentRenterPoints()).isEqualTo(2);
	}

	@Test
	public void ChildrensMovieOneDayRental() {
		Rental childrensOneDayRental = Rental.builder(_childrensMovie).build();
		assertThat(childrensOneDayRental.getCharge()).isEqualTo(1.5);
		assertThat(childrensOneDayRental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void ChildrensMovieLongRental() {
		Rental childrensLongRental = Rental.builder(_childrensMovie).days(5).build();
		assertThat(childrensLongRental.getCharge()).isEqualTo(4.5);
		assertThat(childrensLongRental.getFrequentRenterPoints()).isEqualTo(1);
	}
}
