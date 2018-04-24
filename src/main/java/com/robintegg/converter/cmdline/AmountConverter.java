package com.robintegg.converter.cmdline;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import com.robintegg.converter.core.Amount;

public class AmountConverter implements IStringConverter<Amount> {

	@Override
	public Amount convert(String value) {
		try {
			return Amount.of(value);
		} catch (IllegalArgumentException e) {
			throw new ParameterException("Could not get an amount value from " + value + ". " + e.getMessage());
		}
	}

}
