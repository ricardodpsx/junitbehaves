package com.pachecode.jub.bdd;

import org.junit.Test;

import static com.pachecode.jub.bdd.Step.StepType.*;

/**
 * Created by Ricardo on 10/31/2017.
 */
public class StepTest {

   @Test
   public void testStepMatches() {
      new Step(Given, "a precondition").matches(Step.create("Given a precondition"));
      new Step(When, "a precondition").matches(Step.create("When a precondition"));
      new Step(When, "a precondition").matches("When a precondition");
   }

   @Test
   public void testStepNotEquals() {
      new Step(Given, "a precondition").equals(Step.create("Given a precondition"));
      new Step(When, "a preconditionssss").equals(Step.create("When a precondition"));
   }

   @Test(expected = InvalidStepException.class)
   public void testInvalidStep() {
      Step.create("Givensss a precondition");
   }


}
