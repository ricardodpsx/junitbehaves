package com.pachecode.jub.annotation;

import com.pachecode.jub.jbehave.parser.Parser;
import com.pachecode.jub.jbehave.parser.StoryRule;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import static com.pachecode.jub.Utils.readResourceContents;

/**
 * Created by Ricardo on 4/3/2017.
 */
public class StoryAnnotationHandler extends ScenarioAnnotationHandler {
  static StoryAnnotationHandler instance = new StoryAnnotationHandler();

  static public StoryAnnotationHandler getInstance() {
    return instance;
  }

  public com.pachecode.jub.bdd.Story getStory(String testClassName) {

    try {
      for (Annotation annotation: Class.forName(testClassName).getAnnotations()) {
        if (annotation instanceof Story)
          return createStory((Story) annotation);
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException("Problems instantiating story", e);
    }

  }


  private com.pachecode.jub.bdd.Story createStory(Story storyAnnotation) {

    String storyName = storyAnnotation.value();

    if(!storyAnnotation.resource().isEmpty()) {
      if(storyName.isEmpty())
        storyName = storyAnnotation.resource().replace(".story", "");

      String contents = readResourceContents(storyAnnotation.resource());
      return new StoryRule(storyName, new Parser(contents)).match();
    }

    return new com.pachecode.jub.bdd.Story(storyName, new ArrayList<>());

  }

}
