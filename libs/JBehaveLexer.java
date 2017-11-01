// Generated from JBehave.g4 by ANTLR 4.5.3
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
		WHITESPACE=1, GIVEN=2, NEWLINE=3, TEXT=4;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"G", "I", "V", "E", "N", "LOWERCASE", "UPPERCASE", "NUMBER", "SYMBOLS", 
		"WHITESPACE", "GIVEN", "NEWLINE", "TEXT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\6I\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\5\r9\n\r\3\r\3\r\6\r=\n\r\r\r\16\r>\3\16\3\16\3\16\3\16\3\16\6\16F\n"+
		"\16\r\16\16\16G\2\2\17\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\3\27"+
		"\4\31\5\33\6\3\2\f\4\2IIii\4\2KKkk\4\2XXxx\4\2GGgg\4\2PPpp\3\2c|\3\2C"+
		"\\\3\2\62;\7\2$$))..\60\60<=\4\2\13\13\"\"G\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t#\3\2"+
		"\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3\2\2\2\21+\3\2\2\2\23-\3\2\2\2\25/\3"+
		"\2\2\2\27\61\3\2\2\2\31<\3\2\2\2\33E\3\2\2\2\35\36\t\2\2\2\36\4\3\2\2"+
		"\2\37 \t\3\2\2 \6\3\2\2\2!\"\t\4\2\2\"\b\3\2\2\2#$\t\5\2\2$\n\3\2\2\2"+
		"%&\t\6\2\2&\f\3\2\2\2\'(\t\7\2\2(\16\3\2\2\2)*\t\b\2\2*\20\3\2\2\2+,\t"+
		"\t\2\2,\22\3\2\2\2-.\t\n\2\2.\24\3\2\2\2/\60\t\13\2\2\60\26\3\2\2\2\61"+
		"\62\7I\2\2\62\63\7k\2\2\63\64\7x\2\2\64\65\7g\2\2\65\66\7p\2\2\66\30\3"+
		"\2\2\2\679\7\17\2\28\67\3\2\2\289\3\2\2\29:\3\2\2\2:=\7\f\2\2;=\7\17\2"+
		"\2<8\3\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\32\3\2\2\2@F\5\r"+
		"\7\2AF\5\17\b\2BF\5\21\t\2CF\5\25\13\2DF\5\23\n\2E@\3\2\2\2EA\3\2\2\2"+
		"EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\34\3\2\2"+
		"\2\b\28<>EG\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}