package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.given;
import static com.pachecode.jub.annotation.JubUtils.then;
import static com.pachecode.jub.annotation.JubUtils.when;


/**
 * Created by Ricardo on 3/23/2017.
 */
@Story(resource = "test_2_scenarios.story")
public class PredefinedScenarioRunnerUsageTest {

   @Rule
   public JUnitBehaves jUnitRule = new JUnitBehaves();

   @Test
   @Scenario("A Simple Acceptance Criteria")
   public void sumIsCorrectTest() {
      given("a system state");
      when("something happen");
      then("the system state changes");
   }


   @Test
   @Scenario("An acceptance criteria with Parameters")
   public void thisTestShouldFail() {
      given("a system state");
      when("I do something");
   }

}
