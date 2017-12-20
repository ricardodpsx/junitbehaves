package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepParams;
import com.pachecode.jub.bdd.StepResult;

import java.util.*;

/**
 * Created by Ricardo on 3/22/2017.
 */
public class SimpleScenarioRunner extends ScenarioRunner {

   private final String name;
   List<Step> steps = new ArrayList<>();

  List<StepResult> results =  new ArrayList<>();

  Step lastRunStep = null;

  boolean succeeded = false;


   public SimpleScenarioRunner(String name) {
      this.name = name;
   }


   @Override
   public void runStep(Step step) {

     if(lastRunStep != null)
       results.add(new StepResult(lastRunStep, StepResult.Status.Succeeded));

      steps.add(step);
      lastRunStep = step;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public boolean succeeded() {
     return succeeded;
   }


   public void doFinishSuccessfully() {
     if(lastRunStep != null)
       results.add(new StepResult(lastRunStep, StepResult.Status.Succeeded));

     succeeded = true;
   }

  @Override
  public List<StepResult> getResults() {
      return new ArrayList<>(results);
   }

  @Override
  public void doFailed() {
    if(lastRunStep != null)
      results.add(new StepResult(lastRunStep, StepResult.Status.Failed));

    succeeded = false;
  }


}
