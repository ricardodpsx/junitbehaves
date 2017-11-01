package com.pachecode.jub.bdd;

import com.pachecode.jub.bdd.runner.SimpleScenarioRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 4/3/2017.
 */
public class Story {
   private String name;
   List<SimpleScenarioRunner> scenarios = new ArrayList<>();

   public Story(String name, String text) {
      this.name = name;
      String[] lines = text.split("\n");
   }

   public String getName() {
      return name;
   }
}
