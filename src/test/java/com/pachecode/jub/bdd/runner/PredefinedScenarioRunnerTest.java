package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.*;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static com.pachecode.jub.bdd.StepType.*;

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
    scenarioRunner.runStep(new Step(Given, "the name is empty"));
    String name = "";

    scenarioRunner.runStep(new Step(When,"I type 'Ricardo'"));
    name = "Hello Ricardo";

    scenarioRunner.runStep(new Step(Then, "I see 'Hello Ricardo'"));
    assertEquals(name, "Hello Ricardo");

    scenarioRunner.runStep(new Step(And, "I say Hello back"));
    scenarioRunner.doFinishSuccessfully();

    assertTrue(scenarioRunner.succeeded());
  }

  @Test
  public void testFailedCase() {
    scenarioRunner.runStep(new Step(Given, "the name is empty"));
    String name = "";

    scenarioRunner.runStep(new Step(When, "I type 'Ricardo'"));
    name = "Hi Ricardo";

    //If Finish is never called, that means there was an error
    assertFalse(scenarioRunner.succeeded());
  }

  @Test(expected = WrongStepException.class)
  public void testWrongStep() {
    scenarioRunner.runStep(new Step(Given, "the name is empty"));

    scenarioRunner.runStep(new Step(When, "I say blabla"));
  }

  @Test(expected = WrongStepException.class)
  public void testWrongStepOrder() {
    scenarioRunner.runStep(new Step(Given, "the name is empty"));
    scenarioRunner.runStep(new Step(Then, "I see 'Hello Ricardo'"));
    scenarioRunner.runStep(new Step(When, "I type 'Ricardo'"));
  }

  @Test
  public void testPendingSteps() {
    scenarioRunner.runStep(new Step(Given, "the name is empty"));
    scenarioRunner.runStep(new Step(When, "I type 'Ricardo'"));
    scenarioRunner.runStep(new Step(Then, "I see 'Hello Ricardo'"));
    try {
      scenarioRunner.doFinishSuccessfully();
      fail("Should fail when calling finish successfully due to pending steps");
    } catch (ScenarioException e) {

    }

    assertThat(scenarioRunner.getResults().get(2).getStatus(), is(StepResult.Status.Succeeded));
    assertThat(scenarioRunner.getResults().get(3).getStatus(), is(StepResult.Status.Pending));
    assertThat(scenarioRunner.getResults().size(), is(scenario.getSteps().size()));
  }


  @Test
  public void testStepMatches() {
    scenarioRunner.matches(new Step(Given, "a precondition"),
        Step.create("Given a precondition"));

    scenarioRunner.matches(new Step(When, "a precondition"), Step.create("When a precondition"));
    scenarioRunner.matches(new Step(When, "a precondition"), Step.create("When a precondition"));
  }


}
