package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;

import java.util.*;

import static com.pachecode.jub.bdd.Step.StepType.*;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/27/2017.
 *
 * An simpleRunner that fails if doesn't follow the predefined Jbehave
 */
public class JubPredefinedScenarioRunner {

   SimpleScenarioRunner simpleRunner;
   final private Scenario referenceScenario;
   Deque<Step> stepsToRun = new ArrayDeque<>();

   public JubPredefinedScenarioRunner(Scenario referenceScenario) {
      this.referenceScenario = referenceScenario;
      stepsToRun.addAll(referenceScenario.getSteps());
      simpleRunner = new SimpleScenarioRunner(referenceScenario.getName());
   }

   public List<Step> steps() {
      return referenceScenario.getSteps();
   }

   void step(Step step) {

      if(stepsToRun.isEmpty())
         throw new JubWrongStepException(step.getLine(), "None!");

      if(!stepsToRun.getFirst().equals(step))
         throw new JubWrongStepException(step.getText(), stepsToRun.getFirst().getText());

      stepsToRun.poll();

      simpleRunner.step(step);
   }

   public void successfulFinish() {
      simpleRunner.successfulFinish();
   }

   void given(String text) {
      step(new Step(Given, text));
      simpleRunner.given(text);
   }

   void when(String text) {
      step(new Step(When, text));
      simpleRunner.when(text);
   }

   void then(String text) {
      step(new Step(Then, text));
      simpleRunner.then(text);
   }


   public String getName() {
      return simpleRunner.getName();
   }

   public boolean failed() {
      return simpleRunner.didFailed();
   }

}
