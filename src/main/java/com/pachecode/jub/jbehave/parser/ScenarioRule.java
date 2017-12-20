package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;

import java.util.ArrayList;
import java.util.List;
import static com.pachecode.jub.bdd.StepType.*;


public class ScenarioRule extends SyntacticRule<Scenario> {

  private final StepRule GIVEN, WHEN, THEN, AND;


  public ScenarioRule(LineLexer lineLexer, SyntacticRule parent) {
    super(lineLexer, parent);

    GIVEN = new StepRule(lineLexer, Given, this);
    WHEN = new StepRule(lineLexer, When, this);
    THEN = new StepRule(lineLexer, Then, this);
    AND = new StepRule(lineLexer, And, this);
  }

  @Override
  public boolean lookAhead() {
    return lineLexer.currentLine().startsWith("scenario:");
  }

  public Scenario match() {

    String scenarioLine = SCENARIO_LINE();

    List<Step> steps = new ArrayList<>();

    steps.addAll(GIVEN.matchOneOrZero());
    if(steps.size() > 0)
      steps.addAll(AND.matchZeroOrMore());

    steps.add(WHEN.match());
    steps.addAll(AND.matchZeroOrMore());

    steps.add(THEN.match());
    steps.addAll(AND.matchZeroOrMore());


    return Scenario.create(scenarioLine, steps);
  }

  private String SCENARIO_LINE() {
    return lineLexer.match("scenario: .*");
  }
}
