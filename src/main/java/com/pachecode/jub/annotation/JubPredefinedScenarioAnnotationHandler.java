package com.pachecode.jub.annotation;

import com.pachecode.jub.bdd.Story;

import java.lang.annotation.Annotation;

import static com.pachecode.jub.Utils.readResourceContents;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 4/3/2017.
 */
public class JubPredefinedScenarioAnnotationHandler extends JubScenarioAnnotationHandler {
   static JubPredefinedScenarioAnnotationHandler instance;

   static public JubPredefinedScenarioAnnotationHandler getInstance() {
      if(instance == null)
         instance = new JubPredefinedScenarioAnnotationHandler();

      return instance;
   }

   public com.pachecode.jub.bdd.Story getClassStory() {
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      try {
         for(StackTraceElement st: stackTrace) {
            Class clazz = Class.forName(st.getClassName());
            if (hasAnnotation(clazz, com.pachecode.jub.annotation.Story.class))
               return createJubStory(clazz);
         }
         throw new RuntimeException("No Story Annotation found in caller classes");
      } catch (Exception e) {
         throw new RuntimeException("Problems instantiating story", e);
      }

   }

   private com.pachecode.jub.bdd.Story createJubStory(Class clazz) {
      String fileName = getStoryFileFromAnnotation(clazz);

      return new Story(fileName.replace(".story", ""), readResourceContents(fileName));
   }

   private String getStoryFileFromAnnotation(Class clazz) {
      for(Annotation a: clazz.getAnnotations())
         if(a instanceof com.pachecode.jub.annotation.Story)
            return ((com.pachecode.jub.annotation.Story) a).value();

      throw new RuntimeException(clazz.getName() + " must have a @Story annotation");
   }
}
