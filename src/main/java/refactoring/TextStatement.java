package refactoring;

public class TextStatement extends Statement {
	@Override
	public String header(Customer customer) {
		return "Rental Record for " + customer.getName() + "\n";
	}

	@Override
	public String rental(Rental rental) {
		return "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
	}

	@Override
	public String footer(Customer customer) {
		return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n" + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
	}
}
