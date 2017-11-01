package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.runner.JubPredefinedScenarioRunner;
import com.pachecode.jub.bdd.runner.JubWrongStepException;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/27/2017.
 */
public class JubPredefinedScenarioRunnerTest {

   Scenario scenario = new Scenario("Greetings",  Arrays.asList(
     Step.parse("Given the name is empty"), Step.parse("When I type 'Ricardo'"), Step.parse("Then I see 'Hello Ricardo'")
   ));

   JubPredefinedScenarioRunner scenarioRunner = new JubPredefinedScenarioRunner(scenario);

   @Test
   public void testScenarioName() {
      assertEquals("Greetings", scenarioRunner.getName());
   }

   @Test
   public void testSuccessfulScenarioWithStory() {
      assertTrue(scenarioRunner.steps().get(0).matches("Given the name is empty"));
      assertTrue(scenarioRunner.steps().get(1).matches("When I type 'Ricardo'"));
      assertTrue(scenarioRunner.steps().get(2).matches("Then I see 'Hello Ricardo'"));
   }


   @Test
   public void testSuccessfulCase() {
      scenarioRunner.given("the name is empty");
      String name = "";

      scenarioRunner.when("I type 'Ricardo'");
      name = "Hello Ricardo";

      scenarioRunner.then("I see 'Hello Ricardo'");
      assertEquals(name, "Hello Ricardo");

      scenarioRunner.successfulFinish();

      assertFalse(scenarioRunner.failed());
   }

   @Test
   public void testFailedCase() {
         scenarioRunner.given("the name is empty");
         String name = "";

         scenarioRunner.when("I type 'Ricardo'");
         name = "Hi Ricardo";

         //Finish is never called, that means there was an error
      assertTrue(scenarioRunner.failed());
   }

   @Test(expected = JubWrongStepException.class)
   public void testStoriesWrongStep() {
      scenarioRunner.given("the name is empty");

      scenarioRunner.when("I say blabla");
   }

   @Test(expected = JubWrongStepException.class)
   public void testStoriesWrongOrder() {
      scenarioRunner.given("the name is empty");
      scenarioRunner.then("I see 'Hello Ricardo'");
      scenarioRunner.when("I type 'Ricardo'");
   }

}
