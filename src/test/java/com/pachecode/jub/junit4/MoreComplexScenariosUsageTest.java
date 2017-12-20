package com.pachecode.jub.junit4;

import com.pachecode.jub.annotation.Scenario;
import com.pachecode.jub.annotation.Story;
import com.pachecode.jub.bdd.StepParams;
import org.junit.ComparisonFailure;
import org.junit.Rule;
import org.junit.Test;

import static com.pachecode.jub.annotation.JubUtils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


/**
 * Created by Ricardo on 3/23/2017.
 */
@Story(resource = "complex_scenarios.story")
public class MoreComplexScenariosUsageTest {

   @Rule
   public JUnitBehavesRule jUnitRule = new JUnitBehavesRule();

   @Test
   @Scenario("A sum")
   public void sumIsCorrectTest() {
      Given("number {a} and {b}");

      assertThat(params().getInt("a"), is(1));

      assertThat(params().getInt("b"), is(3));

      When("I press calculate sum");
      Then("I see 4");
   }

   @Test
   @Scenario("A sum with examples")
   public void sumWithExamplesTest() {
      Given("number <a> and <b>");
      When("I press calculate sum");
      Then("I see <result>");
      assertThat(params().getInt("a") + params().getInt("b"), is(params().getInt("result")));
   }
}
