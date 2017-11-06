package com.pachecode.jub.bdd;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.Arrays;

@Value
@EqualsAndHashCode
public class Step {

  final private String text;
  final private StepType type;
  final private String body;

  public Step(StepType type, String text) {
    this(type, text, "");
  }

  public Step(StepType type, String text, String body) {
    this.type = type;
    this.text = text;
    this.body = body;
  }

  public boolean matches(String line) {
    return this.equals(Step.create(line, ""));
  }

  public boolean matches(Step step) {
    return this.equals(step);
  }

  public String getBody() {
    return body;
  }


  public enum StepType {
    Given, When, Then, And
  }
  @Override
  public String toString() {
    return type.toString() + " " + getText();
  }

  public String getText() {
    return text;
  }

  public StepType getType() {
    return type;
  }


  public static Step create(String line, String body) {
    return new StepBuilder().create(line, body);
  }

  public static Step create(String line) {
    return new StepBuilder().create(line, "");
  }



  public static class StepBuilder {

    public Step create(String line, String body) {
      return new Step(getStepType(line), getStepText(line), body);
    }

    private StepType getStepType(String line) {
      try {
        return StepType.valueOf(upFirst(firstWord(line)));
      } catch (IllegalArgumentException e) {
        throw new InvalidStepException("Steps should start with " + Arrays.toString(StepType.values()));
      }
    }

    private String getStepText(String line) {
      return line.replace(firstWord(line), "").trim();
    }

    private String firstWord(String line) {
      return line.split(" ")[0].trim();
    }

    private String upFirst(String text) {
      return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
  }

}
