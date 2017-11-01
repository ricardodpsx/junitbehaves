package com.pachecode.jub.antlr;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by ricardo.pachecosalazar@wnco.com on 4/3/2017.
 */
public class AntlrLearningTest {

   @Test
   public void testAntlr() throws IOException {

      HelloLexer helloLexer = new HelloLexer(new ANTLRInputStream("hello  ricardo"));

      TokenStream tokens = new CommonTokenStream(helloLexer);

      HelloParser parser = new HelloParser(tokens);

      ParseTree tree = parser.r();

      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk( new HelloWalker(), tree );

   }

   class HelloWalker extends HelloBaseListener {
      @Override
      public void enterR(HelloParser.RContext ctx ) {
         System.out.println( "Entering R : " + ctx.ID().getText() );
      }

      @Override
      public void exitR(HelloParser.RContext ctx ) {
         System.out.println( "Exiting R" );
      }
   }


}
