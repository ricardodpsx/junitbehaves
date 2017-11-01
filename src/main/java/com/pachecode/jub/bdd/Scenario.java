package com.pachecode.jub.bdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 10/30/2017.
 */
public class Scenario {
   final List<Step> steps;
   final private String name;

   public Scenario(String name) {
      this(name, new ArrayList<Step>());
   }
   public Scenario(String name, List<Step> steps) {
      this.name = name;
      this.steps = steps;
   }

   public String getName() {
      return name;
   }

   public List<Step> getSteps() {
      return steps;
   }

   public void addStep(Step step) {
      steps.add(step);
   }

   public Step getLastStep() {
      return steps.get(steps.size() - 1);
   }
}
