package refactoring;

import java.util.Iterator;

public abstract class Statement {
	public String value(Customer customer) {
		Iterator<Rental> rentals = customer.getRentals().iterator();
		String result = header(customer);

		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += rental(each);
		}

		// add footer lines
		result += footer(customer);
		return result;
	}

	public abstract String header(Customer customer);
	public abstract String rental(Rental rental);
	public abstract String footer(Customer customer);
}
