package com.robintegg.converter.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A unit of currency with exchange rate to gbp
 */
public class Currency {

	private static final ConcurrentHashMap<String, Currency> currenciesByCode = new ConcurrentHashMap<>();

	static {
		try {
			new DefaultCurrencyDataProvider().registerCurrencies();
		} catch (Exception e) {
			throw new RuntimeException("Could not load exchange rates");
		}
	}

	static synchronized void register(String country, String name, String code, BigDecimal exchangeRateToGbp) {
		Currency unit = new Currency(country, name, code, exchangeRateToGbp);
		currenciesByCode.putIfAbsent(unit.getCode(), unit);
	}

	static List<Currency> getRegisteredCurrencies() {
		return new ArrayList<Currency>(currenciesByCode.values());
	}

	public static Currency of(String code) {
		return currenciesByCode.get(code);
	}

	private final String country;

	private final String name;

	private final String code;

	private final BigDecimal rateToGbp;

	Currency(String country, String name, String code, BigDecimal rateToGbp) {
		super();
		this.country = country;
		this.name = name;
		this.code = code;
		this.rateToGbp = rateToGbp;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public BigDecimal getRateToGbp() {
		return rateToGbp;
	}

	@Override
	public String toString() {
		return String.format("%s %s", country, name);
	}

}
