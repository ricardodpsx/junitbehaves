package com.pachecode.jub.jbehave.parser;


import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Story;

import java.util.List;


public class StoryRule extends SyntacticRule<Story> {
	final ScenarioRule scenarioRule;
  private final String storyName;

  public StoryRule(String storyName, Parser parser) {
    super(parser, null);
    this.storyName = storyName;
    scenarioRule = new ScenarioRule(parser, this);
	}


	public Story match() {

    List<Scenario> scenarios = scenarioRule.matchOneOrMany();

		return new Story(storyName, scenarios);
	}


	@Override
	public boolean lookAhead() {
		return false;
	}

}