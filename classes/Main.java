package pl.jfonferko.currencyexchange.classes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws MalformedURLException,
			DOMException, IOException, ParserConfigurationException,
			SAXException, ParseException {

		CurrencyExchange ce = new CurrencyExchange();

		ExchangeListing listing = new ExchangeListing();
		listing = ce.getLastCurrencyRate();

		System.out.println(listing.toString());
		for (Currency c : listing.getCurrencyList()) {
			System.out.println(c.toString());

		}
		System.out.println("-------------");

		listing = ce.getLastAverageCurrencyRate();
		System.out.println(listing.toString());
		for (Currency c : listing.getCurrencyList()) {
			System.out.println(c.toString());
		}

		Currency c = new Currency();
		try {
			c = ce.getCurrencyByCodeFromLastExchangeListing("UD");
		} catch (CurrencyNotFoundException e) {
			c.setName("not found");
			c.setCode("-----");
		}
		System.out.println(c.getCode() + " - " + c.getName());

	}
}