package com.robintegg.converter.core;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * An amount that must match the format x.yy
 */
public class Amount {

	private static final Pattern FORMAT = Pattern.compile("[0-9]+\\.[0-9]{2}$");

	private static final String AMOUNT_FORMAT_MESSAGE = "Amount must be in the format x.yy";

	public static Amount of(String value) {
		value = value.trim();
		if (FORMAT.matcher(value).matches() == false) {
			throw new IllegalArgumentException(AMOUNT_FORMAT_MESSAGE);
		}
		return new Amount(new BigDecimal(value));
	}

	private final BigDecimal value;

	Amount(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal asBigDecimal() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

}
