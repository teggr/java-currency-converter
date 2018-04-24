package com.robintegg.converter.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

public class CurrencyTest {

	@Test
	public void shouldLoadInCurrenciesFromDefaultProvider() throws Exception {

		// given
		DefaultCurrencyDataProvider source = new DefaultCurrencyDataProvider();

		// when
		source.registerCurrencies();

		// then
		assertEquals(5, Currency.getRegisteredCurrencies().size());

		Currency aed = Currency.of("AED");

		assertEquals("United Arab Emirates", aed.getCountry());
		assertEquals("Dirhams", aed.getName());
		assertEquals("AED", aed.getCode());
		assertEquals(new BigDecimal("7.2104"), aed.getRateToGbp());

		assertNull(Currency.of("XYZ"));

	}

}
