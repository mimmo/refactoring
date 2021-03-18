package refactoring.console;

import java.util.ArrayList;
import java.util.List;

import refactoring.Rental;

public class InputRentals implements Input<List<Rental>>{
	private List<InputRental> _lines;
	private List<String> _rentalsInput;

	public InputRentals(List<String> arguments) {
		_lines = new ArrayList<>();
		_rentalsInput = arguments.subList(1, arguments.size());

		for (int i = 0; i < _rentalsInput.size(); i += InputRental.FIELDS.size()) {
			_lines.add(new InputRental(_rentalsInput, i));
		}
	}

	@Override
	public boolean isValid() {
		boolean valid = !_lines.isEmpty();

		for(InputRental l: _lines) {
			if(!l.isValid()){
				valid = false;
				break;
			}
		}

		return valid;
	}

	@Override
	public List<Rental> asObject() {
		List<Rental> rentals = new ArrayList<>();

		for(InputRental l: _lines) {
			rentals.add(l.asObject());
		}

		return rentals;
	}
}
