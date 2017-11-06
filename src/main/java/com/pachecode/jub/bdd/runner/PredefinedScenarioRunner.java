package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.Scenario;
import com.pachecode.jub.bdd.Step;
import com.pachecode.jub.bdd.StepResult;

import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import static com.pachecode.jub.bdd.Step.StepType.*;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/27/2017.
 * <p>
 * An simpleRunner that fails if doesn't follow the predefined Jbehave
 */
public class PredefinedScenarioRunner implements ScenarioRunner {

  SimpleScenarioRunner simpleRunner;
  Deque<Step> stepsToRun = new ArrayDeque<>();
  private AtomicReferenceFieldUpdater<Integer, Object> results;

  public PredefinedScenarioRunner(Scenario referenceScenario) {
    stepsToRun.addAll(referenceScenario.getSteps());
    simpleRunner = new SimpleScenarioRunner(referenceScenario.getName());
  }


  void runStep(Step step) {

    if (stepsToRun.isEmpty())
      throw new WrongStepException(step.toString(), "None!");

    if (!stepsToRun.getFirst().matches(step))
      throw new WrongStepException(step.toString(), stepsToRun.getFirst().toString());

    stepsToRun.poll();

    simpleRunner.runStep(step);
  }

  public void doFinish() {
    simpleRunner.doFinish();
  }

  @Override
  public void doFinishSuccessfully() {
    simpleRunner.doFinishSuccessfully();
  }

  @Override
  public void given(String stepLine) {
    runStep(new Step(Given, stepLine));
  }

  @Override
  public void when(String stepLine) {
    runStep(new Step(When, stepLine));
  }

  @Override
  public void then(String stepLine) {
    runStep(new Step(Then, stepLine));
  }

  @Override
  public void and(String stepLine) {
    runStep(new Step(And, stepLine));
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
}
