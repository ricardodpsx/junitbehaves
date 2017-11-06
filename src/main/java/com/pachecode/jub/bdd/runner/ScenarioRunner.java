package com.pachecode.jub.bdd.runner;

import com.pachecode.jub.bdd.StepResult;

import java.util.List;

/**
 * Created by Ricardo on 11/5/2017.
 */
public interface ScenarioRunner {
   void given(String stepLine);

   void  when(String stepLine);

   void then(String stepLine);

   void and(String stepLine);

   String getName();

   boolean succeeded();

   void doFinish();

   void doFinishSuccessfully();

   List<StepResult> getResults();
}
