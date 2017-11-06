package com.pachecode.jub.jbehave.parser;


import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.Story;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.pachecode.jub.Utils.readResourceContents;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Ricardo on 9/14/2017.
 */
public class StoryParserTest {


  @Test
  public void testStoryWithOneScenario() {
    String storyFile = readResourceContents("test_simple_scenario.story");

    StoryRule parser = new StoryRule(storyFile, new Parser(storyFile));
    Story story = parser.match();
    List<Scenario> scenarios = story.getScenarios();

    assertThat(scenarios.size(), is(1));
    assertThat(scenarios.get(0).getName(), is("A Simple Acceptance Criteria"));
  }

  @Test
  public void testStoryWithTwoScenarios() {
    String storyFile = readResourceContents("test_2_scenarios.story");

    StoryRule parser = new StoryRule(storyFile, new Parser(storyFile));
    Story story = parser.match();
    assertThat(story.getScenarios().size(), is(2));

    List<Scenario> scenarios = story.getScenarios();

    assertThat(scenarios.get(0).getName(), is("A Simple Acceptance Criteria"));
    assertThat(scenarios.get(1).getName(), is("An acceptance criteria with Parameters"));
  }

}
