// Generated from C:/Users/x217094/MOSAIC/JBehaveUnit/src/main/java/com/pachecode/jub/jbehave/parser\JBehave.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, TXT=7, EOL=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "TXT", "EOL"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n?\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\6\b9\n"+
		"\b\r\b\16\b:\3\t\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2"+
		"\3\5\2\"\"C\\c|?\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\35\3\2\2"+
		"\2\7\37\3\2\2\2\t&\3\2\2\2\13,\3\2\2\2\r\62\3\2\2\2\178\3\2\2\2\21<\3"+
		"\2\2\2\23\24\7U\2\2\24\25\7e\2\2\25\26\7g\2\2\26\27\7p\2\2\27\30\7c\2"+
		"\2\30\31\7t\2\2\31\32\7k\2\2\32\33\7q\2\2\33\34\7<\2\2\34\4\3\2\2\2\35"+
		"\36\7\f\2\2\36\6\3\2\2\2\37 \7I\2\2 !\7k\2\2!\"\7x\2\2\"#\7g\2\2#$\7p"+
		"\2\2$%\7\"\2\2%\b\3\2\2\2&\'\7Y\2\2\'(\7j\2\2()\7g\2\2)*\7p\2\2*+\7\""+
		"\2\2+\n\3\2\2\2,-\7V\2\2-.\7j\2\2./\7g\2\2/\60\7p\2\2\60\61\7\"\2\2\61"+
		"\f\3\2\2\2\62\63\7C\2\2\63\64\7p\2\2\64\65\7f\2\2\65\66\7\"\2\2\66\16"+
		"\3\2\2\2\679\t\2\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\20\3\2"+
		"\2\2<=\7\17\2\2=>\7\f\2\2>\22\3\2\2\2\4\2:\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}