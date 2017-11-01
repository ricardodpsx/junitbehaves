package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Step;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 10/30/2017.
 */
public class StepResult {
   final Step step;
   final boolean succeeded ;

   public StepResult(Step step) {
      this.step = step;
      this.succeeded = false;
   }

   private StepResult(Step step, boolean succeeded) {
      this.step = step;
      this.succeeded = succeeded;
   }

   StepResult makeSucceeded() {
      return new StepResult(step, true);
   }

   public String getText() {
      return step.getLine();
   }

   public boolean didSucceed() {
      return succeeded;
   }

   public Step getStep() {
      return step;
   }
}


