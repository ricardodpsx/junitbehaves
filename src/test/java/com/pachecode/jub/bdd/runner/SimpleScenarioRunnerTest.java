package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepResult;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.pachecode.jub.bdd.StepType.*;

/**
 * Created by Ricardo on 3/22/2017.
 */
public class SimpleScenarioRunnerTest {

   ScenarioRunner runner = new SimpleScenarioRunner("Sum Scenario");

   @Test
   public void testSimpleSuccessfulJbehave() {
      aSuccessTestMethod(runner);
      runner.doFinishSuccessfully();

      assertEquals("Given the calculator is empty", runner.getResults().get(0).getText());
      assertEquals("When I type 2,+ and 2", runner.getResults().get(1).getText());
      assertEquals("Then I see '4'", runner.getResults().get(2).getText());

      for (StepResult result : runner.getResults()) assertTrue(result.isSuccess());
        assertTrue(runner.succeeded());
   }

      private void aSuccessTestMethod(ScenarioRunner scenarioRunner) {
         scenarioRunner.runStep(new Step(Given, "the calculator is empty"));
         int calculator = 0;

         scenarioRunner.runStep(new Step(When, "I type 2,+ and 2"));
         calculator = 2 + 2;

         scenarioRunner.runStep(new Step(Then, "I see '4'"));
         assertEquals(4, calculator);
      }





   @Test
   public void testFailingJbehave() {
      try {
         aFailingTestMethod(runner);
         fail();
      } catch (AssertionError e) {
        runner.doFailed();
        assertTrue(runner.getResults().get(1).isSuccess());
        assertTrue(!runner.getResults().get(2).isSuccess());
      }

      assertFalse(runner.succeeded());
   }

   private void aFailingTestMethod(ScenarioRunner scenarioRunner) {
      scenarioRunner.runStep(new Step(Given, "the calculator is empty"));
      int calculator;

      scenarioRunner.runStep(new Step(When, "I type 2,+ and 2"));
      calculator = 2 + 3;

      scenarioRunner.runStep(new Step(Then, "I see '4'"));
      assertEquals(4, calculator);

      scenarioRunner.runStep(new Step(And, "This will be ignored"));

   }



}
