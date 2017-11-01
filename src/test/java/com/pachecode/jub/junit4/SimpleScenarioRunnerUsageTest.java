package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.given;
import static com.pachecode.jub.annotation.JubUtils.then;
import static com.pachecode.jub.annotation.JubUtils.when;


/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/23/2017.
 */
public class SimpleScenarioRunnerUsageTest {

   @Rule
   public JubJUnitRule jubJUnitRule = new JubJUnitRule();

   @Test
   @Scenario("The calculator sums correctly")
   public void sumIsCorrectTest() {
      given("precondition");
      when("action");
      then("outcome");
   }

}
