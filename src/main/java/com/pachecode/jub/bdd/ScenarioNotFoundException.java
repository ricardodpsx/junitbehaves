package com.pachecode.jub.bdd;

/**
 * Created by Ricardo on 11/5/2017.
 */
public class ScenarioNotFoundException extends RuntimeException {
  public ScenarioNotFoundException(String str) {
    super(str);
  }
}
