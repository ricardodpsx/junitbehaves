// Generated from C:/Users/x217094/MOSAIC/JBehaveUnit/src/main/java/com/pachecode/jub/jbehave/parser\JBehave.g4 by ANTLR 4.6
package com.pachecode.jub.jbehave.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JBehaveParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JBehaveVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(JBehaveParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#referenceScenario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceScenario(JBehaveParser.ReferenceScenarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#steps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSteps(JBehaveParser.StepsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#given}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGiven(JBehaveParser.GivenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(JBehaveParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#then}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen(JBehaveParser.ThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JBehaveParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(JBehaveParser.AndContext ctx);
}