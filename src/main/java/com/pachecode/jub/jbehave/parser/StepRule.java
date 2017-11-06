package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Step;

/**
 * Created by Ricardo on 11/4/2017.
 */
public class StepRule extends SyntacticRule<Step> {
  private final String stepType;

  public StepRule(Parser parser, Step.StepType stepType, SyntacticRule parent) {
    super(parser, parent);
    this.stepType = stepType.toString().toLowerCase();
  }

  @Override
  public boolean lookAhead() {
      return parser.currentLine().startsWith(stepType.toLowerCase());
  }

  public Step match() {
    String stepLine = parser.match(stepType + " .*");
    String body = "";

    while(!matchesAnyRule())
      body += parser.consume();

    return  Step.create(stepLine, body);
  }

}
