package refactoring.console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import refactoring.Customer;
import refactoring.Rental;

public class ConsoleInput {

	private InputCustomer _inputCustomer;
	private InputRentals _inputRentals;

	public ConsoleInput(String[] args) {
		List<String> arguments = Stream.of(args).collect(Collectors.toList());
		_inputCustomer = new InputCustomer(arguments);
		_inputRentals = new InputRentals(arguments);
	}

	public boolean isValid() {
		return _inputCustomer.isValid() && _inputRentals.isValid();
	}

	public Customer getCustomer() {
		return _inputCustomer.asCustomer();
	}

	public List<Rental> getRentals() {
		return _inputRentals.asRentals();
	}

}
