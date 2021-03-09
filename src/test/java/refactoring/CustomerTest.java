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
		Rental rental = new Rental(_movie, 1);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental)
			);
	}

	@Test
	public void considerCustomerWithARegularMovieRentalThreeDaysLong() {
		Rental rental = new Rental(_movie, 3);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental)
		);
	}

	@Test
	public void considerCustomerWithANewReleaseMovieRental() {
		Rental rental = new Rental(_newReleaseMovie, 1);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental)
		);
	}

	@Test
	public void earnDoublePointsWithNewReleaseRentalForMoreThanOneDay() {
		Rental rental = new Rental(_newReleaseMovie, 2);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental)
		);
	}

	@Test
	public void considerCustomerWithAChildrenMovieRental() {
		Rental rental = new Rental(_childrensMovie, 1);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental));
	}

	@Test
	public void considerCustomerWithAChildrenMovieRentalFourDaysLong() {
		Rental rental = new Rental(_childrensMovie, 4);
		_customer.addRental(rental);
		assertEquals(
			_customer.statement(),
			generateStatementWith(_customer, rental));
	}

	private String generateStatementWith(Customer customer, Rental rental) {
		return Stream.of(
			String.format("Rental Record for %s", customer.getName()),
			String.format("\tThe movie\t%s", rental.getCharge()),
			String.format("Amount owed is %s", rental.getMovie().getCharge(rental.getDaysRented())),
			String.format("You earned %s frequent renter points", rental.getMovie().getFrequentRenterPoints(rental.getDaysRented()))
		).collect(Collectors.joining("\n"));
	}

}
