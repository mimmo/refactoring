package refactoring.console;

import java.util.List;

import refactoring.Customer;

public class InputCustomer {
	private String _name;

	public InputCustomer(List<String> arguments) {
		_name = arguments.isEmpty() ? "" : arguments.get(0);
	}

	public boolean isValid() {
		return !_name.isBlank();
	}

	public Customer asCustomer() {
		return new Customer(_name);
	}
}
