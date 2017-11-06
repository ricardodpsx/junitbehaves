package com.pachecode.jub.bdd.runner;

/**
 * Created by Ricardo on 3/29/2017.
 */
public class WrongStepException extends RuntimeException {
   public WrongStepException(String actual, String expected) {
      super(String.format("'%s' should be '%s'" , actual, expected));
   }
}
