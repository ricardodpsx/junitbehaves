package com.pachecode.jub.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * Created by Ricardo on 11/12/2017.
 */
public class AnnotationUtils {

  public static <T> T getAnnotation(Class<T> annotationClass, String className) {

    try {
      AnnotatedElement annotatedElement = Class.forName(className);
      return getAnnotation(annotationClass, annotatedElement);
    } catch (Exception e) {
      throw new RuntimeException("Problems instantiating story", e);
    }
  }

  public static <T> T getAnnotation(Class<T> annotationClass, String className, String methodName) {

    try {
      return getAnnotation(annotationClass, getMethodObject(className, methodName));
    } catch (Exception e) {
      throw new RuntimeException("Problems instantiating story", e);
    }
  }

  public static <T> Method getCallerMethodWithAnnotation(Class<T> annotationClass) {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

    for (StackTraceElement st : stackTrace) {
      Method method = AnnotationUtils.getMethodObject(st.getClassName(), st.getMethodName());

      if (AnnotationUtils.hasAnnotation(method, annotationClass))
        return method;
    }
    throw new RuntimeException("No Method with annotation " + annotationClass.getSimpleName() + " found in the stack");
  }

  public static boolean hasAnnotation(AnnotatedElement obj, Class tClass) {
    for (Annotation a : obj.getAnnotations())
      if (tClass.isInstance(a))
        return true;
    return false;
  }


  private static <T> T getAnnotation(Class<T> annotationClass, AnnotatedElement annotatedElement) {
    for (Annotation annotation: annotatedElement.getAnnotations())
      if (annotationClass.isInstance(annotation))
        return (T) annotation;

    throw new RuntimeException("Annotation " + annotationClass.getSimpleName() + " annotation not found in " + annotatedElement.toString());
  }

  private static Method getMethodObject(String className, String methodName) {
    try {
      for (Method m : Class.forName(className).getDeclaredMethods())
        if (m.getName().equals(methodName))
          return m;

      throw new RuntimeException("Method " + methodName + " don't exist in class " + className);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
