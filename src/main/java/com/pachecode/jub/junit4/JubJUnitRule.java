package com.pachecode.jub.junit4;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */
import static org.junit.Assert.fail;

import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import com.pachecode.jub.annotation.JubScenarioAnnotationHandler;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class JubJUnitRule extends TestWatcher {

   String watchedLog;
   JubScenarioAnnotationHandler scenarioUtils = JubScenarioAnnotationHandler.instance;


   public JubJUnitRule() {

   }

   @Override
   public Statement apply(Statement base, Description description) {
      return super.apply(base, description);
   }

   @Override
   protected void succeeded(Description desc) {
      watchedLog += desc.getDisplayName() + " " + "success!\n";

      scenarioUtils.getScenarioFromTestMethod( desc.getClassName(), desc.getMethodName())
              .successfulFinish();
   }

   @Override
   protected void failed(Throwable e, Description desc) {
      watchedLog += desc.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
   }


   @Override
   protected void starting(Description description) {
      super.starting(description);
      SimpleScenarioRunner scenario = scenarioUtils.registerOrGetScenario( description.getClassName(), description.getMethodName());
   }

   @Override
   protected void finished(Description description) {

      super.finished(description);
   }


};

