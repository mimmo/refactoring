package refactoring.console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import refactoring.Rental;

public class InputRentals implements Input<List<Rental>>{
	private final List<InputRental> _lines;

	public InputRentals(List<String> arguments) {
		List<String> rentalsInput = arguments.subList(1, arguments.size());
//
//		_lines = new ArrayList<>();
//		for (int i = 0; i < rentalsInput.size(); i += InputRental.FIELDS.size()) {
//			_lines.add(new InputRental(rentalsInput, i));
//		}


		_lines = Stream.iterate(0, i -> i < rentalsInput.size(), i -> i+InputRental.FIELDS.size())
			.map(i -> new InputRental(rentalsInput, i))
			.collect(Collectors.toList());
	}

	@Override
	public boolean isValid() {
		if (_lines.isEmpty()) {
			return false;
		}

		return _lines
			.stream()
			.allMatch(InputRental::isValid);
	}

	@Override
	public List<Rental> asObject() {
		return _lines
			.stream()
			.map(InputRental::asObject)
			.collect(Collectors.toList());
	}
}
