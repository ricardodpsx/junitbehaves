package com.pachecode.jub.jbehave.parser;


import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
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
public class ScenarioParserTest {

  @Test
  public void testSimpleScenario() throws IOException {
    String storyFile = readResourceContents("test_simple_scenario.story");
    ScenarioRule parser = new ScenarioRule(new Parser(storyFile), null);

    Scenario scenario = parser.match();
    List<Step> steps = scenario.getSteps();

    assertThat(scenario.getName(), is("A Simple Acceptance Criteria"));
    assertThat(scenario.getSteps().size(), is(3));
    assertThat(steps.get(0).toString(), is("Given a system \"state\""));
    assertThat(steps.get(1).toString(), is("When something happen"));
    assertThat(steps.get(2).toString(), is("Then the system state changes"));
  }


  @Test
  public void testScenarioWithMultiLineStep() {
    String storyFile = readResourceContents("test_step_with_body.story");

    ScenarioRule parser = new ScenarioRule(new Parser(storyFile), null);
    Scenario scenario = parser.match();
    List<Step> steps = scenario.getSteps();


    assertThat(steps.size(), is(3));

    assertThat(steps.get(0).toString(), is("Given a system state"));
    assertThat(steps.get(0).getBody(), containsString("Hello world"));
  }

  @Test
  public void testScenarioWithAndSteps() {
    String storyFile = readResourceContents("test_steps_with_and.story");

    ScenarioRule parser = new ScenarioRule(new Parser(storyFile), null);
    Scenario scenario = parser.match();
    List<Step> steps = scenario.getSteps();

    assertThat(steps.get(0).toString(), is("Given a system state"));
    assertThat(steps.get(1).toString(), is("And another system state"));
    assertThat(steps.get(3).toString(), is("And an event"));
    assertThat(steps.get(4).toString(), is("And another event"));
  }

}
