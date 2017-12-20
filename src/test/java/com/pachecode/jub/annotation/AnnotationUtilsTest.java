package com.pachecode.jub.annotation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ricardo on 11/12/2017.
 */
public class AnnotationUtilsTest {


  @Test
  @Scenario("a test scenario")
  public void testGettingAMethodFromTheCaller() {
    assertEquals("testGettingAMethodFromTheCaller", aMethodCall());
  }

  private String aMethodCall() {
    return AnnotationUtils.getCallerMethodWithAnnotation(Scenario.class).getName();
  }
}
