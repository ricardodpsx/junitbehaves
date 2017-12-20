package com.pachecode.jub.jbehave.parser;


import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.Story;
import org.junit.Test;

import java.util.List;

import static com.pachecode.jub.Utils.readResourceContents;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Ricardo on 9/14/2017.
 */
public class StoryParserTest {


  @Test
  public void testStoryWithOneScenario() {
    String storyFile = readResourceContents("test_simple_scenario.story");

    StoryParser parser = new StoryParser(storyFile, new LineLexer(storyFile));
    Story story = parser.parse();
    List<Scenario> scenarios = story.getScenarios();

    assertThat(scenarios.size(), is(1));
    assertThat(scenarios.get(0).getName(), is("A Simple Acceptance Criteria"));
  }

  @Test
  public void testStoryWithTwoScenarios() {
    String storyFile = readResourceContents("test_2_scenarios.story");

    StoryParser parser = new StoryParser(storyFile, new LineLexer(storyFile));
    Story story = parser.parse();
    assertThat(story.getScenarios().size(), is(2));

    List<Scenario> scenarios = story.getScenarios();

    assertThat(scenarios.get(0).getName(), is("A Simple Acceptance Criteria"));
    assertThat(scenarios.get(1).getName(), is("An acceptance criteria with Parameters"));
  }

  @Test
  public void testStoryWithScenariosWithExamples() {
    String storyFile = readResourceContents("test_steps_with_examples.story");

    StoryParser parser = new StoryParser(storyFile, new LineLexer(storyFile));
    Story story = parser.parse();
    List<Scenario> scenarios = story.getScenarios();
    Scenario firstScenario = scenarios.get(0);

    assertThat(scenarios.size(), is(3));

    assertThat(firstScenario.toString(), is("Given number <a> and <b>"));
    assertThat(firstScenario.toString(), is("When I press calculate sum"));
    assertThat(firstScenario.toString(), is("Then I see <result>"));

//    assertThat(scenario.getExamples().countColumns(), is(3));
//    assertThat(scenario.getExamples().countRows(), is(2));
//    assertThat(scenario.getExamples().get("a", 0), is("1"));
//    assertThat(scenario.getExamples().get("a", 1), is("3"));
  }

}
