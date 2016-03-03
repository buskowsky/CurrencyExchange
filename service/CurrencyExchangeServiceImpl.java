package pl.jfonferko.currencyexchange.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pl.jfonferko.currencyexchange.classes.Currency;
import pl.jfonferko.currencyexchange.classes.CurrencyNotFoundException;
import pl.jfonferko.currencyexchange.classes.ExchangeListing;
import pl.jfonferko.currencyexchange.dao.CurrencyExchangeDaoImpl;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	private CurrencyExchangeDaoImpl currencyExchangeDao;

	public CurrencyExchangeDaoImpl getCurrencyExchangeDao() {
		return currencyExchangeDao;
	}

	public void setCurrencyExchangeDao(
			CurrencyExchangeDaoImpl currencyExchangeDao) {
		this.currencyExchangeDao = currencyExchangeDao;
	}

	public CurrencyExchangeServiceImpl() {
		currencyExchangeDao = new CurrencyExchangeDaoImpl();
	}

	@Override
	public ExchangeListing getLastCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {

		ExchangeListing el = new ExchangeListing();
		el.setStockType('C');
		List<Currency> cList = new LinkedList<Currency>();
		Document doc = currencyExchangeDao.getLastCurrencyRate("C");

		NodeList nodeL = doc.getElementsByTagName("tabela_kursow");
		for (int tmp = 0; tmp < nodeL.getLength(); tmp++) {
			Node n = nodeL.item(tmp);
			Element d = (Element) n;
			el.setStockDate(d.getElementsByTagName("data_notowania").item(0)
					.getTextContent());
			el.setPublicationDate(d.getElementsByTagName("data_publikacji")
					.item(0).getTextContent());
			el.setTableNumber(d.getElementsByTagName("numer_tabeli").item(0)
					.getTextContent());
		}

		NodeList nodeList = doc.getElementsByTagName("pozycja");

		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node nNode = nodeList.item(temp);
			Currency c = new Currency();

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;

				c.setName(element.getElementsByTagName("nazwa_waluty").item(0)
						.getTextContent());
				c.setCode(element.getElementsByTagName("kod_waluty").item(0)
						.getTextContent());
				c.setConverter(element.getElementsByTagName("przelicznik")
						.item(0).getTextContent());

				DecimalFormat df = new DecimalFormat();
				df.setParseBigDecimal(true);
				Number n = df.parse(element.getElementsByTagName("kurs_kupna")
						.item(0).getTextContent());

				c.setBuyingRate((BigDecimal) n);

				n = df.parse(element.getElementsByTagName("kurs_sprzedazy")
						.item(0).getTextContent());
				c.setSeelingRate((BigDecimal) n);
				cList.add(c);
			}

		}
		el.setExchangeList(cList);

		return el;

	}

	@Override
	public ExchangeListing getLastAverageCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {

		ExchangeListing el = new ExchangeListing();
		el.setStockType('A');
		List<Currency> cList = new LinkedList<Currency>();
		Document doc = currencyExchangeDao.getLastCurrencyRate("A");

		NodeList nodeL = doc.getElementsByTagName("tabela_kursow");
		for (int tmp = 0; tmp < nodeL.getLength(); tmp++) {
			Node n = nodeL.item(tmp);
			Element d = (Element) n;

			el.setPublicationDate(d.getElementsByTagName("data_publikacji")
					.item(0).getTextContent());
			el.setTableNumber(d.getElementsByTagName("numer_tabeli").item(0)
					.getTextContent());
		}

		NodeList nodeList = doc.getElementsByTagName("pozycja");

		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node nNode = nodeList.item(temp);
			Currency c = new Currency();

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;

				c.setName(element.getElementsByTagName("nazwa_waluty").item(0)
						.getTextContent());
				c.setCode(element.getElementsByTagName("kod_waluty").item(0)
						.getTextContent());
				c.setConverter(element.getElementsByTagName("przelicznik")
						.item(0).getTextContent());

				DecimalFormat df = new DecimalFormat();
				df.setParseBigDecimal(true);
				Number n = df.parse(element.getElementsByTagName("kurs_sredni")
						.item(0).getTextContent());

				c.setAverageRate((BigDecimal) n);

				cList.add(c);
			}

		}
		el.setExchangeList(cList);

		return el;

	}

	@Override
	public ExchangeListing getLastInconvertibleCurrencyRateStock()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {

		ExchangeListing el = new ExchangeListing();
		el.setStockType('B');
		Document doc = currencyExchangeDao.getLastCurrencyRate("B");
		List<Currency> cList = new LinkedList<Currency>();

		NodeList nodeL = doc.getElementsByTagName("tabela_kursow");

		for (int temp = 0; temp < nodeL.getLength(); temp++) {

			Node n = nodeL.item(temp);
			Element e = (Element) n;

			el.setPublicationDate(e.getElementsByTagName("data_publikacji")
					.item(0).getTextContent());
			el.setTableNumber(e.getElementsByTagName("numer_tabeli").item(0)
					.getTextContent());
		}

		NodeList nodeList = doc.getElementsByTagName("pozycja");
		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node nNode = nodeList.item(temp);
			Currency c = new Currency();

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;

				c.setName(element.getElementsByTagName("nazwa_waluty").item(0)
						.getTextContent());
				c.setCode(element.getElementsByTagName("kod_waluty").item(0)
						.getTextContent());
				c.setConverter(element.getElementsByTagName("przelicznik")
						.item(0).getTextContent());

				DecimalFormat df = new DecimalFormat();
				df.setParseBigDecimal(true);
				Number n = df.parse(element.getElementsByTagName("kurs_sredni")
						.item(0).getTextContent());

				c.setAverageRate((BigDecimal) n);

				cList.add(c);
			}
		}
		el.setExchangeList(cList);
		return el;
	}

	@Override
	public ExchangeListing getLastUnitOfAccountRate()
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException {

		ExchangeListing el = new ExchangeListing();
		el.setStockType('H');
		Document doc = currencyExchangeDao.getLastCurrencyRate("H");
		List<Currency> cList = new LinkedList<Currency>();

		NodeList nodeL = doc.getElementsByTagName("tabela_kursow");

		for (int temp = 0; temp < nodeL.getLength(); temp++) {

			Node n = nodeL.item(temp);
			Element e = (Element) n;

			el.setPublicationDate(e.getElementsByTagName("data_publikacji")
					.item(0).getTextContent());
			el.setTableNumber(e.getElementsByTagName("numer_tabeli").item(0)
					.getTextContent());
			el.setStockDate(e.getElementsByTagName("data_notowania").item(temp)
					.getTextContent());

		}

		NodeList nodeList = doc.getElementsByTagName("pozycja");
		for (int temp = 0; temp < nodeList.getLength(); temp++) {
			Node nNode = nodeList.item(temp);
			Currency c = new Currency();

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;

				c.setCountry(element.getElementsByTagName("nazwa_kraju")
						.item(0).getTextContent());
				c.setCode(element.getElementsByTagName("symbol_waluty").item(0)
						.getTextContent());

				c.setName(element.getElementsByTagName("nazwa_waluty").item(0)
						.getTextContent());

				c.setConverter(element.getElementsByTagName("przelicznik")
						.item(0).getTextContent());

				DecimalFormat df = new DecimalFormat();
				df.setParseBigDecimal(true);
				Number n = df.parse(element.getElementsByTagName("kurs_sredni")
						.item(0).getTextContent());

				c.setAverageRate((BigDecimal) n);

				Number n1 = df.parse(element.getElementsByTagName("kurs_kupna")
						.item(0).getTextContent());
				c.setBuyingRate((BigDecimal) n1);

				Number n2 = df.parse(element
						.getElementsByTagName("kurs_sprzedazy").item(0)
						.getTextContent());
				c.setSeelingRate((BigDecimal) n2);

				cList.add(c);
			}
		}
		el.setExchangeList(cList);
		return el;
	}

	public Currency findCurrencyByCodeFromLastCurrencyRateStock(String code)
			throws MalformedURLException, DOMException, IOException,
			ParserConfigurationException, SAXException, ParseException,
			CurrencyNotFoundException {

		ExchangeListing el = new ExchangeListing();
		el = getLastCurrencyRateStock();

		Currency tmp = new Currency();
		tmp.setCode(code);

		if (el.getCurrencyList().contains(tmp)) {
			for (Currency c : el.getCurrencyList()) {
				if (c.equals(tmp))
					return c;
			}
		}
		throw new CurrencyNotFoundException();
	}
}
