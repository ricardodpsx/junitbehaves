// Generated from C:/Users/x217094/MOSAIC/JBehaveUnit/src/main/java/com/pachecode/jub/jbehave/parser\JBehave.g4 by ANTLR 4.6
package com.pachecode.jub.jbehave.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JBehaveParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, TXT=7, EOL=8;
	public static final int
		RULE_r = 0, RULE_referenceScenario = 1, RULE_steps = 2, RULE_given = 3, 
		RULE_when = 4, RULE_then = 5, RULE_and = 6;
	public static final String[] ruleNames = {
		"r", "referenceScenario", "steps", "given", "when", "then", "and"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Scenario:'", "'\n'", "'Given '", "'When '", "'Then '", "'And '", 
		null, "'\r\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "TXT", "EOL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JBehave.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JBehaveParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public ReferenceScenarioContext referenceScenario() {
			return getRuleContext(ReferenceScenarioContext.class,0);
		}
		public TerminalNode EOL() { return getToken(JBehaveParser.EOL, 0); }
		public StepsContext steps() {
			return getRuleContext(StepsContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			referenceScenario();
			setState(15);
			match(EOL);
			setState(16);
			steps();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceScenarioContext extends ParserRuleContext {
		public TerminalNode TXT() { return getToken(JBehaveParser.TXT, 0); }
		public ReferenceScenarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceScenario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterReferenceScenario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitReferenceScenario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitReferenceScenario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceScenarioContext referenceScenario() throws RecognitionException {
		ReferenceScenarioContext _localctx = new ReferenceScenarioContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_referenceScenario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__0);
			setState(19);
			match(TXT);
			setState(20);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepsContext extends ParserRuleContext {
		public GivenContext given() {
			return getRuleContext(GivenContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(JBehaveParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(JBehaveParser.EOL, i);
		}
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public StepsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_steps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterSteps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitSteps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitSteps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepsContext steps() throws RecognitionException {
		StepsContext _localctx = new StepsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			given();
			setState(23);
			match(EOL);
			setState(24);
			when();
			setState(25);
			match(EOL);
			setState(26);
			then();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GivenContext extends ParserRuleContext {
		public TerminalNode TXT() { return getToken(JBehaveParser.TXT, 0); }
		public GivenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_given; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterGiven(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitGiven(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitGiven(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GivenContext given() throws RecognitionException {
		GivenContext _localctx = new GivenContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_given);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__2);
			setState(29);
			match(TXT);
			setState(30);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenContext extends ParserRuleContext {
		public TerminalNode TXT() { return getToken(JBehaveParser.TXT, 0); }
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__3);
			setState(33);
			match(TXT);
			setState(34);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenContext extends ParserRuleContext {
		public TerminalNode TXT() { return getToken(JBehaveParser.TXT, 0); }
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__4);
			setState(37);
			match(TXT);
			setState(38);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public TerminalNode TXT() { return getToken(JBehaveParser.TXT, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JBehaveVisitor ) return ((JBehaveVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__5);
			setState(41);
			match(TXT);
			setState(42);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\'\2\20\3\2\2\2\4\24"+
		"\3\2\2\2\6\30\3\2\2\2\b\36\3\2\2\2\n\"\3\2\2\2\f&\3\2\2\2\16*\3\2\2\2"+
		"\20\21\5\4\3\2\21\22\7\n\2\2\22\23\5\6\4\2\23\3\3\2\2\2\24\25\7\3\2\2"+
		"\25\26\7\t\2\2\26\27\7\4\2\2\27\5\3\2\2\2\30\31\5\b\5\2\31\32\7\n\2\2"+
		"\32\33\5\n\6\2\33\34\7\n\2\2\34\35\5\f\7\2\35\7\3\2\2\2\36\37\7\5\2\2"+
		"\37 \7\t\2\2 !\7\4\2\2!\t\3\2\2\2\"#\7\6\2\2#$\7\t\2\2$%\7\4\2\2%\13\3"+
		"\2\2\2&\'\7\7\2\2\'(\7\t\2\2()\7\4\2\2)\r\3\2\2\2*+\7\b\2\2+,\7\t\2\2"+
		",-\7\4\2\2-\17\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}