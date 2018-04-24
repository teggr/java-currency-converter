package com.robintegg.converter;

import java.util.ArrayList;
import java.util.List;

import com.robintegg.converter.core.Console;

public class FakeConsole implements Console {

	private final List<String> messages = new ArrayList<>();

	@Override
	public void write(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}

}
