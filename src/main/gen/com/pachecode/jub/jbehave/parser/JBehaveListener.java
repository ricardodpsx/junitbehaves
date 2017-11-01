// Generated from C:/Users/x217094/MOSAIC/JBehaveUnit/src/main/java/com/pachecode/jub/jbehave/parser\JBehave.g4 by ANTLR 4.6
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
	 * Enter a parse tree produced by {@link JBehaveParser#referenceScenario}.
	 * @param ctx the parse tree
	 */
	void enterReferenceScenario(JBehaveParser.ReferenceScenarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#referenceScenario}.
	 * @param ctx the parse tree
	 */
	void exitReferenceScenario(JBehaveParser.ReferenceScenarioContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#given}.
	 * @param ctx the parse tree
	 */
	void enterGiven(JBehaveParser.GivenContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#given}.
	 * @param ctx the parse tree
	 */
	void exitGiven(JBehaveParser.GivenContext ctx);
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#when}.
	 * @param ctx the parse tree
	 */
	void enterWhen(JBehaveParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#when}.
	 * @param ctx the parse tree
	 */
	void exitWhen(JBehaveParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#then}.
	 * @param ctx the parse tree
	 */
	void enterThen(JBehaveParser.ThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#then}.
	 * @param ctx the parse tree
	 */
	void exitThen(JBehaveParser.ThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link JBehaveParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(JBehaveParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link JBehaveParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(JBehaveParser.AndContext ctx);
}