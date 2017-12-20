package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.runner.ScenarioRunner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Ricardo on 3/22/2017.
 */
@Story("A simple scenario")
public class ScenarioAnnotationHandlerTest {

   public static final String TEST_CLASS_NAME = "com.pachecode.jub.annotation.ScenarioAnnotationHandlerTest";
  ScenarioAnnotationHandler scenarioUtils;

  @Before
  public void setup() {
    scenarioUtils = ScenarioAnnotationHandler.instance = new ScenarioAnnotationHandler();

  }


   @Scenario("Sum scenario")
   @Test
   public void testGetScenarioInstanceFromAnnotation() {
      scenarioUtils.init(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation");

      assertEquals("Sum scenario", scenarioUtils.getActiveRunner().getName());
   }

   @Test
   public void testGetScenarioOfGivenTest() {
      ScenarioRunner scenario = scenarioUtils.init(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation");
      assertEquals("Sum scenario", scenario.getName());
      assertEquals(scenario, scenarioUtils.init(TEST_CLASS_NAME, "testGetScenarioInstanceFromAnnotation"));
   }

   @Test
   @Scenario("Sum scenario")
   public void testStaticGivenWhenThen() {
      //Registers the runner from this testMethod @Scenario annotation
      ScenarioRunner runner = scenarioUtils.init(TEST_CLASS_NAME, "testStaticGivenWhenThen");

      //Checks if we can get the same runner
      assertEquals(runner, scenarioUtils.getActiveRunner());

      //This shouldn't throw exceptions
      JubUtils.Given("one");
      JubUtils.When("two");
      JubUtils.Then("three");
   }

}
