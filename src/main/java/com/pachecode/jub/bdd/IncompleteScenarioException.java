package com.pachecode.jub.bdd;

import com.pachecode.jub.bdd.runner.ScenarioRunner;

/**
 * Created by Ricardo on 11/12/2017.
 */
public class IncompleteScenarioException extends ScenarioException {

  public IncompleteScenarioException(String message, ScenarioRunner runner) {
    super(message, runner);
  }
}
