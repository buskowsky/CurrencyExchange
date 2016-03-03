package pl.jfonferko.currencyexchange.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * This interface gets XML file from URL
 * 
 * @author Jakub Fonferko
 * @since 25-Feb-2016
 * @version 25-Feb-2016
 */

public interface CurrencyExchangeDao {

	// URL do tabeli kursów œrednich walut obcych;
	final static String lastA = "http://www.nbp.pl/kursy/xml/LastA.xml";
	// URL do tabeli tabela kursów œrednich walut niewymienialnych;
	final static String lastB = "http://www.nbp.pl/kursy/xml/LastB.xml";
	// URL do tabeli tabela kursów kupna i sprzeda¿y;
	final static String lastC = "http://www.nbp.pl/kursy/xml/LastC.xml";
	// URL do tabeli tabela kursów jednostek rozliczeniowych.
	final static String lastH = "http://www.nbp.pl/kursy/xml/LastH.xml";

	/**
	 * This class gets XML file from URL
	 * 
	 * @param Sting ratingType
	 *            type of stock tables, possible params: A - table of average
	 *            currency last rate, B - table of average inconvertible last
	 *            currency rate, C - table of buy/seel last currency rate, H -
	 *            table of unit of account last rate
	 * 
	 * @return Object of Document class ready to XML parse
	 */

	Document getLastCurrencyRate(String ratingType)
			throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException, DOMException,
			ParseException;

}
