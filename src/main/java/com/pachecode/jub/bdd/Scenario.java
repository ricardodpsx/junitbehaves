package com.pachecode.jub.bdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scenario {
   final List<Step> steps;
   final private String name;


  public Scenario(String name, List<Step> steps) {
    this.name = name;
    this.steps = steps;
  }


   public String getName() {
      return name;
   }

   public List<Step> getSteps() {
      return new ArrayList<>(steps);
   }

  public static Scenario create(String scenarioLine, List<Step> steps) {
    return new Scenario(scenarioLine.replaceAll("(?i)Scenario:", "").trim(), steps);
  }

}
