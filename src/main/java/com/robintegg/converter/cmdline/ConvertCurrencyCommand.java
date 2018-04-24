package com.robintegg.converter.cmdline;

import com.beust.jcommander.Parameter;
import com.robintegg.converter.core.Amount;
import com.robintegg.converter.core.Console;
import com.robintegg.converter.core.Currency;
import com.robintegg.converter.core.Money;

public class ConvertCurrencyCommand {

	@Parameter(names = { "-sourceCurrencyAmount",
			"-a" }, description = "A source currency amount in the format x.yy such as 100.00", required = true, converter = AmountConverter.class)
	Amount sourceAmount;

	@Parameter(names = { "-sourceCurrencyCode",
			"-s" }, description = "A source ISO 4217 currency code such as GBP", required = true, converter = CurrencyCodeConverter.class)
	Currency sourceCurrency;

	@Parameter(names = { "-targetCurrencyCode",
			"-t" }, description = "A target ISO 4217 currency code such as AUD", required = true, converter = CurrencyCodeConverter.class)
	Currency targetCurrency;

	private final Console console;

	public ConvertCurrencyCommand(Console console) {
		this.console = console;
	}

	public void execute() {

		Money source = Money.of(sourceCurrency, sourceAmount);

		// console.write(String.format("Source: %s", source.toString()));

		Money target = source.convert(targetCurrency);

		console.write(String.format("%s", target.toString()));

	}

}