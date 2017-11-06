package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;

import java.util.ArrayList;
import java.util.List;


public class ScenarioRule extends SyntacticRule<Scenario> {

  private final StepRule GIVEN, WHEN, THEN, AND;

  public ScenarioRule(Parser parser, SyntacticRule parent) {
    super(parser, parent);

    GIVEN = new StepRule(parser, Step.StepType.Given, this);
    WHEN = new StepRule(parser, Step.StepType.When, this);
    THEN = new StepRule(parser, Step.StepType.Then, this);
    AND = new StepRule(parser, Step.StepType.And, this);
  }

  @Override
  public boolean lookAhead() {
    return parser.currentLine().startsWith("scenario:");
  }

  public Scenario match() {

    String scenarioLine = SCENARIO_LINE();

    List<Step> steps = new ArrayList<>();

    steps.add(GIVEN.match());
    steps.addAll(AND.matchZeroOrMore());

    steps.add(WHEN.match());
    steps.addAll(AND.matchZeroOrMore());

    steps.add(THEN.match());
    steps.addAll(AND.matchZeroOrMore());

    return Scenario.create(scenarioLine, steps);
  }



  private String SCENARIO_LINE() {
    return parser.match("scenario: .*");
  }
}
