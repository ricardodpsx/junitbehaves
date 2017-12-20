package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.Given;
import static com.pachecode.jub.annotation.JubUtils.Then;
import static com.pachecode.jub.annotation.JubUtils.When;
import static org.junit.Assert.fail;


/**
 * Created by Ricardo on 3/23/2017.
 */
@Story(resource = "test_2_scenarios.story")
public class PredefinedScenarioRunnerUsageTest {

   @Rule
   public JUnitBehavesRule jUnitRule = new JUnitBehavesRule();

   @Test
   @Scenario("A Simple Acceptance Criteria")
   public void sumIsCorrectTest() {
      Given("a system state");
      When("something happen");
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      Then("the system state changes");
   }

   @Test
   @Scenario("A Simple Acceptance Criteria")
   public void shouldFailAtSecondStep() {
      Given("a system state");
      When("something happen");
      fail();
      Then("the system state changes");
   }


   @Test
   @Scenario("An acceptance criteria with Parameters")
   public void shouldFailByWrongFirstStep() {
      Given("a system state");
      When("I do something");
   }

   @Test
   @Scenario("An acceptance criteria with Parameters")
   public void shouldFailByPendingSteps() {
      Given("I type 1 and 2");
      When("I command to sum");
   }

}
