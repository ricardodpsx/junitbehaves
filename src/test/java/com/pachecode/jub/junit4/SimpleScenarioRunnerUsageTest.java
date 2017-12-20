package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.Given;
import static com.pachecode.jub.annotation.JubUtils.Then;
import static com.pachecode.jub.annotation.JubUtils.When;
import static org.junit.Assert.fail;


@Story("As User I want to Calculate")
public class SimpleScenarioRunnerUsageTest {

   @Rule
   public JUnitBehavesRule simpleRunner = new JUnitBehavesRule();

   @Test
   @Scenario("The calculator sums correctly")
   public void sumIsCorrectTest() {
      Given("The calculator is empty");
      When("I sum 1 + 2");
      Then("Then I should see 3");
   }

   @Test
   @Scenario("The calculator multiplies correctly")
   public void thisShouldFail() {
      Given("The calculator is empty");
      When("I multiply 2 * 3");
      Then("I should see 6");
      fail();
   }

}
