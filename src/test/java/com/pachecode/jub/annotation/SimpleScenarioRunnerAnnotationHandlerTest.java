package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */
@Story("sum_scenario.story")
public class SimpleScenarioRunnerAnnotationHandlerTest {

   public static final String TEST_CLASS_NAME = "com.pachecode.jub.annotation.SimpleScenarioRunnerAnnotationHandlerTest";
   JubScenarioAnnotationHandler scenarioUtils = new JubScenarioAnnotationHandler();

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
      SimpleScenarioRunner scenario = new SimpleScenarioRunner("Sum Scenario");
      scenarioUtils.registerScenario(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation", scenario);
      assertEquals(scenario,  scenarioUtils.getScenarioFromThisMethod());
   }

   @Test
   public void testGetScenarioOfGivenTest() {
      SimpleScenarioRunner scenario = scenarioUtils.registerOrGetScenario(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation");
      assertEquals("Sum scenario", scenario.getName());
      assertEquals(scenario, scenarioUtils.getScenarioFromTestMethod(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation"));
   }

   @Test
   @Scenario("Sum scenario")
   public void testStaticGivenWhenThen() {
      //Registers the scenario from this testMethod @Scenario annotation
      SimpleScenarioRunner scenario = JubScenarioAnnotationHandler.instance.registerOrGetScenario(this.getClass().getName(), "testStaticGivenWhenThen");

      //Checks if we can get the same scenario
      assertEquals(scenario, JubScenarioAnnotationHandler.instance.getScenarioFromThisMethod());

      //This shouldn't throw exceptions
      JubUtils.given("one");
      JubUtils.when("two");
      JubUtils.then("three");
   }

   @Test
   public void createStoryScenariosFileFromClassAnnotiation() {



   }

}
