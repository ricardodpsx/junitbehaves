package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.given;
import static com.pachecode.jub.annotation.JubUtils.then;
import static com.pachecode.jub.annotation.JubUtils.when;
import static org.junit.Assert.fail;


@Story("As User I want to Calculate")
public class SimpleScenarioRunnerUsageTest {

   @Rule
   public JUnitBehaves simpleRunner = new JUnitBehaves();

   @Test
   @Scenario("The calculator sums correctly")
   public void sumIsCorrectTest() {
      given("The calculator is empty");
      when("I sum 1 + 2");
      then("Then I should see 3");
   }

   @Test
   @Scenario("The calculator multiplies correctly")
   public void multipliesCorrectly() {
      given("The calculator is empty");
      when("I multiply 2 * 3");
      then("I should see 6");
      fail();
   }

}
