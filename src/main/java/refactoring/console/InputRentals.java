package refactoring.console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import refactoring.Movie;
import refactoring.Rental;

public class InputRentals {

	private List<RawRental> _lines;

	public InputRentals(List<String> arguments) {
		_lines = Stream.iterate(1, x -> x < arguments.size() - 1, (x) -> x+3)
			.map(i -> new RawRental(get(arguments, i), get(arguments, i+1), get(arguments, i+2)))
			.collect(Collectors.toList());
	}

	public boolean isValid() {
		return !_lines.isEmpty() && !_lines
			.stream()
			.filter(l -> !l.isValid())
			.findAny()
			.isPresent();
	}

	public List<Rental> asRentals() {
		return _lines
			.stream()
			.map(l -> Rental.builder(new Movie(l._title, Integer.valueOf(l._priceCode)))
				.days(Integer.valueOf(l._days))
				.build())
			.collect(Collectors.toList());
	}

	private String get(List<String> arguments, int i) {
		return i <= (arguments.size() - 1) ? arguments.get(i) : "";
	}

	private class RawRental {

		private String _title;
		private String _priceCode;
		private String _days;

		public RawRental(String title, String priceCode, String days) {
			_title = title;
			_priceCode = priceCode;
			_days = days;
		}

		public boolean isValid() {
			return !_title.isBlank() &&
				isIntegerable(_priceCode) &&
				isIntegerable(_days);
		}

		private boolean isIntegerable(String value) {
			try {
				Integer.valueOf(value);
			} catch (Throwable e) {
				return false;
			}
			return true;
		}

	}

}
