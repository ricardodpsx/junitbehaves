package com.pachecode.jub.jbehave.parser;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ricardo on 11/5/2017.
 */
public class LineLexerTest {
  @Test
  public void testParserReadTwoLines() {
    LineLexer lineLexer = new LineLexer("line 1\nline 2");

    assertThat(lineLexer.match(".*"), is("line 1"));
    assertThat(lineLexer.match(".*"), is("line 2"));
    assertTrue(lineLexer.isEOF());
  }

  @Test
  public void testParserReadSingleLine() {
    LineLexer lineLexer = new LineLexer("line 1");

    assertThat(lineLexer.match(".*"), is("line 1"));
    assertTrue(lineLexer.isEOF());
  }

  @Test
  public void assertEmptyLinesAreIgnored() {
    LineLexer lineLexer = new LineLexer("\nline 1\n   \nline 2\n \n\n");

    assertThat(lineLexer.match(".*"), is("line 1"));
    assertThat(lineLexer.match(".*"), is("line 2"));
    assertTrue(lineLexer.isEOF());
  }
}
