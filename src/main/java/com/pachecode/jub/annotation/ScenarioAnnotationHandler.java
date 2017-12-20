package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.runner.PredefinedScenarioRunner;
import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ricardo on 3/23/2017.
 */
public class ScenarioAnnotationHandler {

  public static ScenarioAnnotationHandler instance = new ScenarioAnnotationHandler();

  ConcurrentHashMap<String, ScenarioRunner> scenarioRunners = new ConcurrentHashMap<>();


  public ScenarioRunner init(String testClassName, String methodName) {
    return scenarioRunners.computeIfAbsent(
        runnerKey(testClassName, methodName),
        s -> createRunner(testClassName, methodName));
  }


  /**
   *
   * @return the active Scenario-Runner. Assuming that there is a method in the current
   *          stack with the @Scenario annotation
   */
  public ScenarioRunner getActiveRunner() {
    Method method = AnnotationUtils.getCallerMethodWithAnnotation(Scenario.class);
    return scenarioRunners.get(runnerKey(method.getDeclaringClass().getName(), method.getName()));
  }


  private ScenarioRunner createRunner(String testClassName, String methodName) {
    com.pachecode.jub.bdd.Story story = StoryAnnotationHandler.instance.getStory(testClassName);
    Scenario scenarioAnnotation = AnnotationUtils.getAnnotation(Scenario.class, testClassName, methodName);

    if(story.getScenarios().isEmpty())
      return new SimpleScenarioRunner(scenarioAnnotation.value());
    else
      return new PredefinedScenarioRunner(story.getScenario(scenarioAnnotation.value()));
  }



  public ScenarioRunner getRunner(String testClassName, String methodName) {
    return scenarioRunners.get(runnerKey(testClassName, methodName));
  }



  private String runnerKey(String testClassName, String testMethodName) {
    return testClassName + ":" + testMethodName;
  }

}
