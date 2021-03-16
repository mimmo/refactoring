package refactoring.console;

import refactoring.Movie;
import refactoring.Rental;

public class InputRental {

	private String _title;
	private String _priceCode;
	private String _days;

	public InputRental(String title, String priceCode, String days) {
		_title = title;
		_priceCode = priceCode;
		_days = days;
	}

	public boolean isValid() {
		return null != _title && !_title.isBlank() &&
			isIntegerable(_priceCode) &&
			isIntegerable(_days)
		;
	}

	private boolean isIntegerable(String value) {
		try {
			Integer.valueOf(value);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	public Rental asRental() {
		Movie movie = new Movie(_title, Integer.valueOf(_priceCode));
		return Rental.builder(movie)
			.days(Integer.valueOf(_days))
			.build();
	}

}
