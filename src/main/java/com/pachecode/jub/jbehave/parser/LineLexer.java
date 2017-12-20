package com.pachecode.jub.jbehave.parser;


public class LineLexer {
	private static final String EOF = "<--EOF-->";
	protected int cursor = 0;
	String[] lines;


	public LineLexer(String code) {
		lines = code.split("\n");
	}

	protected String match(String tokenPattern) {

		if(!currentLine().matches("^" + tokenPattern))
			throw new RuntimeException(String.format(
					"Expecting '%s' found '%s' line: %d",
					tokenPattern,  currentLine(), cursor
			));

		return consume();
	}

	protected String consume() {
		return lines[cursor++].trim();
	}

	protected String currentLine() {

		ignoreWhiteSpaces();

		return getLineOrEof();
	}

	private String getLineOrEof() {
		if(cursor >= lines.length)
			return EOF;

		return lines[cursor].toLowerCase().trim();
	}


	private void ignoreWhiteSpaces() {

		while (getLineOrEof().isEmpty() && getLineOrEof() != EOF)
			cursor++;

	}

	public boolean isEOF() {
		return currentLine().equals(EOF);
	}

}
