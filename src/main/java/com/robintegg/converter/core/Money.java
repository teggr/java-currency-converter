package com.robintegg.converter.core;

import java.math.RoundingMode;

public class Money {

	public static Money of(Currency currency, Amount amount) {
		return new Money(currency, amount);
	}

	private Currency currency;

	private Amount amount;

	Money(Currency currency, Amount amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public Amount getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Money convert(Currency targetCurrency) {
		return Money.of(targetCurrency, calculateConversion(targetCurrency));
	}

	private Amount calculateConversion(Currency targetCurrency) {
		return new Amount(amount.asBigDecimal().divide(currency.getRateToGbp(), RoundingMode.HALF_UP)
				.multiply(targetCurrency.getRateToGbp()).setScale(2, RoundingMode.HALF_UP));
	}

	@Override
	public String toString() {
		return String.format("%s %s", amount, currency);
	}

}
