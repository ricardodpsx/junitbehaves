package com.pachecode.jub.report;

import com.pachecode.jub.bdd.StepResult;
import com.pachecode.jub.bdd.runner.ScenarioRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ricardo on 11/12/2017.
 */
public class HtmlReport implements Report {

  File temp;
  FileWriter writer;

  public HtmlReport() {
    try {

      File f = new File(System.getProperty("java.io.tmpdir"));

      temp = new File( System.getProperty("java.io.tmpdir"), "junitBehaves-results.html");
      writer = new FileWriter(temp);

      writer.write("<style type='text/css'>" +
          "body {font-family: tahoma} " +
          "step { margin-left: 15px } " +
          ".Failed { color: red  }" +
          ".Pending { color: #f4d442  }" +
          ".Succeeded{ color:#4a8700 }" +
          "</style>");

      writer.write("<script>" +
          "setTimeout(function(){ location.reload() }, 1000);" +
          "</script>");

      writer.flush();

      System.err.println("JunitBehaves results at:\n file://" + temp.getAbsolutePath().replace("\\", "/"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void report(ScenarioRunner runner) {
    synchronized (temp) {

      try {
        writer.write("<p>");
        writer.write(String.format("<div><strong>Scenario:</strong> %s</div>", runner.getName()));

        for(StepResult result: runner.getResults())
          writer.write(String.format("<div class='step %s'><em>%s</em> %s</div>",
              result.getStatus(),
              result.getStep().getType(),
              result.getStep().getText(),
              result.getStatus()
              ));

        writer.write("</p>");
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

  }
}
