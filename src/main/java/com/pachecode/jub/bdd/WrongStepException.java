package com.pachecode.jub.bdd;

import com.pachecode.jub.bdd.runner.ScenarioRunner;
import junit.framework.ComparisonFailure;

/**
 * Created by Ricardo on 3/29/2017.
 */
public class WrongStepException extends ScenarioException {
   String expected, actual;
   public WrongStepException(String actual, String expected, ScenarioRunner runner) {
      super(String.format("expected:<%s> but was:<%s>" , expected, actual), new ComparisonFailure("", expected, actual));
      this.expected = expected;
      this.actual = actual;
   }
   public String toString() {
      return String.format("expected:<%s> but was:<%s>" , expected, actual);
   }
}
