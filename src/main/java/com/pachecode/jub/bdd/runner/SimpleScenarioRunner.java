package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;

import java.util.*;

import static com.pachecode.jub.bdd.Step.StepType.*;


/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */
public class SimpleScenarioRunner {

   private final Scenario scenario;
   Deque<StepResult> calledSteps = new ArrayDeque<>();


   public SimpleScenarioRunner(String name) {
      scenario = new Scenario(name);
   }

   public void given(String text) {
      step(new Step(Given, text));
   }

   public void  when(String text) {
      step(new Step(When, text));
   }

   public void then(String text) {
      step(new Step(Then, text));
   }

   void step(Step step) {
      makeLastSteepSucceed();
      scenario.addStep(step);
      calledSteps.push(new StepResult(scenario.getLastStep()));
   }

   private void makeLastSteepSucceed() {
      if(!calledSteps.isEmpty())
         calledSteps.push(calledSteps.pop().makeSucceeded());
   }


   public List<StepResult> calledSteps() {
      List<StepResult> stepsList =  new ArrayList<>(calledSteps);
      Collections.reverse(stepsList);
      return stepsList;
   }

   public void successfulFinish() {
      makeLastSteepSucceed();
   }

   public String getName() {
      return scenario.getName();
   }

   public boolean didFailed() {
      return !calledSteps.peek().didSucceed();
   }

   public Step lastRunStep() {
      return calledSteps.peek().getStep();
   }
}
