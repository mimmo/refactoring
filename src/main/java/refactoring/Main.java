package refactoring;

public class Main {
	public static final int CUSTOMER = 0;
	public static final int MOVIE_TITLE = 1;
	public static final int MOVIE_PRICECODE = 2;
	public static final int DAYS = 3;
	public static int padding = 0;

	public static void main(String... args) {
		Customer customer = new Customer(args[0]);

		if((args.length-1) % 3 != 0) {
			throw new IllegalArgumentException("Wrong number of arguments");
		}

		while (args.length-1 > padding) {
			Movie movie = new Movie(args[MOVIE_TITLE+padding], Integer.valueOf(args[MOVIE_PRICECODE+padding]));
			Rental rental = new Rental(movie, Integer.valueOf(args[DAYS+padding]));
			customer.addRental(rental);

			padding += 3;
		}

		System.out.println(customer.statement());
	}

}
