package refactoring.console;

import java.util.List;

import refactoring.Customer;

public class InputCustomer implements Input<Customer> {
	private String _name;

	public InputCustomer(List<String> arguments) {
		_name = arguments.isEmpty() ? "" : arguments.get(0);
	}

	@Override
	public boolean isValid() {
		return !_name.isBlank();
	}

	@Override
	public Customer asObject() {
		return new Customer(_name);
	}
}
