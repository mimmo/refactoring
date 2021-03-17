package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import refactoring.console.Console;

public class ExecutionTest {
	private ByteArrayOutputStream out;
	private PrintStream consoleOut;

	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		consoleOut = new PrintStream(out);
	}

	@Test
	public void RegularMovieOneDayRental() {
		Console console = new Console(consoleOut, "Mario", "The movie asd", "0", "1");
		console.execute();
		assertThat(out.toString()).isEqualTo(
			"Rental Record for Mario\n" +
			"	The movie asd	2.0\n" +
			"Amount owed is 2.0\n" +
			"You earned 1 frequent renter points\n"
		);
	}

	@Test
	public void statementWithManyMovies() {
		Console console = new Console(consoleOut, "mario", "The movie", "0", "1", "The movie 2", "0", "1");
		console.execute();
		assertThat(out.toString()).isEqualTo(
			"Rental Record for mario\n" +
			"	The movie	2.0\n" +
			"	The movie 2	2.0\n" +
			"Amount owed is 4.0\n" +
			"You earned 2 frequent renter points\n"
		);
	}
}
