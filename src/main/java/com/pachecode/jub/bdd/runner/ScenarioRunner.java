package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepParams;
import com.pachecode.jub.bdd.StepResult;

import java.util.List;

/**
 * Created by Ricardo on 11/5/2017.
 */
public abstract class ScenarioRunner {
   public abstract void runStep(Step step);

   public abstract String getName();

   public abstract boolean succeeded();

   public abstract void doFinishSuccessfully();

   public abstract List<StepResult> getResults();

   public abstract void doFailed();

   @Override
   public String toString() {
      String out = "Scenario: " + getName() + "\n";
      for(StepResult result : getResults())
         out += String.format("  %s [%s] %n", result.getStep(), result.getStatus());

      return out;
   }

}
