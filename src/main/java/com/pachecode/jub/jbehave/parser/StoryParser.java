package com.pachecode.jub.jbehave.parser;


import com.pachecode.jub.bdd.Examples;
import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Story;

import java.util.ArrayList;
import java.util.List;


public class StoryParser {

  final ScenarioRule SCENARIO;
  private final String storyName;


  public StoryParser(String storyName, LineLexer lineLexer) {
    this.storyName = storyName;
    SCENARIO = new ScenarioRule(lineLexer, null);
	}

  public StoryParser(String storyName, String string) {
    this(storyName, new LineLexer(string));
  }

  public Story parse() {
		return new Story(storyName, SCENARIO.matchOneOrMany());
	}

}