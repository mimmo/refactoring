package refactoring.console;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

	private InputCustomer _inputCustomer;
	private List<InputRental> _inputRentals;

	public Input(String[] args) {
		_inputCustomer = new InputCustomer(args[0]);
		_inputRentals = Stream
			.iterate(1, x -> x < args.length - 1, (x) -> x+3)
			.map(i -> new InputRental(args[i], args[i+1], args[i+2]))
			.collect(Collectors.toList());
	}

	public boolean isValid() {
		Optional<InputRental> invalidInput = _inputRentals
			.stream()
			.filter(i -> !i.isValid())
			.findAny();
		return _inputCustomer.isValid() && invalidInput.isEmpty();
	}

	public InputCustomer getInputCustomer() {
		return _inputCustomer;
	}

	public List<InputRental> getInputRentals() {
		return _inputRentals;
	}

}
