package com.pachecode.jub.bdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Story {
   private String name;
   List<Scenario> scenarios = new ArrayList<>();
   HashMap<String, Scenario> scenariosByName = new HashMap<>();

   public Story(String name, List<Scenario> scenarios) {
      this.name = name;
      this.scenarios = scenarios;
      for(Scenario scenario: scenarios)
         scenariosByName.put(scenario.getName(), scenario);
   }

   public String getName() {
      return name;
   }

   public List<Scenario> getScenarios() {
      return scenarios;
   }

   public Scenario getScenario(String scenarioName) {
      if(!scenariosByName.containsKey(scenarioName))
         throw new ScenarioNotFoundException(String.format(
             "Scenario '%s' doesn't exist in the story '%s'", scenarioName, name));

      return scenariosByName.get(scenarioName);
   }


}
