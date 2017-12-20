package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.*;
import lombok.Getter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/27/2017.
 * <p>
 * An simpleRunner that fails if doesn't follow the predefined Jbehave
 */
public class PredefinedScenarioRunner extends ScenarioRunner {

  SimpleScenarioRunner simpleRunner;
  Deque<Step> stepsToRun = new ArrayDeque<>();

  StepParams params = new StepParams();

  public PredefinedScenarioRunner(Scenario predefinedScenario) {
    stepsToRun.addAll(predefinedScenario.getSteps());
    simpleRunner = new SimpleScenarioRunner(predefinedScenario.getName());
  }



  @Override
  public void runStep(Step runningStep) {

    if (stepsToRun.isEmpty())
      throw new WrongStepException(runningStep.toString(), "None!", this);

    Step predefinedStep = stepsToRun.getFirst();

    if (!matches(predefinedStep, runningStep))
      throw new WrongStepException(runningStep.toString(), predefinedStep.toString(), this);

    updateParams(predefinedStep, runningStep);

    stepsToRun.poll();

    simpleRunner.runStep(runningStep);
  }


  boolean matches(Step predefinedStep, Step runningStep) {
    String text = predefinedStep.getText().replaceAll("\\{.*?\\}", "");
    String evaluate = runningStep.getText().replaceAll("\\{.*?\\}","");

    return text.equals(evaluate);
  }

  void updateParams(Step predefinedStep, Step runningStep) {

    Pattern pattern = Pattern.compile("\\{(.*?)\\}");
    Matcher values = pattern.matcher(predefinedStep.getText());
    Matcher keys = pattern.matcher(runningStep.getText());

    while(keys.find() && values.find())
      params.put(keys.group(1), values.group(1));

  }


  @Override
  public void doFinishSuccessfully() {
    simpleRunner.doFinishSuccessfully();

    if(!succeeded())
      throw new ScenarioException("Pending scenarios", this);

  }


  @Override
  public String getName() {
    return simpleRunner.getName();
  }

  @Override
  public boolean succeeded() {
    return simpleRunner.succeeded() && stepsToRun.isEmpty();
  }


  @Override
  public List<StepResult> getResults() {
    List<StepResult> results = simpleRunner.getResults();
    Deque<Step> remainingSteps = new ArrayDeque<>(stepsToRun);

    while (!remainingSteps.isEmpty())
      results.add(new StepResult(remainingSteps.poll(), StepResult.Status.Pending));

    return results;
  }

  public StepParams getParams() {
    return params;
  }

  @Override
  public void doFailed() {
    simpleRunner.doFailed();
  }
}
