package refactoring;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer _customer;
	private Movie _movie, _newReleaseMovie, _childrensMovie;

	@Before
	public void setUp(){
		_customer = new Customer("mario");
		_movie = new Movie("The movie", 0);
		_newReleaseMovie = new Movie("The movie", 1);
		_childrensMovie = new Movie("The movie", 2);
	}

	@Test
	public void considerCustomerWithoutRentals() {
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"Amount owed is 0.0",
				"You earned 0 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithARegularMovieRental() {
		_customer.addRental(new Rental(_movie, 1));
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t2.0",
				"Amount owed is 2.0",
				"You earned 1 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithTwoRegularMoviesRentals() {
		_customer.addRental(new Rental(_movie, 1));
		_customer.addRental(new Rental(_movie, 1));
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t2.0",
				"\tThe movie\t2.0",
				"Amount owed is 4.0",
				"You earned 2 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithANewReleaseMovieRental() {
		_customer.addRental(new Rental(_newReleaseMovie, 1));
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t3.0",
				"Amount owed is 3.0",
				"You earned 1 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithANewReleaseMovieRentalTwoDaysLong() {
		_customer.addRental(new Rental(_newReleaseMovie, 2));
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t6.0",
				"Amount owed is 6.0",
				"You earned 2 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithAChildrenMovieRental() {
		_customer.addRental(new Rental(_childrensMovie, 1));
		assertEquals(
			_customer.statement(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t1.5",
				"Amount owed is 1.5",
				"You earned 1 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

}
