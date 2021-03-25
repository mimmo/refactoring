package refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<>();

	public Customer(String name) {
		_name = name;
	}

	public Customer addRental(Rental value) {
		return addRentals(List.of(value));
	}
	public Customer addRentals(List<Rental> values) {
		_rentals.addAll(values);
		return this;
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		return new TextStatement().value(this);
	}

	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}

	public List<Rental> getRentals() {
		return _rentals;
	}

	public double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentals = _rentals.iterator();

		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += each.getCharge();
		}
		return result;
	}

	public int getTotalFrequentRenterPoints() {
		int result = 0;
		Iterator<Rental> rentals = _rentals.iterator();

		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
}
