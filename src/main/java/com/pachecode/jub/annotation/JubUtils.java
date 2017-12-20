package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepParams;
import com.pachecode.jub.bdd.StepType;
import com.pachecode.jub.bdd.runner.PredefinedScenarioRunner;

import static com.pachecode.jub.bdd.StepType.*;

/**
 * Created by Ricardo on 4/3/2017.
 */
public class JubUtils {
   public static void Given(String text) {
      runStep(Given, text);
   }

   public static void When(String text) {
      runStep(When, text);
   }

   public static void Then(String text) {
      runStep(Then, text);
   }

   public static void And(String text) {
      runStep(And, text);
   }

   private static void runStep(StepType type, String text) {
       ScenarioAnnotationHandler.instance
          .getActiveRunner()
          .runStep(new Step(type, text));
   }

   public static StepParams params() {
      return  ((PredefinedScenarioRunner) ScenarioAnnotationHandler.instance
          .getActiveRunner()).getParams();
   }

}
