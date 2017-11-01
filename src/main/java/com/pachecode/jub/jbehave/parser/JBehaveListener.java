// Generated from src/main/java/com/pachecode/jub/jbehave/parser/JBehave.g4 by ANTLR 4.5.3
package com.pachecode.jub.jbehave.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JBehaveParser}.
 */
public interface JBehaveListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(JBehaveParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(JBehaveParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#scenario}.
	 * @param ctx the parse tree
	 */
	void enterScenario(JBehaveParser.ScenarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#scenario}.
	 * @param ctx the parse tree
	 */
	void exitScenario(JBehaveParser.ScenarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#steps}.
	 * @param ctx the parse tree
	 */
	void enterSteps(JBehaveParser.StepsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#steps}.
	 * @param ctx the parse tree
	 */
	void exitSteps(JBehaveParser.StepsContext ctx);
}