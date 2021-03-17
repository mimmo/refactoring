package refactoring.console;

import java.io.PrintStream;

public class Console {

	private ConsoleInput _input;
	private PrintStream _out;

	public Console(PrintStream out, String... args) {
		_input = new ConsoleInput(args);
		_out = out;
	}

	public void execute() {
		if(!_input.isValid()) {
			printHelp();
			return;
		}

		_out.println(_input
			.getCustomer()
			.addRentals(_input.getRentals())
			.statement());
	}

	private void printHelp() {
		_out.println("Please check rental parameters and try again");
	}

}
