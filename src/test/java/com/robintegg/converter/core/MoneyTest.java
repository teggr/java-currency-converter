package com.robintegg.converter.core;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testConvertShouldBeReversibleWhereNotLossy() {

		// given
		Money gbp = Money.of(Currency.of("GBP"), Amount.of("5.00"));

		// when
		gbp = gbp.convert(Currency.of("GBP"));

		// then
		assertEquals(new BigDecimal("5.00"), gbp.getAmount().asBigDecimal());

	}

	@Test
	public void testConvertShouldExhangeFromGBP() {

		// given
		Money gbp = Money.of(Currency.of("GBP"), Amount.of("1.00"));

		// when
		Money aed = gbp.convert(Currency.of("AED"));

		// then
		assertEquals(new BigDecimal("7.21"), aed.getAmount().asBigDecimal());

	}

	@Test
	public void testConvertShouldExhangeToGBP() {

		// given
		Money aed = Money.of(Currency.of("AED"), Amount.of("7.21"));

		// when
		Money gbp = aed.convert(Currency.of("GBP"));

		// then
		assertEquals(new BigDecimal("1.00"), gbp.getAmount().asBigDecimal());

	}

	@Test
	public void testConvertShouldRoundUpToTwoDecimalPlacesWhenOverHalf() {

		// given
		Money gbp = Money.of(Currency.of("GBP"), Amount.of("1.00"));

		// when
		Money bam = gbp.convert(Currency.of("BAM"));

		// then
		assertEquals(new BigDecimal("2.61"), bam.getAmount().asBigDecimal());

	}

	@Test
	public void testConvertShouldNotRoundUpToTwoDecimalPlacesWhenNotOverHalf() {

		// given
		Money gbp = Money.of(Currency.of("GBP"), Amount.of("1.00"));

		// when
		Money aud = gbp.convert(Currency.of("AUD"));

		// then
		assertEquals(new BigDecimal("1.51"), aud.getAmount().asBigDecimal());

	}

}
