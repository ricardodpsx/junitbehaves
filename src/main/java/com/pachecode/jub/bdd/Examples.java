package com.pachecode.jub.bdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ricardo on 12/10/2017.
 */
public class Examples {

  Map<String, List<String>> table = new HashMap<>();

  public Examples() {
  }

  public Examples(HashMap<String, List<String>> table) {
    this.table = table;
  }

  public int countColumns() {
     return table.size();
  }

  public int countRows() {
    String key = table.keySet().iterator().next();
    return table.get(key).size();
  }


  public String get(String column, int row) {
    return table.get(column).get(row);
  }
}
