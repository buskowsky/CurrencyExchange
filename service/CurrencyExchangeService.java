package pl.jfonferko.currencyexchange.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.CurrencyNotFoundException;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;

/**
 * 
 * This interface parse XML and try to find currency by code
 * 
 * @author Jakub Fonferko
 * @since 25-Feb-2016
 * @version 25-Feb-2016
 */
public interface CurrencyExchangeService {

	/**
	 * This class methods - getLastCurrencyRateStock(),
	 * getLastAverageCurrencyRateStock(),
	 * getLastInconvertibleCurrencyRateStock(), getLastUnitOfAccountRate() gets
	 * Document from CurrencyExchangeDao class and parse this Document to
	 * ExchangeListing class
	 * 
	 * @throws MalformedURLException
	 *             , IOException, ParserConfigurationException, SAXException,
	 *             DOMException, ParseException
	 * 
	 * @return parsed ExchangeListing object class.
	 * 
	 *         method findCurrencyByCodeFromLastCurrencyRateStock(String code)
	 *         try to find Currency from last exchange listing using currency
	 *         code
	 * 
	 * @param String
	 *            code - code of currency what we are looking for,
	 * 
	 * @return if currency with code exist return Currency object otherwise
	 *         throw CurrencyNotFoundException()
	 */

	ExchangeListing getLastCurrencyRateStock() throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException,
			DOMException, ParseException;

	ExchangeListing getLastAverageCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException;

	ExchangeListing getLastInconvertibleCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException;

	ExchangeListing getLastUnitOfAccountRate() throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException,
			DOMException, ParseException;

	Currency findCurrencyByCodeFromLastCurrencyRateStock(String code)
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException,
			CurrencyNotFoundException;

}
