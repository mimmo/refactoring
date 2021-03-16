package refactoring.console;

import java.io.PrintStream;

import refactoring.Customer;

public class Console {

	private Input _input;
	private PrintStream _out;

	public Console(String... args) {
		_input = new Input(args);
		_out = System.out;
	}

	public void execute() {
		if(!_input.isValid()) {
			printHelp();
			return;
		}

		Customer customer = _input.getInputCustomer().asCustomer();
		_input.getInputRentals().forEach(inRental -> customer.addRental(inRental.asRental()));
		_out.println(customer.statement());
	}

	private void printHelp() {
		_out.println("Please check rental parameters and try again");
	}

}
