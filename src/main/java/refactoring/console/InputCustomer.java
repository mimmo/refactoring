package refactoring.console;

import refactoring.Customer;

public class InputCustomer {
	private String _name;

	public InputCustomer(String name) {
		_name = name;
	}

	public boolean isValid() {
		return null != _name && !_name.isBlank();
	}

	public Customer asCustomer() {
		return new Customer(_name);
	}
}
