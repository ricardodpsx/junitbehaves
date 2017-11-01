package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.JubUtils;
import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import org.junit.Rule;
import org.junit.Test;


/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/23/2017.
 */
@Story("sum_scenario.story")
public class JubPredefinedScenarioRunnerUsageTest {

   @Rule
   public JubJUnitRule jubJUnitRule = new JubJUnitRule();

   @Test
   @Scenario("The calculator sums correctly")
   public void sumIsCorrectTest() {
      JubUtils.given("a system state");
      JubUtils.when("I do something");
      JubUtils.then("system is in a different state");
   }


   @Test
   @Scenario("The calculator sums correctly")
   public void thisTestShouldFail() {
      JubUtils.given("a system state");
      JubUtils.when("I do something");
   }

}
