package com.pachecode.jub.bdd;

import com.pachecode.jub.bdd.runner.ScenarioRunner;

/**
 * Created by Ricardo on 11/5/2017.
 */
public class ScenarioReportPrinter {

  public void print(ScenarioRunner runner) {
    System.out.println("Scenario: " + runner.getName());
    for(StepResult result : runner.getResults())
      System.out.printf("  Step %s [%s] %n",result.getStep(), result.getStatus());
  }
}
