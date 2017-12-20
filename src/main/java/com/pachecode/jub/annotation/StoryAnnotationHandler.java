package com.pachecode.jub.annotation;

import com.google.common.base.Strings;
import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.jbehave.parser.StoryParser;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static com.pachecode.jub.Utils.readResourceContents;


/**
 * Created by Ricardo on 4/3/2017.
 */
public class StoryAnnotationHandler extends ScenarioAnnotationHandler {
  static StoryAnnotationHandler instance = new StoryAnnotationHandler();

  ConcurrentHashMap<String, com.pachecode.jub.bdd.Story> stories = new ConcurrentHashMap<>();

  static public StoryAnnotationHandler getInstance() {
    return instance;
  }

  public com.pachecode.jub.bdd.Story getStory(String testClassName) {
    return stories.computeIfAbsent(testClassName,
        (k) -> createStory(AnnotationUtils.getAnnotation(Story.class, testClassName))
    );
  }

  private com.pachecode.jub.bdd.Story createStory(Story story) {
    checkValueOrResourceAreDefined(story);

    if(!Strings.isNullOrEmpty(story.resource()))
      return new StoryParser(getStoryName(story), readResourceContents(story.resource())).parse();
    else
      return new com.pachecode.jub.bdd.Story(getStoryName(story), new ArrayList<>());
  }

  private void checkValueOrResourceAreDefined(Story story) {
    if(Strings.isNullOrEmpty(story.value()) && Strings.isNullOrEmpty(story.resource()))
      throw new RuntimeException("value or resource should be defined for the annotation @Story");
  }

  private String getStoryName(Story story) {
    if(story.value().isEmpty())
        return story.resource().replace(".story", "");
    else
      return story.value();
  }

}
