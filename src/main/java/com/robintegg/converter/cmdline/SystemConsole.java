package com.robintegg.converter.cmdline;

import com.robintegg.converter.core.Console;

/**
 * {@link Console} implementation that outputs to the {@link System} console
 *
 */
public class SystemConsole implements Console {

	@Override
	public void write(String message) {
		System.out.println(message);
	}

}
