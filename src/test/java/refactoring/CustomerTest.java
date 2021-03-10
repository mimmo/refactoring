package refactoring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer _customer;
	private Movie _movie;

	private void customerWithRentals(int rentalsNumber) {
		IntStream.range(0, rentalsNumber).forEach( i -> _customer.addRental(new Rental(_movie, 1)));
	}

	@Before
	public void setUp(){
		_customer = new Customer("mario");
		_movie = new Movie("The movie", 0);
	}

	@Test
	public void statementHaveCustomerNameInHeader() {
		assertEquals(
			new CustomerStatement().header(),
			"Rental Record for mario"
		);
	}

	@Test
	public void considerCustomerWithoutRentalsAmountLine() {
		assertEquals(
			new CustomerStatement().amountLine(),
				"Amount owed is 0.0"
			);
	}

	@Test
	public void considerCustomerWithoutRentalsPointsLine() {
		assertEquals(
			new CustomerStatement().pointsLine(),
				"You earned 0 frequent renter points"
			);
	}

	@Test
	public void statementBodyHaveOneLinePerMovieRented() {
		customerWithRentals(3);

		assertEquals(
			new CustomerStatement().body(),
			Stream.of(
				"\tThe movie\t2.0",
				"\tThe movie\t2.0",
				"\tThe movie\t2.0"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithThreeRentalsAmountLine() {
		customerWithRentals(3);

		assertEquals(
			new CustomerStatement().amountLine(),
			"Amount owed is 6.0"
		);
	}

	@Test
	public void considerCustomerWithThreeRentalsPointsLine() {
		customerWithRentals(3);

		assertEquals(
			new CustomerStatement().pointsLine(),
			"You earned 3 frequent renter points"
		);
	}

	@Test
	public void considerCustomerWithoutRentals() {
		assertEquals(
			new CustomerStatement().generate(),
			Stream.of("Rental Record for mario",
				"Amount owed is 0.0",
				"You earned 0 frequent renter points"
			).collect(Collectors.joining("\n"))
		);
	}

	@Test
	public void considerCustomerWithOneRental() {
		customerWithRentals(1);

		assertEquals(
			new CustomerStatement().generate(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t2.0",
				"Amount owed is 2.0",
				"You earned 1 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	@Test
	public void considerCustomerWithThreeRentals() {
		customerWithRentals(3);

		assertEquals(
			new CustomerStatement().generate(),
			Stream.of("Rental Record for mario",
				"\tThe movie\t2.0",
				"\tThe movie\t2.0",
				"\tThe movie\t2.0",
				"Amount owed is 6.0",
				"You earned 3 frequent renter points"
			).collect(Collectors.joining("\n")));
	}

	private class CustomerStatement {
		private String _header;
		private String _body;
		private String _amount;
		private String _points;

		public CustomerStatement() {
			String[] data = _customer.statement().split("\n");

			_header = data[0];
			_body = String.join("\n", Arrays.copyOfRange(data, 1, data.length - 2));
			_amount = data[data.length - 2];
			_points = data[data.length - 1];
		}

		public String header() {
			return _header;
		}

		public String body() {
			return _body;
		}

		public String amountLine() {
			return _amount;
		}

		public String pointsLine() {
			return _points;
		}

		public String generate() {
			return Stream.of(
				_header,
				_body,
				_amount,
				_points
			).filter(s -> !s.isEmpty()).collect(Collectors.joining("\n"));
		}
	}
}
