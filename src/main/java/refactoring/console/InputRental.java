package refactoring.console;

import java.util.List;
import java.util.Map;

import refactoring.Movie;
import refactoring.Rental;

public class InputRental implements Input<Rental> {
	public static final Map<String, Integer> FIELDS = Map.of(
		"title", 0,
		"code", 1,
		"days", 2
	);

	private String _title;
	private String _priceCode;
	private String _days;

	public InputRental(List<String> input, int i) {
		_title = getOrDefault(input, FIELDS.get("title") + i);
		_priceCode = getOrDefault(input, FIELDS.get("code") + i);
		_days = getOrDefault(input, FIELDS.get("days") + i);
	}

	@Override
	public boolean isValid() {
		return !_title.isBlank() &&
			isIntegerable(_priceCode) &&
			isIntegerable(_days);
	}

	@Override
	public Rental asObject() {
		return Rental.builder(new Movie(_title, priceCodeValue()))
			.days(daysValue())
			.build();
	}

	private boolean isIntegerable(String value) {
		try {
			Integer.valueOf(value);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	private int priceCodeValue() {
		return Integer.valueOf(_priceCode);
	}

	private int daysValue() {
		return Integer.valueOf(_days);
	}

	private String getOrDefault(List<String> arguments, int i) {
		return i < arguments.size() ? arguments.get(i) : "";
	}

}
