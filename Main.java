package pl.jfonferko.currencyexchange;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.CurrencyExchange;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;

public class Main {
	public static void main(String[] args) {

		CurrencyExchange ce = new CurrencyExchange();

		ExchangeListing listing = new ExchangeListing();

		listing = ce.getLastBuyAndSellPricesOfForeignCurrencies();

		System.out.println(listing.getStockType());
		System.out.println(listing.getPublicationDate());
		System.out.println(listing.getStockDate());
		System.out.println(listing.getTableNumber());

		for (Currency c : listing.getCurrencyList()) {
			System.out.println(c.toString());
		}

		Currency c = new Currency();

		c = ce.findCurrencyByCode("usD");

		if (c != null) {
			System.out.println("Find - " + c.toString());
		}
	}
}