package com.pachecode.jub.jbehave.parser;

import com.pachecode.jub.antlr.HelloLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 9/14/2017.
 */
public class JBehaveParserTest {

   @Test
   public void mainTest() throws IOException {
      JBehaveLexer lexer = new JBehaveLexer(new ANTLRInputStream( getClass().getResourceAsStream("/sum_scenario.story") )  );

      TokenStream tokenStream = new CommonTokenStream(lexer);

      JBehaveParser parser = new JBehaveParser(tokenStream);

      ParseTree tree = parser.r();

      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(new Listener(), tree);
   }

   class Listener extends JBehaveBaseListener {
      @Override
      public void enterScenario(JBehaveParser.ScenarioContext ctx) {
         System.out.println(ctx.getText());
      }

      @Override
      public void enterSteps(JBehaveParser.StepsContext ctx) {
         super.enterSteps(ctx);
      }
   }
}
