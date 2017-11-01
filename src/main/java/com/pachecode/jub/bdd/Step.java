package com.pachecode.jub.bdd;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */
@Value
@EqualsAndHashCode
public class Step {

   final private String text;
   final private StepType type;

   public Step(StepType type, String text) {
      this.type = type;
      this.text = text;
   }

   public boolean matches(String line) {
      return this.equals(Step.parse(line));
   }

   public enum StepType {
      Given, When, Then, And;
   };


   public String getLine() {
      return type.toString() +" " + getText();
   }
   public String getText() {
      return text;
   }
   public StepType getType() { return type; }


   static private String firstWord(String line) {
      return line.split(" ")[0].trim();
   }
   static private String afterFirstWord(String line) {
      return line.replace(firstWord(line), "").trim();
   }

   public static Step parse(String line) {
      return new StepParser().parse(line);
   }
}
