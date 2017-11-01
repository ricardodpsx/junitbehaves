// Generated from src/main/java/com/pachecode/jub/jbehave/parser/JBehave.g4 by ANTLR 4.5.3
package com.pachecode.jub.jbehave.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JBehaveLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, GIVEN=2, WHEN=3, THEN=4, AND=5, TXT=6, EOL=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "GIVEN", "WHEN", "THEN", "AND", "TXT", "EOL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Scenario:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "GIVEN", "WHEN", "THEN", "AND", "TXT", "EOL", "WS"
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


	public JBehaveLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JBehave.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nQ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\'\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5;\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7E\n\7\r\7\16\7F\3\b"+
		"\3\b\3\t\6\tL\n\t\r\t\16\tM\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\3\2\5\5\2\"\"C\\c|\4\2\f\f\17\17\4\2\13\f\17\17U\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\3\23\3\2\2\2\5\35\3\2\2\2\7(\3\2\2\2\t\62\3\2\2\2\13<"+
		"\3\2\2\2\rD\3\2\2\2\17H\3\2\2\2\21K\3\2\2\2\23\24\7U\2\2\24\25\7e\2\2"+
		"\25\26\7g\2\2\26\27\7p\2\2\27\30\7c\2\2\30\31\7t\2\2\31\32\7k\2\2\32\33"+
		"\7q\2\2\33\34\7<\2\2\34\4\3\2\2\2\35\36\7I\2\2\36\37\7k\2\2\37 \7x\2\2"+
		" !\7g\2\2!\"\7p\2\2\"#\7\"\2\2#$\3\2\2\2$&\5\r\7\2%\'\5\13\6\2&%\3\2\2"+
		"\2&\'\3\2\2\2\'\6\3\2\2\2()\7Y\2\2)*\7j\2\2*+\7g\2\2+,\7p\2\2,-\7\"\2"+
		"\2-.\3\2\2\2.\60\5\r\7\2/\61\5\13\6\2\60/\3\2\2\2\60\61\3\2\2\2\61\b\3"+
		"\2\2\2\62\63\7V\2\2\63\64\7j\2\2\64\65\7g\2\2\65\66\7p\2\2\66\67\7\"\2"+
		"\2\678\3\2\2\28:\5\r\7\29;\5\13\6\2:9\3\2\2\2:;\3\2\2\2;\n\3\2\2\2<=\7"+
		"C\2\2=>\7p\2\2>?\7f\2\2?@\7\"\2\2@A\3\2\2\2AB\5\r\7\2B\f\3\2\2\2CE\t\2"+
		"\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\16\3\2\2\2HI\t\3\2\2I\20"+
		"\3\2\2\2JL\t\4\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2O"+
		"P\b\t\2\2P\22\3\2\2\2\b\2&\60:FM\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}