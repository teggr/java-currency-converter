package com.robintegg.converter.core;

/**
 * Provider for available currencies
 */
interface CurrencyDataProvider {

	/**
	 * Register all currencies known by this provider
	 */
	void registerCurrencies() throws Exception;

}
