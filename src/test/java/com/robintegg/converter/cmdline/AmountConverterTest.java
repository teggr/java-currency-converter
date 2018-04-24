package com.robintegg.converter.cmdline;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.beust.jcommander.ParameterException;
import com.robintegg.converter.core.Amount;

public class AmountConverterTest {

	@Test
	public void shouldConvertAValidFormatToAnAmount() {

		// given
		String value = "1.23";
		AmountConverter converter = new AmountConverter();

		// when
		Amount amount = converter.convert(value);

		// then
		assertEquals(new BigDecimal("1.23"), amount.asBigDecimal());

	}

	@Test(expected = ParameterException.class)
	public void shouldNotConvertWhenInvalidDigits() {

		// given
		String value = "1.2";
		AmountConverter converter = new AmountConverter();

		try {
			// when
			converter.convert(value);
		} catch (ParameterException e) {
			// then
			assertEquals("Could not get an amount value from 1.2. Amount must be in the format x.yy", e.getMessage());
			throw e;
		}

	}

	@Test(expected = ParameterException.class)
	public void shouldNotConvertWhenNoMajorDigit() {

		// given
		String value = ".22";
		AmountConverter converter = new AmountConverter();

		try {
			// when
			converter.convert(value);
		} catch (ParameterException e) {
			// then
			assertEquals("Could not get an amount value from .22. Amount must be in the format x.yy", e.getMessage());
			throw e;
		}

	}

}
