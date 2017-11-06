package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepResult;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by Ricardo on 3/27/2017.
 */
public class PredefinedScenarioRunnerTest {

  Scenario scenario = new Scenario("Greetings", Arrays.asList(
      Step.create("Given the name is empty"),
      Step.create("When I type 'Ricardo'"),
      Step.create("Then I see 'Hello Ricardo'"),
      Step.create("And I say Hello back")
  ));

  PredefinedScenarioRunner scenarioRunner = new PredefinedScenarioRunner(scenario);

  @Test
  public void testScenarioName() {
    assertEquals("Greetings", scenarioRunner.getName());
  }


  @Test
  public void testSuccessfulCase() {
    scenarioRunner.given("the name is empty");
    String name = "";

    scenarioRunner.when("I type 'Ricardo'");
    name = "Hello Ricardo";

    scenarioRunner.then("I see 'Hello Ricardo'");
    assertEquals(name, "Hello Ricardo");

    scenarioRunner.and("I say Hello back");
    scenarioRunner.doFinishSuccessfully();

    assertTrue(scenarioRunner.succeeded());
  }

  @Test
  public void testFailedCase() {
    scenarioRunner.given("the name is empty");
    String name = "";

    scenarioRunner.when("I type 'Ricardo'");
    name = "Hi Ricardo";

    //If Finish is never called, that means there was an error
    assertFalse(scenarioRunner.succeeded());
  }

  @Test(expected = WrongStepException.class)
  public void testWrongStep() {
    scenarioRunner.given("the name is empty");

    scenarioRunner.when("I say blabla");
  }

  @Test(expected = WrongStepException.class)
  public void testWrongStepOrder() {
    scenarioRunner.given("the name is empty");
    scenarioRunner.then("I see 'Hello Ricardo'");
    scenarioRunner.when("I type 'Ricardo'");
  }

  @Test
  public void testPendingSteps() {
    scenarioRunner.given("the name is empty");
    scenarioRunner.when("I type 'Ricardo'");
    scenarioRunner.then("I see 'Hello Ricardo'");

    assertThat(scenarioRunner.getResults().get(3).getStatus(), is(StepResult.Status.Pending));
    assertThat(scenarioRunner.getResults().size(), is(scenario.getSteps().size()));
  }


}
