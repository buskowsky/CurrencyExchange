package pl.jfonferko.currencyexchange.classes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ExchangeListing {
	private String publicationDate = null;
	private String stockDate = null;
	private String tableNumber = null;
	private String stockType = null;

	private Set<Currency> currencyList = new HashSet<Currency>();

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

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public Set<Currency> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(Set<Currency> currencyList) {
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
