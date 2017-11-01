package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/23/2017.
 */
public class JubScenarioAnnotationHandler {

   public static final JubScenarioAnnotationHandler instance = new JubScenarioAnnotationHandler();

   HashMap<String, SimpleScenarioRunner> scenarios = new HashMap<>();


   public SimpleScenarioRunner registerOrGetScenario(String testClassName, String methodName) {
      SimpleScenarioRunner scenario = getScenarioFromTestMethod(testClassName, methodName);
      if(scenario != null)
         return scenario;

      String scenarioName = getScenarioNameFromAnnotation(getMethodObject(testClassName, methodName));
      return registerScenario(testClassName, methodName, new SimpleScenarioRunner(scenarioName));
   }


   public SimpleScenarioRunner registerScenario(String testClassName, String testMethodName, SimpleScenarioRunner scenario) {
      scenarios.put(scenarioId(testClassName, testMethodName), scenario);
      return scenario;
   }

   private String scenarioId(String testClassName, String testMethodName) {
      return testClassName + ":" + testMethodName;
   }

   String getCallerId() {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      try {
         for(StackTraceElement st: stackTrace) {
            Method method = getMethodObject(st.getClassName(), st.getMethodName());
            if (hasAnnotation(method, Test.class))
               return scenarioId(st.getClassName(), st.getMethodName());
         }
         throw new RuntimeException("No caller Test Method  found");
      } catch (Exception e) {
         throw new RuntimeException("Problems getting caller test method", e);
      }
   }

   SimpleScenarioRunner getScenarioFromThisMethod() {
      return scenarios.get(getCallerId());
   }


   Method getMethodObject(String className, String methodName) {
      try {
         for(Method m: Class.forName(className).getDeclaredMethods())
            if(m.getName().equals(methodName))
               return m;

         throw new RuntimeException("Method " + methodName + " don't exist in class " + className);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   boolean hasAnnotation(AnnotatedElement obj, Class tClass) {
         for(Annotation a: obj.getAnnotations())
            if(tClass.isInstance(a))
               return true;
         return false;
   }

   private String getScenarioNameFromAnnotation(Method testMethod) {
      for(Annotation a: testMethod.getAnnotations())
         if(a instanceof Scenario)
            return ((Scenario) a).value();

      throw new RuntimeException(testMethod.getName() + " must have a @Scenario annotation");
   }


   public SimpleScenarioRunner getScenarioFromTestMethod(String testClassName, String methodName) {
      return scenarios.get(scenarioId(testClassName, methodName));
   }


}
