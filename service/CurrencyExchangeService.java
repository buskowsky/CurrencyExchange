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
	 * methods gets Document DOM and parse it ExchangeListing class
	 * 
	 * @see CurrencyExchangeDao
	 * 
	 *      getLastBuyAndSellPricesOfForeignCurrencies() gets TableC from nbp.pl
	 *      getLastMiddleExchangeRatesOfForeignCurrencies() gets TableA from
	 *      nbp.pl ,
	 *      getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies() gets
	 *      TableB from nbp.pl, getLastUnitOfAccountRates() gets TableH from
	 *      nbp.pl
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
	 * method findCurrencyByCode(String code) try to find Currency from tableC -
	 * last buy/sell rates of foreign currencies
	 * 
	 * @param String
	 *            code - code of currency we are looking for,
	 * 
	 * @return new Currency object if currency code exist otherwise null
	 */
	Currency findCurrencyByCode(String code);

}