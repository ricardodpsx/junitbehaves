package com.pachecode.jub.annotation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 4/3/2017.
 */
@Story("sum_scenario.story")
public class JubPredefinedScenarioRunnerAnnotationHandlerTest extends JubScenarioAnnotationHandler{

      private JubPredefinedScenarioAnnotationHandler handler =  JubPredefinedScenarioAnnotationHandler.getInstance();

      @Test
      public void testGetsStoryFromAnnotation() {
            assertEquals("sum_scenario",handler.getClassStory().getName());
      }
}
