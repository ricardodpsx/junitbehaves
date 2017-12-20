package com.pachecode.jub.junit4;

/**
 * Created by Ricardo on 3/22/2017.
 */
import static org.junit.Assert.fail;

import com.pachecode.jub.bdd.ScenarioException;
import com.pachecode.jub.bdd.runner.ScenarioRunner;
import com.pachecode.jub.annotation.ScenarioAnnotationHandler;
import com.pachecode.jub.report.HtmlReport;
import com.pachecode.jub.report.Report;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

//For JBEhave Examples: https://stackoverflow.com/questions/1492856/easy-way-of-running-the-same-junit-test-over-and-over
public class JUnitBehavesRule implements TestRule {
  static Report report = new HtmlReport();

  public static void setReport(Report report) {
    JUnitBehavesRule.report = report;
  }

  public Statement apply(final Statement base, final Description description) {
    return new StatementWrapper(base, description);
  }

  class StatementWrapper extends Statement {

    private final Statement base;
    private final Description description;

    public StatementWrapper(Statement base, Description description) {
      this.base = base;
      this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
      ScenarioRunner runner = ScenarioAnnotationHandler.instance.init(description.getClassName(), description.getMethodName());

      try {

        base.evaluate();

        runner.doFinishSuccessfully();

      } catch (ScenarioException e) {
        throw e;
      } catch (Throwable e) {
        runner.doFailed();
        throw e;
      } finally {
        report.report(runner);
      }
    }
  }


}

