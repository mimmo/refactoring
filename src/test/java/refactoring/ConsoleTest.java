package refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import refactoring.console.Console;

public class ConsoleTest {
	private ByteArrayOutputStream out;
	private PrintStream consoleOut;

	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		consoleOut = new PrintStream(out);
	}

	@Test
	public void KOWithWrongRental() {
		Console console = new Console(consoleOut, "mario", "The movie", "0");
		console.execute();
		assertThat(out.toString()).isEqualTo("Please check rental parameters and try again\n");
	}

	@Test
	public void KOWithoutRentals() {
		Console console = new Console(consoleOut, "mario");
		console.execute();
		assertThat(out.toString()).isEqualTo("Please check rental parameters and try again\n");
	}

	@Test
	public void statementWithWrongParameterType() {
		Console console = new Console(consoleOut, "mario", "the movie", "not a number", "2");
		console.execute();
		assertThat(out.toString()).isEqualTo("Please check rental parameters and try again\n");
	}

}
