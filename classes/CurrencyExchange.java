package pl.jfonferko.currencyexchange.classes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.service.CurrencyExchangeService;
import pl.jfonferko.currencyexchange.service.CurrencyExchangeServiceImpl;

public class CurrencyExchange implements CurrencyExchangeService {

	private CurrencyExchangeServiceImpl currencyExchangeService;

	public CurrencyExchange() {
		currencyExchangeService = new CurrencyExchangeServiceImpl();
	}

	public ExchangeListing getLastCurrencyRateStock()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastCurrencyRateStock();
	}

	public ExchangeListing getLastAverageCurrencyRateStock()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastAverageCurrencyRateStock();
	}

	public ExchangeListing getLastInconvertibleCurrencyRateStock()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastInconvertibleCurrencyRateStock();
	}

	public ExchangeListing getLastUnitOfAccountRateStock()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastUnitOfAccountRateStock();
	}

	public Currency findCurrencyByCodeFromLastCurrencyRateStock(String code)
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException,
			CurrencyNotFoundException {
		return currencyExchangeService
				.findCurrencyByCodeFromLastCurrencyRateStock(code);
	}

}