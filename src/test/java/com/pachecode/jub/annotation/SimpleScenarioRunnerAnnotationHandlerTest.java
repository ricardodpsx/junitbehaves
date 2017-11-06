package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Ricardo on 3/22/2017.
 */
public class SimpleScenarioRunnerAnnotationHandlerTest {

   public static final String TEST_CLASS_NAME = "com.pachecode.jub.annotation.SimpleScenarioRunnerAnnotationHandlerTest";
   ScenarioAnnotationHandler scenarioUtils = new ScenarioAnnotationHandler();

   @Test
   public void testGettingAMethodFromTheCaller() {
      assertEquals(TEST_CLASS_NAME + ":testGettingAMethodFromTheCaller", aMethodCall());
   }

   private String aMethodCall() {
      return scenarioUtils.getCallerId();
   }

   @Scenario("Sum scenario")
   @Test
   public void testGetScenarioInstanceFromAnnotation() {
      ScenarioRunner scenario = new SimpleScenarioRunner("Sum Scenario");
      scenarioUtils.registerScenario(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation", scenario);
      assertEquals(scenario,  scenarioUtils.getScenarioRunnerFromThisMethod());
   }

   @Test
   public void testGetScenarioOfGivenTest() {
      ScenarioRunner scenario = scenarioUtils.registerOrGetScenarioRunner(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation");
      assertEquals("Sum scenario", scenario.getName());
      assertEquals(scenario, scenarioUtils.getScenarioFromTestMethod(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation"));
   }

   @Test
   @Scenario("Sum scenario")
   public void testStaticGivenWhenThen() {
      ScenarioAnnotationHandler handler = ScenarioAnnotationHandler.instance;

      //Registers the runner from this testMethod @Scenario annotation
      ScenarioRunner runner = handler.instance.registerOrGetScenarioRunner(this.getClass().getName(), "testStaticGivenWhenThen");

      //Checks if we can get the same runner
      assertEquals(runner, handler.getScenarioRunnerFromThisMethod());

      //This shouldn't throw exceptions
      JubUtils.given("one");
      JubUtils.when("two");
      JubUtils.then("three");
   }

   @Test
   public void createStoryScenariosFileFromClassAnnotiation() {



   }

}
