package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer _customer;

	@Before
	public void setUp(){
		_customer = new Customer("mario");
	}

	@Test
	public void statementHaveCustomerNameInHeader() {
		assertThat(row(0)).startsWith("Rental Record for");
	}

	@Test
	public void considerCustomerWithoutRentalsAmountLine() {
		assertThat(row(1)).startsWith("Amount owed is");
	}

	@Test
	public void considerCustomerWithoutRentalsPointsLine() {
		assertThat(row(2)).containsSubsequence("You earned", "frequent renter points");
	}

	@Test
	public void statementBodyHaveOneLinePerMovieRented() {
		rent(3);
		assertThat(row(1)).startsWith("\tThe movie");
		assertThat(row(2)).startsWith("\tThe movie");
		assertThat(row(3)).startsWith("\tThe movie");
	}

	@Test
	public void considerCustomerWithThreeRentalsAmountLine() {
		rent(3);
		assertThat(row(4)).startsWith("Amount owed is 6.0");
	}

	@Test
	public void considerCustomerWithThreeRentalsPointsLine() {
		rent(3);
		assertThat(row(5)).startsWith("You earned 3 frequent renter points");
	}

	@Test
	public void considerCustomerWithoutRentals() {
		assertThat(rows()).hasSize(3);
		assertThat(row(0)).isEqualTo("Rental Record for mario");
		assertThat(row(1)).isEqualTo("Amount owed is 0.0");
		assertThat(row(2)).isEqualTo("You earned 0 frequent renter points");
	}

	@Test
	public void considerCustomerWithOneRental() {
		rent(1);
		assertThat(rows()).hasSize(4);
		assertThat(row(0)).isEqualTo("Rental Record for mario");
		assertThat(row(1)).isEqualTo("\tThe movie\t2.0");
		assertThat(row(2)).isEqualTo("Amount owed is 2.0");
		assertThat(row(3)).isEqualTo("You earned 1 frequent renter points");
	}

	@Test
	public void considerCustomerWithThreeRentals() {
		rent(3);

		assertThat(rows()).hasSize(6);
		assertThat(row(1)).isEqualTo("\tThe movie\t2.0");
		assertThat(row(2)).isEqualTo("\tThe movie\t2.0");
		assertThat(row(3)).isEqualTo("\tThe movie\t2.0");
	}

	private String row(int index) {
		return rows().get(index);
	}

	private List<String> rows() {
		return List.of(_customer.statement().split("\n"));
	}

	private void rent(int times) {
		IntStream.range(0, times).forEach(i -> _customer.addRental(new Rental(new Movie("The movie", 0), 1)));
	}
}
