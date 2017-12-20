package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Examples;
import com.pachecode.jub.bdd.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ricardo on 12/10/2017.
 */
public class ExamplesRule extends SyntacticRule<Examples> {
  public ExamplesRule(LineLexer lineLexer, SyntacticRule parent) {
    super(lineLexer, parent);
  }

  @Override
  public boolean lookAhead() {
    return lineLexer.currentLine().startsWith("examples:");
  }

  @Override
  public Examples match() {

    HashMap<String, List<String>> table = new HashMap<>();
    EXAMPLES();
    String[] header = lineLexer.consume().substring(1).split("\\|");

    for(String key : header)
      table.put(key.trim(), new ArrayList<>());

    while(!matchesAnyRule()) {
      String[] row = lineLexer.consume().substring(1).split("\\|");
      for (int i = 0; i < row.length; i++)
        table.get(header[i].trim()).add(row[i].trim());
    }

    return  new Examples(table);
  }

  private String EXAMPLES() {
    return lineLexer.match("examples:");
  }
}
