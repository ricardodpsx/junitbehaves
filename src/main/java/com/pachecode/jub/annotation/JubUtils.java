package com.pachecode.jub.annotation;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 4/3/2017.
 */
public class JubUtils {
   public static void given(String text) {
      JubScenarioAnnotationHandler.instance.getScenarioFromThisMethod().given(text);
   }

   public static void when(String text) {
      JubScenarioAnnotationHandler.instance.getScenarioFromThisMethod().when(text);
   }

   public static void then(String text) {
      JubScenarioAnnotationHandler.instance.getScenarioFromThisMethod().then(text);
   }
}
