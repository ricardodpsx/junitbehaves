package com.pachecode.jub.bdd;

import org.junit.Test;

import static com.pachecode.jub.bdd.StepType.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ricardo on 10/31/2017.
 */
public class StepTest {


   @Test
   public void testStepEquals() {
      assertTrue(new Step(Given, "a precondition").equals(Step.create("Given a precondition")));
      assertFalse(new Step(When, "a preconditionssss").equals(Step.create("When a precondition")));
   }

   @Test(expected = InvalidStepException.class)
   public void testInvalidStep() {
      Step.create("Givensss a precondition");
   }


}
