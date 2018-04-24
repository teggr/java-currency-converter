package com.robintegg.converter;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.robintegg.converter.cmdline.ConvertCurrencyCommand;
import com.robintegg.converter.cmdline.SystemConsole;

public class CurrencyConverterApplication {

	public static void main(String[] args) {

		try {

			ConvertCurrencyCommand command = new ConvertCurrencyCommand(new SystemConsole());

			JCommander.newBuilder().programName("converter").addObject(command).build().parse(args);

			command.execute();

			System.exit(0);

		} catch (ParameterException e) {

			System.out.println(e.getMessage());

			e.getJCommander().usage();

			System.exit(1);

		}

	}

}