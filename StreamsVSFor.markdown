# For Loop

```
public InputRentals(List<String> arguments) {
	_lines = new ArrayList<>();
	for (int i = 0; i < rentalsInput.size(); i += InputRental.FIELDS.size()) {
		_lines.add(new InputRental(rentalsInput, i));
	}
}
```

# The same code with streams

```
public InputRentals(List<String> arguments) {
	_lines = Stream.iterate(0, i -> i < rentalsInput.size(), i -> i+InputRental.FIELDS.size())
				.map(i -> new InputRental(rentalsInput, i))
				.collect(Collectors.toList());
}
```

---


# For Loop
```
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
```
# The same code with streams
```
public boolean isValid() {
	return !_lines.isEmpty() && !_lines
		.stream()
		.filter(l -> !l.isValid())
		.findAny()
		.isPresent();
}
```
```
public boolean isValid() {
	if (_lines.isEmpty()) {
		return false;
	}

	return _lines
		.stream()
		.allMatch(InputRental::isValid);
}
```

---

# For Loop

```
public List<Rental> asObject() {
	List<Rental> rentals = new ArrayList<>();

	for(InputRental l: _lines) {
		rentals.add(l.asObject());
	}

	return rentals;
}
```
# The same code with streams
```
public List<Rental> asObject() {
	return _lines
		.stream()
		.map(InputRental::asObject)
		.collect(Collectors.toList());
}
```
---

# String Join
```
List<String> strings = List.of("aaa","bbb","ccc");
String.join(";", strings);
```

# With Streams
```
List<String> strings = List.of("aaa","bbb","ccc");
strings.stream().collect(Collectors.joining(";"));
```