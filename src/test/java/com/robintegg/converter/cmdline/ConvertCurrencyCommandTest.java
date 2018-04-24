package com.robintegg.converter.cmdline;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.robintegg.converter.FakeConsole;
import com.robintegg.converter.core.Amount;
import com.robintegg.converter.core.Currency;

public class ConvertCurrencyCommandTest {

	@Test
	public void shouldConvertCurrency() {

		// given
		FakeConsole console = new FakeConsole();
		ConvertCurrencyCommand command = new ConvertCurrencyCommand(console);
		command.sourceAmount = Amount.of("50.00");
		command.sourceCurrency = Currency.of("GBP");
		command.targetCurrency = Currency.of("BAM");

		// when
		command.execute();

		// then
		List<String> messages = console.getMessages();

		assertEquals(1, messages.size());
		assertEquals("130.28 Bosnia and Herzegovina Convertible Marka", messages.get(0));

	}

}
