package com.pachecode.jub.bdd;

import com.pachecode.jub.bdd.runner.ScenarioRunner;

/**
 * Created by Ricardo on 11/12/2017.
 */
public class ScenarioException extends AssertionError {
  public ScenarioException(String message, Throwable e) {
    super(message, e);
  }
  public ScenarioException(String message, ScenarioRunner runner) {
    super(message + "\n\n" + runner.toString());
  }
}
