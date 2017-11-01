package com.pachecode.jub.bdd;

import org.junit.Test;

import static com.pachecode.jub.bdd.Step.StepType.*;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 10/31/2017.
 */
public class StepTest {

   @Test
   public void testStepEquals() {
      new Step(Given, "a precondition").equals(new Step(Given, "a precondition"));
      new Step(When, "a precondition").equals(Step.parse("When a precondition"));
   }

   @Test
   public void testStepNotEquals() {
      new Step(Given, "a precondition").equals(new Step(When, "a precondition"));
      new Step(When, "a preconditionssss").equals(Step.parse("When a precondition"));
   }
}
