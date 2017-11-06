package com.pachecode.jub.annotation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ricardo on 4/3/2017.
 */
@Story(value = "User story name", resource = "test_2_scenarios.story")
public class StoryRunnerAnnotationHandlerTest extends ScenarioAnnotationHandler {

  private StoryAnnotationHandler handler = StoryAnnotationHandler.getInstance();

  @Test
  public void testGetsStoryFromAnnotation() {
    com.pachecode.jub.bdd.Story story =  handler.getStory("com.pachecode.jub.annotation.StoryRunnerAnnotationHandlerTest");
    assertEquals("User story name", story.getName());

    assertThat(story.getScenarios().size(), is(2));
  }

}
