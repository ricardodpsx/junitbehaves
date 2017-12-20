package com.pachecode.jub.bdd;

import java.util.HashMap;

/**
 * Created by Ricardo on 12/10/2017.
 */
public class StepParams {
  public HashMap<String, String> byKey = new HashMap<>();

  public int getInt(String key) {
    return Integer.valueOf(byKey.get(key));
  }

  public Long getLong(String key) {
    return Long.valueOf(byKey.get(key));
  }

  public Double getDouble(String key) {
    return Double.valueOf(byKey.get(key));
  }
  public String get(String key) {
    return byKey.get(key);
  }
  public float getFloat(String key) {
    return Float.valueOf(byKey.get(key));
  }

  public void put(String key, String value) {
    byKey.put(key, value);
  }

}
