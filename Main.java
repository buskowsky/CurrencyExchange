package pl.jfonferko.currencyexchange;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.CurrencyExchange;
import pl.jfonferko.currencyexchange.classes.CurrencyNotFoundException;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;

public class Main {
	public static void main(String[] args) throws MalformedURLException,
			DOMException, IOException, ParserConfigurationException,
			SAXException, ParseException {

		CurrencyExchange ce = new CurrencyExchange();

		ExchangeListing listing = new ExchangeListing();
		listing = ce.getLastCurrencyRateStock();

		System.out.println(listing.toString());
		for (Currency c : listing.getCurrencyList()) {
			System.out.println(c.toString());

		}
		System.out.println("-------------");

		listing = ce.getLastAverageCurrencyRateStock();
		System.out.println(listing.toString());
		for (Currency c : listing.getCurrencyList()) {
			System.out.println(c.toString());
		}

		Currency c = new Currency();
		try {
			c = ce.findCurrencyByCodeFromLastCurrencyRateStock("UD");
		} catch (CurrencyNotFoundException e) {
			c.setName("not found");
			c.setCode("-----");
		}
		System.out.println(c.getCode() + " - " + c.getName());

	}
}