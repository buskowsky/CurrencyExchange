package pl.jfonferko.currencyexchange.service;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;

/**
 * 
 * This interface is used to get new object of ExchangeListing class or try to
 * find currency by code
 * 
 * @author Jakub Fonferko
 * @since 25-Feb-2016
 * @version 05-Mar-2016
 */
public interface CurrencyExchangeService {

	/**
	 * methods - getLastBuyAndSellPricesOfForeignCurrencies(),
	 * getLastMiddleExchangeRatesOfForeignCurrencies(),
	 * getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies(),
	 * getLastUnitOfAccountRates() gets Document DOM from CurrencyExchangeDao
	 * and parse this Document to ExchangeListing class
	 * 
	 * 
	 * @return new ExchangeListing object class.
	 * 
	 */

	ExchangeListing getLastBuyAndSellPricesOfForeignCurrencies();

	ExchangeListing getLastMiddleExchangeRatesOfForeignCurrencies();

	ExchangeListing getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies();

	ExchangeListing getLastUnitOfAccountRates();

	/**
	 *
	 * method findCurrencyByCode(String code) try to find Currency from tableA
	 * and tableB
	 * 
	 * @param String
	 *            code - code of currency we are looking for,
	 * 
	 * @return new Currency object if currency code exist otherwise null
	 */
	Currency findCurrencyByCode(String code);

}