package com.pachecode.jub.junit4;

/**
 * Created by Ricardo on 3/22/2017.
 */
import static org.junit.Assert.fail;

import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.annotation.ScenarioAnnotationHandler;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

//For JBEhave Examples: https://stackoverflow.com/questions/1492856/easy-way-of-running-the-same-junit-test-over-and-over
public class JUnitBehaves extends TestWatcher {

   @Override
   public Statement apply(Statement base, Description description) {
      Statement res = super.apply(base, description);
      return res;
   }

   @Override
   protected void succeeded(Description desc) {

      ScenarioRunner scenario = getScenarioRunner(desc);
      scenario.doFinishSuccessfully();

   }

   private ScenarioRunner getScenarioRunner(Description desc) {
      return ScenarioAnnotationHandler.instance.registerOrGetScenarioRunner(desc.getClassName(), desc.getMethodName());
   }

   @Override
   protected void failed(Throwable e, Description desc) {
   }


   @Override
   protected void starting(Description desc) {
      ScenarioRunner scenario = getScenarioRunner(desc);
      System.err.println("Scenario: " + scenario.getName());

      super.starting(desc);
   }

   @Override
   protected void finished(Description desc) {

      super.finished(desc);

      ScenarioRunner scenario = getScenarioRunner(desc);
      scenario.doFinish();
      System.err.println();
   }


}

