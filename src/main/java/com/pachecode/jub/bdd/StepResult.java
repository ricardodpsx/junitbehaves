package com.pachecode.jub.bdd;

/**
 * Created by Ricardo on 10/30/2017.
 */
public class StepResult {
   final Step step;
   final Status status ;

   public Status getStatus() {
      return status;
   }


   public enum Status {
      Pending, Succeeded, Failed
   }

   public StepResult(Step step) {
      this.step = step;
      this.status = Status.Pending;
   }

   public StepResult(Step step,Status status) {
      this.step = step;
      this.status = status;
   }

   public String getText() {
      return step.toString();
   }

   public boolean didSucceed() {
      return Status.Succeeded == status;
   }

   public Step getStep() {
      return step;
   }
}


