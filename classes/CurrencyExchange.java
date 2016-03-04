package pl.jfonferko.currencyexchange.classes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.service.CurrencyExchangeService;
import pl.jfonferko.currencyexchange.service.CurrencyExchangeServiceImpl;

public class CurrencyExchange implements
CurrencyExchangeService{

	private String name = null;

	private CurrencyExchangeServiceImpl currencyExchangeService;

	public CurrencyExchange() {
		currencyExchangeService = new CurrencyExchangeServiceImpl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExchangeListing getLastCurrencyRate() throws MalformedURLException,
			DOMException, IOException, ParserConfigurationException,
			SAXException, ParseException {
		return currencyExchangeService.getLastCurrencyRateStock();
	}

	public ExchangeListing getLastAverageCurrencyRate()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastAverageCurrencyRateStock();
	}

	public ExchangeListing getLastInconvertibleCurrencyRate()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastInconvertibleCurrencyRateStock();
	}

	public ExchangeListing getLastUnitOfAccountRate()
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException {
		return currencyExchangeService.getLastUnitOfAccountRate();
	}

	public Currency getCurrencyByCodeFromLastExchangeListing(String code)
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException,
			CurrencyNotFoundException {
		return currencyExchangeService
				.findCurrencyByCodeFromLastCurrencyRateStock(code);
	}

	@Override
	public ExchangeListing getLastCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExchangeListing getLastAverageCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExchangeListing getLastInconvertibleCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency findCurrencyByCodeFromLastCurrencyRateStock(String code)
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException,
			CurrencyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}