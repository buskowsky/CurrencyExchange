package pl.jfonferko.currencyexchange.classes;

public class CurrencyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyNotFoundException() {
		System.out.println("Currency not found");
	}
}
