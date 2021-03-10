package refactoring;

import java.util.Map;

public class Movie {

	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private Map<Integer, Price> _pricesMap = Map.of(REGULAR, new RegularPrice(), NEW_RELEASE, new NewReleasePrice(), CHILDRENS, new ChildrensPrice());

	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		if (_pricesMap.containsKey(arg))
			_price = _pricesMap.get(arg);
		else
			throw new IllegalArgumentException("Incorrect price code");
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}

}
