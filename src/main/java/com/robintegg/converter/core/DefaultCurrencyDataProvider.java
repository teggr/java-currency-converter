package com.robintegg.converter.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * Gets currencies from a file on the classpath
 */
class DefaultCurrencyDataProvider implements CurrencyDataProvider {

	private static final String EXCHANGE_RATES_CSV = "/exchange-rates.csv";

	@Override
	public void registerCurrencies() throws Exception {
		try (CSVReader reader = configureCsvReader()) {
			loadCurrencies(reader);
		}
	}

	private void loadCurrencies(CSVReader csvReader) throws IOException {
		String[] currencyRecord;
		while ((currencyRecord = csvReader.readNext()) != null) {
			Currency.register(currencyRecord[0].trim(), currencyRecord[1].trim(), currencyRecord[2].trim(),
					new BigDecimal(currencyRecord[3].trim()));
		}
	}

	private CSVReader configureCsvReader() throws URISyntaxException, IOException {
		return new CSVReaderBuilder(bufferedReader(exchangeRatesClasspathResource())).withSkipLines(1).build();
	}

	private BufferedReader bufferedReader(InputStream in) throws IOException {
		return new BufferedReader(new InputStreamReader(in, Charset.defaultCharset()));
	}

	private InputStream exchangeRatesClasspathResource() throws URISyntaxException {
		return DefaultCurrencyDataProvider.class.getResourceAsStream(EXCHANGE_RATES_CSV);
	}

}
