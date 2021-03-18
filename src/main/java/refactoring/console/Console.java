package refactoring.console;

import java.io.PrintStream;

public class Console {

	private ConsoleInput _input;
	private PrintStream _output;

	public Console(PrintStream out, String... args) {
		_input = new ConsoleInput(args);
		_output = out;
	}

	public void execute() {
		if(!_input.isValid()) {
			printHelp();
			return;
		}

		_output.println(_input
			.getCustomer()
			.addRentals(_input.getRentals())
			.statement());
	}

	private void printHelp() {
		_output.println("Please check rental parameters and try again");
	}

}
