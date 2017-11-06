package com.pachecode.jub.annotation;

/**
 * Created by Ricardo on 4/3/2017.
 */
public class JubUtils {
   public static void given(String text) {
      ScenarioAnnotationHandler.instance.getScenarioRunnerFromThisMethod().given(text);
   }

   public static void when(String text) {
      ScenarioAnnotationHandler.instance.getScenarioRunnerFromThisMethod().when(text);
   }

   public static void then(String text) {
      ScenarioAnnotationHandler.instance.getScenarioRunnerFromThisMethod().then(text);
   }
}
