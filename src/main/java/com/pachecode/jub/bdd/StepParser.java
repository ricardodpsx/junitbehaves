package com.pachecode.jub.bdd;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/22/2017.
 */

public class StepParser {
   private String firstWord(String line) {
      return line.split(" ")[0].trim();
   }
   private String afterFirstWord(String line) {
      return line.replace(firstWord(line), "").trim();
   }

   public Step parse(String line) {
      return new Step(Step.StepType.valueOf(firstWord(line)),
              afterFirstWord(line));
   }
}
