package pl.jfonferko.currencyexchange.classes;

import java.util.LinkedList;
import java.util.List;

public class ExchangeListing {
	private String publicationDate = null;
	private String stockDate = null;
	private String tableNumber = null;
	private char stockType = '-';

	private List<Currency> currencyList = new LinkedList<Currency>();

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public char getStockType() {
		return stockType;
	}

	public void setStockType(char stockType) {
		this.stockType = stockType;
	}

	public List<Currency> getCurrencyList() {
		return currencyList;
	}

	public void setExchangeList(List<Currency> currencyList) {
		this.currencyList = currencyList;
	}

	@Override
	public String toString() {
		return "CurrencyStockExchange [publicationDate=" + publicationDate
				+ ", stockDate=" + stockDate + ", tableNumber=" + tableNumber
				+ ", stockType=" + stockType + ", currencyList=" + currencyList
				+ "]";
	}

}
