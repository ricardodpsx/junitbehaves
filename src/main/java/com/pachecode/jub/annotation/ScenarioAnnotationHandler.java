package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.*;
import com.pachecode.jub.bdd.runner.PredefinedScenarioRunner;
import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ricardo on 3/23/2017.
 */
public class ScenarioAnnotationHandler {

  public static final ScenarioAnnotationHandler instance = new ScenarioAnnotationHandler();

  ConcurrentHashMap<String, ScenarioRunner> scenarioRunners = new ConcurrentHashMap<>();


  public ScenarioRunner registerOrGetScenarioRunner(String testClassName, String methodName) {
    ScenarioRunner scenario = getScenarioFromTestMethod(testClassName, methodName);
    if (scenario != null)
      return scenario;

    String scenarioName = getScenarioNameFromAnnotation(getMethodObject(testClassName, methodName));

    com.pachecode.jub.bdd.Story story = StoryAnnotationHandler.instance.getStory(testClassName);

    if(story.getScenarios().isEmpty())
      return registerScenario(testClassName, methodName, new SimpleScenarioRunner(scenarioName));
    else {
      com.pachecode.jub.bdd.Scenario s = story.getScenario(scenarioName);
      return registerScenario(testClassName, methodName, new PredefinedScenarioRunner(s));
    }
  }


  public ScenarioRunner registerScenario(String testClassName, String testMethodName, ScenarioRunner runner) {
    scenarioRunners.put(scenarioId(testClassName, testMethodName), runner);
    return runner;
  }

  private String scenarioId(String testClassName, String testMethodName) {
    return testClassName + ":" + testMethodName;
  }

  String getCallerId() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    try {
      for (StackTraceElement st : stackTrace) {
        Method method = getMethodObject(st.getClassName(), st.getMethodName());
        if (hasAnnotation(method, Test.class))
          return scenarioId(st.getClassName(), st.getMethodName());
      }
      throw new RuntimeException("No caller Test Method  found");
    } catch (Exception e) {
      throw new RuntimeException("Problems getting caller test method", e);
    }
  }

  public ScenarioRunner getScenarioRunnerFromThisMethod() {
    return scenarioRunners.get(getCallerId());
  }


  Method getMethodObject(String className, String methodName) {
    try {
      for (Method m : Class.forName(className).getDeclaredMethods())
        if (m.getName().equals(methodName))
          return m;

      throw new RuntimeException("Method " + methodName + " don't exist in class " + className);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  boolean hasAnnotation(AnnotatedElement obj, Class tClass) {
    for (Annotation a : obj.getAnnotations())
      if (tClass.isInstance(a))
        return true;
    return false;
  }

  private String getScenarioNameFromAnnotation(Method testMethod) {
    for (Annotation a : testMethod.getAnnotations())
      if (a instanceof Scenario)
        return ((Scenario) a).value();

    throw new RuntimeException(testMethod.getName() + " must have a @Scenario annotation");
  }


  public ScenarioRunner getScenarioFromTestMethod(String testClassName, String methodName) {
    return scenarioRunners.get(scenarioId(testClassName, methodName));
  }

}
