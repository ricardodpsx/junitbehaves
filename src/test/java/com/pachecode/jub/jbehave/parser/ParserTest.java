package com.pachecode.jub.jbehave.parser;

import org.junit.Test;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ricardo on 11/5/2017.
 */
public class ParserTest {
  @Test
  public void testParserReadTwoLines() {
    Parser parser = new Parser("line 1\nline 2");

    assertThat(parser.match(".*"), is("line 1"));
    assertThat(parser.match(".*"), is("line 2"));
    assertTrue(parser.isEOF());
  }

  @Test
  public void testParserReadSingleLine() {
    Parser parser = new Parser("line 1");

    assertThat(parser.match(".*"), is("line 1"));
    assertTrue(parser.isEOF());
  }

  @Test
  public void assertEmptyLinesAreIgnored() {
    Parser parser = new Parser("\nline 1\n   \nline 2\n \n\n");

    assertThat(parser.match(".*"), is("line 1"));
    assertThat(parser.match(".*"), is("line 2"));
    assertTrue(parser.isEOF());
  }
}
