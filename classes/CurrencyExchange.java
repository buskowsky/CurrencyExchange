package pl.jfonferko.currencyexchange.classes;

import pl.jfonferko.currencyexchange.service.CurrencyExchangeService;
import pl.jfonferko.currencyexchange.service.CurrencyExchangeServiceImpl;

public class CurrencyExchange implements CurrencyExchangeService {

	private CurrencyExchangeServiceImpl currencyExchangeService;

	public CurrencyExchange() {
		currencyExchangeService = new CurrencyExchangeServiceImpl();
	}

	public ExchangeListing getLastBuyAndSellPricesOfForeignCurrencies() {
		return currencyExchangeService
				.getLastBuyAndSellPricesOfForeignCurrencies();
	}

	public ExchangeListing getLastMiddleExchangeRatesOfForeignCurrencies() {
		return currencyExchangeService
				.getLastMiddleExchangeRatesOfForeignCurrencies();
	}

	public ExchangeListing getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies() {
		return currencyExchangeService
				.getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies();
	}

	public ExchangeListing getLastUnitOfAccountRates() {
		return currencyExchangeService.getLastUnitOfAccountRates();
	}

	public Currency findCurrencyByCode(String code) {
		return currencyExchangeService.findCurrencyByCode(code);
	}

}