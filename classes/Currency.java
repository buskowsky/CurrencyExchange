package pl.jfonferko.currencyexchange.classes;

import java.math.BigDecimal;

public class Currency {
	private String name;
	private String converter;
	private String code;
	private String country;
	private String symbol;
	private BigDecimal buyingRate;
	private BigDecimal seelingRate;
	private BigDecimal averageRate;

	public Currency() {
		super();
	}

	public Currency(String name, BigDecimal buyingRate) {
		super();
		this.name = name;
		this.buyingRate = buyingRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConverter() {
		return converter;
	}

	public void setConverter(String converter) {
		this.converter = converter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getBuyingRate() {
		return buyingRate;
	}

	public void setBuyingRate(BigDecimal buyingRate) {
		this.buyingRate = buyingRate;
	}

	public BigDecimal getSeelingRate() {
		return seelingRate;
	}

	public void setSeelingRate(BigDecimal seelingRate) {
		this.seelingRate = seelingRate;
	}

	public BigDecimal getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(BigDecimal averageRate) {
		this.averageRate = averageRate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", converter=" + converter
				+ ", code=" + code + ", country=" + country + ", symbol="
				+ symbol + ", buyingRate=" + buyingRate + ", seelingRate="
				+ seelingRate + ", averageRate=" + averageRate + "]";
	}



}
