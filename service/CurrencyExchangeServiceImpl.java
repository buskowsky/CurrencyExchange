package pl.jfonferko.currencyexchange.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;
import pl.jfonferko.currencyexchange.dao.CurrencyExchangeDaoImpl;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	Logger log;
	private CurrencyExchangeDaoImpl currencyExchangeDao;
	private Document doc;
	private ExchangeListing exchangeListing;

	public CurrencyExchangeServiceImpl() {
		currencyExchangeDao = new CurrencyExchangeDaoImpl();
		exchangeListing = new ExchangeListing();
	}

	@Override
	public ExchangeListing getLastBuyAndSellPricesOfForeignCurrencies() {
		exchangeListing.setStockType("C");
		createListing();
		return exchangeListing;
	}

	@Override
	public ExchangeListing getLastMiddleExchangeRatesOfForeignCurrencies() {
		exchangeListing.setStockType("A");
		createListing();
		return exchangeListing;

	}

	@Override
	public ExchangeListing getLastMiddleExchangeRatesOfInconvertibleForeignCurrencies() {
		exchangeListing.setStockType("B");
		createListing();
		return exchangeListing;
	}

	@Override
	public ExchangeListing getLastUnitOfAccountRates() {
		exchangeListing.setStockType("H");
		createListing();
		return exchangeListing;
	}

	public Currency findCurrencyByCode(String code) {

		exchangeListing.setStockType("C");
		prepareDocument(exchangeListing.getStockType());
		readBody();

		Currency tmp = new Currency();
		tmp.setCode(code.toUpperCase());

		if (exchangeListing.getCurrencyList().contains(tmp)) {
			for (Currency c : exchangeListing.getCurrencyList()) {
				if (c.equals(tmp))
					return c;
			}
		}
		return null;
	}

	private void prepareDocument(String stockType) {
		try {
			doc = currencyExchangeDao.getData(stockType);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	private void readHead() {
		NodeList nodeL = doc.getElementsByTagName("tabela_kursow");
		Node n = nodeL.item(0);
		Element d = (Element) n;
		try {
			exchangeListing.setStockDate(d
					.getElementsByTagName("data_notowania").item(0)
					.getTextContent());
		} catch (NullPointerException npe) {
			exchangeListing.setStockDate(null);
		}
		exchangeListing.setPublicationDate(d
				.getElementsByTagName("data_publikacji").item(0)
				.getTextContent());
		exchangeListing.setTableNumber(d.getElementsByTagName("numer_tabeli")
				.item(0).getTextContent());

	}

	private void readBody() {
		NodeList nodeList = doc.getElementsByTagName("pozycja");
		List<Currency> cList = new LinkedList<Currency>();
		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node nNode = nodeList.item(temp);
			Currency c = new Currency();

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;

				c.setName(element.getElementsByTagName("nazwa_waluty").item(0)
						.getTextContent());
				try {
					c.setCountry(element.getElementsByTagName("nazwa_kraju ")
							.item(0).getTextContent());
				} catch (NullPointerException npe) {
					c.setCountry(null);
				}
				try {
					c.setSymbol(element.getElementsByTagName("symbol_waluty")
							.item(0).getTextContent());
				} catch (NullPointerException npe) {
					c.setSymbol(null);
				}

				try {
					c.setCode(element.getElementsByTagName("kod_waluty")
							.item(0).getTextContent());
				} catch (NullPointerException npe) {
					c.setCode(null);
				}

				c.setConverter(element.getElementsByTagName("przelicznik")
						.item(0).getTextContent());

				DecimalFormat df = new DecimalFormat();
				df.setParseBigDecimal(true);
				Number n;
				try {
					n = df.parse(element.getElementsByTagName("kurs_kupna")
							.item(0).getTextContent());

					c.setBuyingRate((BigDecimal) n);
				} catch (NullPointerException npe) {
					c.setBuyingRate(null);
				} catch (DOMException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					n = df.parse(element.getElementsByTagName("kurs_sprzedazy")
							.item(0).getTextContent());
					c.setSeelingRate((BigDecimal) n);
				} catch (NullPointerException npe) {
					c.setSeelingRate(null);
				} catch (DOMException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					n = df.parse(element.getElementsByTagName("kurs_sredni")
							.item(0).getTextContent());
					c.setAverageRate((BigDecimal) n);
				} catch (NullPointerException npe) {
					c.setAverageRate(null);
				} catch (DOMException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cList.add(c);
			}
		}
		exchangeListing.setCurrencyList(cList);

	}

	private void createListing() {
		prepareDocument(exchangeListing.getStockType());
		readBody();
		readHead();

	}

}
