package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import com.pachecode.jub.bdd.runner.StepResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */
public class SimpleScenarioRunnerTest {

   SimpleScenarioRunner scenario = new SimpleScenarioRunner("Sum Scenario");

   @Test
   public void testSimpleSuccessfulJbehave() {
      aSuccessTestMethod(scenario);

      assertEquals("Given the calculator is empty", scenario.calledSteps().get(0).getText());
      assertEquals("When I type 2,+ and 2", scenario.calledSteps().get(1).getText());
      assertEquals("Then I see '4'", scenario.calledSteps().get(2).getText());


      scenario.successfulFinish();

      for (StepResult result : scenario.calledSteps()) assertTrue(result.didSucceed());
   }

      private void aSuccessTestMethod(SimpleScenarioRunner simpleScenarioRunner) {
         simpleScenarioRunner.given("the calculator is empty");
         int calculator = 0;

         simpleScenarioRunner.when("I type 2,+ and 2");
         calculator = 2 + 2;

         simpleScenarioRunner.then("I see '4'");
         assertEquals(4, calculator);
      }

   @Test
   public void testFailingJbehave() {
      try {
         aFailingTestMethod(scenario);
      } catch (AssertionError e) {
         assertTrue(scenario.calledSteps().get(1).didSucceed());
         assertTrue(!scenario.calledSteps().get(2).didSucceed());
      }

      scenario.successfulFinish();
   }

   private void aFailingTestMethod(SimpleScenarioRunner simpleScenarioRunner) {
      simpleScenarioRunner.given("the calculator is empty");
      int calculator = 0;

      simpleScenarioRunner.when("I type 2,+ and 2");
      calculator = 2 + 3;

      simpleScenarioRunner.then("I see '4'");
      assertEquals(4, calculator);
   }



}
