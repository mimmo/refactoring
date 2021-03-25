package refactoring;

public class HtmlStatement extends Statement {
	@Override
	public String header(Customer customer) {
		return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
	}

	@Override
	public String rental(Rental rental) {
		return rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
	}

	@Override
	public String footer(Customer customer) {
		return "<P>You owe <EM>" + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n" + "On this rental you earned <EM>" + String.valueOf(customer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
	}
}
