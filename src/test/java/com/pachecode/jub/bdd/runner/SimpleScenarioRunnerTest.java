package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.ScenarioReportPrinter;
import com.pachecode.jub.bdd.StepResult;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Ricardo on 3/22/2017.
 */
public class SimpleScenarioRunnerTest {

   ScenarioRunner runner = new SimpleScenarioRunner("Sum Scenario");

   @Test
   public void testSimpleSuccessfulJbehave() {
      aSuccessTestMethod(runner);

      assertEquals("Given the calculator is empty", runner.getResults().get(0).getText());
      assertEquals("When I type 2,+ and 2", runner.getResults().get(1).getText());
      assertEquals("Then I see '4'", runner.getResults().get(2).getText());


      runner.doFinishSuccessfully();

      for (StepResult result : runner.getResults()) assertTrue(result.didSucceed());
      assertTrue(runner.succeeded());
   }

      private void aSuccessTestMethod(ScenarioRunner scenarioRunner) {
         scenarioRunner.given("the calculator is empty");
         int calculator = 0;

         scenarioRunner.when("I type 2,+ and 2");
         calculator = 2 + 2;

         scenarioRunner.then("I see '4'");
         assertEquals(4, calculator);
      }

   @Test
   public void testFailingJbehave() {
      try {
         aFailingTestMethod(runner);
         fail();
      } catch (AssertionError e) {
         assertTrue(runner.getResults().get(1).didSucceed());
         assertTrue(!runner.getResults().get(2).didSucceed());
      }

      assertFalse(runner.succeeded());

      new ScenarioReportPrinter().print(runner);

   }

   private void aFailingTestMethod(ScenarioRunner scenarioRunner) {
      scenarioRunner.given("the calculator is empty");
      int calculator;

      scenarioRunner.when("I type 2,+ and 2");
      calculator = 2 + 3;

      scenarioRunner.then("I see '4'");
      assertEquals(4, calculator);

      scenarioRunner.and("This will be ignored");

   }



}
