package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class HtmlStatementTest {

	private Customer _customer;

	@Before
	public void setUp(){
		_customer = new Customer("mario");
	}

	@Test
	public void customerNameInHeader() {
		assertThat(row(0)).startsWith("<H1>Rentals for <EM>");
	}

	@Test
	public void noRentalsAmountLine() {
		assertThat(row(1)).startsWith("<P>You owe <EM>");
	}

	@Test
	public void noPointsLine() {
		assertThat(row(2)).containsSubsequence("On this rental you earned <EM>", "</EM> frequent renter points<P>");
	}

	@Test
	public void oneLinePerMovieRented() {
		rent(3);
		assertThat(row(1)).startsWith("The movie:");
		assertThat(row(2)).startsWith("The movie:");
		assertThat(row(3)).startsWith("The movie:");
	}

	@Test
	public void threeRentalsAmountLine() {
		rent(3);
		assertThat(row(4)).startsWith("<P>You owe <EM>");
	}

	@Test
	public void threeRentalsPointsLine() {
		rent(3);
		assertThat(row(5)).isEqualTo("On this rental you earned <EM>3</EM> frequent renter points<P>");
	}

	@Test
	public void noRentalsStatement() {
		assertThat(rows()).hasSize(3);
		assertThat(row(0)).isEqualTo("<H1>Rentals for <EM>mario</EM></H1><P>");
		assertThat(row(1)).isEqualTo("<P>You owe <EM>0.0</EM><P>");
		assertThat(row(2)).isEqualTo("On this rental you earned <EM>0</EM> frequent renter points<P>");
	}

	@Test
	public void oneRentalStatement() {
		rent(1);
		assertThat(rows()).hasSize(4);
		assertThat(row(0)).isEqualTo("<H1>Rentals for <EM>mario</EM></H1><P>");
		assertThat(row(1)).isEqualTo("The movie: 2.0<BR>");
		assertThat(row(2)).isEqualTo("<P>You owe <EM>2.0</EM><P>");
		assertThat(row(3)).isEqualTo("On this rental you earned <EM>1</EM> frequent renter points<P>");
	}

	@Test
	public void threeRentalsStatement() {
		rent(3);
		assertThat(rows()).hasSize(6);
		assertThat(row(1)).isEqualTo("The movie: 2.0<BR>");
		assertThat(row(2)).isEqualTo("The movie: 2.0<BR>");
		assertThat(row(3)).isEqualTo("The movie: 2.0<BR>");
	}

	private String row(int index) {
		return rows().get(index);
	}

	private List<String> rows() {
		String statement = new HtmlStatement().value(_customer);
		return List.of(statement.split("\n"));
	}

	private void rent(int times) {
		IntStream.range(0, times).forEach(i -> _customer.addRental(Rental.builder(new Movie("The movie", 0)).days(1).build()));
	}
}

