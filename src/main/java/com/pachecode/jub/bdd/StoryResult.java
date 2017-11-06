package com.pachecode.jub.bdd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * Created by Ricardo on 11/5/2017.
 */

@Value
@Getter
public class StoryResult {
  final boolean succeeded ;

  public StoryResult(boolean succeeded) {
    this.succeeded = succeeded;
  }

  public boolean didSucceed() {
    return true;
  }
}
