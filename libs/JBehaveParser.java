// Generated from JBehave.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, GIVEN=2, NEWLINE=3, TEXT=4;
	public static final int
		RULE_r = 0, RULE_scenario = 1, RULE_steps = 2;
	public static final String[] ruleNames = {
		"r", "scenario", "steps"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'Given'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "GIVEN", "NEWLINE", "TEXT"
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
		public ScenarioContext scenario() {
			return getRuleContext(ScenarioContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JBehaveParser.EOF, 0); }
		public List<StepsContext> steps() {
			return getRuleContexts(StepsContext.class);
		}
		public StepsContext steps(int i) {
			return getRuleContext(StepsContext.class,i);
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
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			scenario();
			setState(8); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7);
				steps();
				}
				}
				setState(10); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==GIVEN );
			setState(12);
			match(EOF);
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

	public static class ScenarioContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(JBehaveParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(JBehaveParser.NEWLINE, 0); }
		public ScenarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).enterScenario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JBehaveListener ) ((JBehaveListener)listener).exitScenario(this);
		}
	}

	public final ScenarioContext scenario() throws RecognitionException {
		ScenarioContext _localctx = new ScenarioContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scenario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(TEXT);
			setState(15);
			match(NEWLINE);
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
		public TerminalNode GIVEN() { return getToken(JBehaveParser.GIVEN, 0); }
		public TerminalNode WHITESPACE() { return getToken(JBehaveParser.WHITESPACE, 0); }
		public TerminalNode TEXT() { return getToken(JBehaveParser.TEXT, 0); }
		public TerminalNode NEWLINE() { return getToken(JBehaveParser.NEWLINE, 0); }
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
	}

	public final StepsContext steps() throws RecognitionException {
		StepsContext _localctx = new StepsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_steps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(GIVEN);
			setState(18);
			match(WHITESPACE);
			setState(19);
			match(TEXT);
			setState(20);
			match(NEWLINE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\31\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\2\2\5\2\4\6\2\2\26\2\b\3\2\2\2\4\20\3\2\2\2\6\23\3\2"+
		"\2\2\b\n\5\4\3\2\t\13\5\6\4\2\n\t\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f\r"+
		"\3\2\2\2\r\16\3\2\2\2\16\17\7\2\2\3\17\3\3\2\2\2\20\21\7\6\2\2\21\22\7"+
		"\5\2\2\22\5\3\2\2\2\23\24\7\4\2\2\24\25\7\3\2\2\25\26\7\6\2\2\26\27\7"+
		"\5\2\2\27\7\3\2\2\2\3\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}