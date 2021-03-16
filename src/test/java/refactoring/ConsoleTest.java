package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import refactoring.console.Console;

public class ConsoleTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	public void RegularMovieOneDayRental() {
		Console console = new Console("Mario", "The movie asd", "0", "1");
		console.execute();
		assertThat(outputStream.toString().split("\n").length).isEqualTo(4);
	}

	@Test
	public void statementWithManyMovies() {
		Console console = new Console("mario", "The movie", "0", "1", "The movie 2", "1", "1");
		console.execute();
		assertThat(outputStream.toString().split("\n").length).isEqualTo(5);
	}

	@Test
	public void statementWithoutMovies() {
		Console console = new Console("mario");
		console.execute();
		assertThat(outputStream.toString().split("\n").length).isEqualTo(3);
	}

	@Test
	public void statementWithWrongParameters() {
		Console console = new Console("mario", "the movie", "not a number", "2");
		console.execute();
		assertThat(outputStream.toString()).isEqualTo("Please check rental parameters and try again\n");
	}
}
