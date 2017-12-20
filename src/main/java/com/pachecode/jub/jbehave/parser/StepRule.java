package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepType;

/**
 * Created by Ricardo on 11/4/2017.
 */
public class StepRule extends SyntacticRule<Step> {
  private final String stepType;

  public StepRule(LineLexer lineLexer, StepType stepType, SyntacticRule parent) {
    super(lineLexer, parent);
    this.stepType = stepType.toString().toLowerCase();
  }

  @Override
  public boolean lookAhead() {
      return lineLexer.currentLine().startsWith(stepType.toLowerCase());
  }

  public Step match() {
    String stepLine = lineLexer.match(stepType + " .*");
    String body = "";

    while(!matchesAnyRule())
      body += lineLexer.consume();

    return  Step.create(stepLine, body);
  }


}
