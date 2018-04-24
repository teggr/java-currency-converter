package com.robintegg.converter.core;

import org.junit.Test;

public class AmountTest {

	@Test
	public void shouldRequireLargeXyyFormat() {

		Amount.of("100001.23");

	}

	@Test
	public void shouldRequireXyyFormat() {

		Amount.of("1.23");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireXValue() {

		Amount.of(".23");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireYYValue() {

		Amount.of("1");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireAllYYValue() {

		Amount.of("1.2");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldRequireAtMostYYValue() {

		Amount.of("1.222");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotAllowEmpty() {

		Amount.of("");

	}

}
