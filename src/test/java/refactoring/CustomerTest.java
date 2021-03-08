package refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void considerCustomerWithoutRentals() {
		Customer customer = new Customer("mario");
		assertEquals(customer.statement(), "Rental Record for mario\nAmount owed is 0.0\nYou earned 0 frequent renter points");
	}

	@Test
	public void considerCustomerWithARegularMovieRental() {
		Customer customer = new Customer("mario");
		Movie movie = new Movie("The movie", 0);
		customer.addRental(new Rental(movie, 1));
		assertEquals(
			customer.statement(),
			"Rental Record for mario\n"
			+ "\tThe movie\t2.0\n"
			+ "Amount owed is 2.0\n"
			+ "You earned 1 frequent renter points");
	}

	@Test
	public void considerCustomerWithTwoRegularMoviesRentals() {
		Customer customer = new Customer("mario");
		Movie movie = new Movie("The movie", 0);
		Movie movie2 = new Movie("Another movie", 0);
		customer.addRental(new Rental(movie, 1));
		customer.addRental(new Rental(movie2, 1));
		assertEquals(
			customer.statement(),
			"Rental Record for mario\n"
			+ "\tThe movie\t2.0\n"
			+ "\tAnother movie\t2.0\n"
			+ "Amount owed is 4.0\n"
			+ "You earned 2 frequent renter points");
	}

	@Test
	public void considerCustomerWithANewReleaseMovieRental() {
		Customer customer = new Customer("mario");
		Movie movie = new Movie("The movie 2", 1);
		customer.addRental(new Rental(movie, 1));
		assertEquals(
			customer.statement(),
			"Rental Record for mario\n"
			+ "\tThe movie 2\t3.0\n"
			+ "Amount owed is 3.0\n"
			+ "You earned 1 frequent renter points");
	}

	@Test
	public void considerCustomerWithANewReleaseMovieRentalTwoDaysLong() {
		Customer customer = new Customer("mario");
		Movie movie = new Movie("The new movie", 1);
		customer.addRental(new Rental(movie, 2));
		assertEquals(
			customer.statement(),
			"Rental Record for mario\n"
			+ "\tThe new movie\t6.0\n"
			+ "Amount owed is 6.0\n"
			+ "You earned 2 frequent renter points");
	}

	@Test
	public void considerCustomerWithAChildrenMovieRental() {
		Customer customer = new Customer("mario");
		Movie movie = new Movie("The children animation movie", 2);
		customer.addRental(new Rental(movie, 1));
		assertEquals(
			customer.statement(),
			"Rental Record for mario\n"
			+ "\tThe children animation movie\t1.5\n"
			+ "Amount owed is 1.5\n"
			+ "You earned 1 frequent renter points");
	}

}
