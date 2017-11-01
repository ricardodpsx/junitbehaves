package com.pachecode.jub.bdd.runner;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 3/29/2017.
 */
public class JubWrongStepException extends RuntimeException {
   public JubWrongStepException(String actual, String expected) {
      super(actual +" should be " + expected);
   }
}
