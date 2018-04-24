package com.robintegg.converter.cmdline;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import com.robintegg.converter.core.Currency;

public class CurrencyCodeConverter implements IStringConverter<Currency> {

	@Override
	public Currency convert(String value) {
		Currency currency = Currency.of(value);
		if (currency == null) {
			throw new ParameterException(
					"Could not find currency code " + value + ". Is it a registered ISO 4217 currency code?");
		}
		return currency;
	}

}
