package pl.jfonferko.currencyexchange.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Repository;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Repository
public class CurrencyExchangeDaoImpl implements CurrencyExchangeDao {

	public CurrencyExchangeDaoImpl() {
	}

	@Override
	public Document getData(String stockType) throws IOException,
			ParserConfigurationException, DOMException, ParseException,
			SAXException {

		URL url = null;

		if (stockType == "A") {
			url = new URL(lastA);
		} else if (stockType == "B") {
			url = new URL(lastB);
		} else if (stockType == "C") {
			url = new URL(lastC);
		} else if (stockType == "H") {
			url = new URL(lastH);
		}

		URLConnection urlConnection = url.openConnection();
		InputStream in = new BufferedInputStream(urlConnection.getInputStream());

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(in);
		doc.getDocumentElement().normalize();

		return doc;
	}

}