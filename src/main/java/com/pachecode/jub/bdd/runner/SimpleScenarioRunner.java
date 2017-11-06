package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepResult;

import java.util.*;

import static com.pachecode.jub.bdd.Step.StepType.*;


/**
 * Created by Ricardo on 3/22/2017.
 */
public class SimpleScenarioRunner implements ScenarioRunner {

   private final String name;
   //private final JbehaveReport report;
   List<Step> steps = new ArrayList<>();

   int successFullSteps = -1;

   public SimpleScenarioRunner(String name) {
      this.name = name;
     // this.report = report;
   }

   //TODO: Remove "given when then and" methods from this class
   @Override
   public void given(String stepLine) {
      runStep(new Step(Given, stepLine));
   }

   @Override
   public void  when(String stepLine) {
      runStep(new Step(When, stepLine));
   }

   @Override
   public void then(String stepLine) {
      runStep(new Step(Then, stepLine));
   }

   @Override
   public void and(String stepLine) {
      runStep(new Step(And, stepLine));
   }

   void runStep(Step step) {
      successFullSteps++;
      steps.add(step);
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public boolean succeeded() {
      return successFullSteps == steps.size();
   }


   public void doFinishSuccessfully() {
      successFullSteps++;
   }

   /**
    * This function should be called at the end of the steps execution
    */
   @Override
   public void doFinish() {
      //report.onScenarioFinish(getResults());
   }

   @Override
   public List<StepResult> getResults() {
      List<StepResult> results =  new ArrayList<>();

      for(int i = 0; i < steps.size(); i++) {
         if(i < successFullSteps)
            results.add(new StepResult(steps.get(i), StepResult.Status.Succeeded));
         else if(i == successFullSteps)
            results.add(new StepResult(steps.get(i), StepResult.Status.Failed));
         else
            results.add(new StepResult(steps.get(i), StepResult.Status.Pending));
      }

      return results;
   }


}
