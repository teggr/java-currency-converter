package com.robintegg.converter.cmdline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beust.jcommander.ParameterException;
import com.robintegg.converter.core.Currency;

public class CurrencyCodeConverterTest {

	@Test
	public void shouldConvertRegisteredCurrencyCode() {

		// given
		String currencyCode = "AUD";
		CurrencyCodeConverter converter = new CurrencyCodeConverter();

		// when
		Currency currency = converter.convert(currencyCode);

		// then
		assertEquals(currencyCode, currency.getCode());

	}

	@Test(expected = ParameterException.class)
	public void shouldThrowExceptionWhenUnknownCurrencyCode() {

		// given
		String currencyCode = "XYZ";
		CurrencyCodeConverter converter = new CurrencyCodeConverter();

		try {
			// when
			converter.convert(currencyCode);
		} catch (ParameterException e) {
			// then
			assertEquals("Could not find currency code XYZ. Is it a registered ISO 4217 currency code?",
					e.getMessage());
			throw e;
		}

	}

}
