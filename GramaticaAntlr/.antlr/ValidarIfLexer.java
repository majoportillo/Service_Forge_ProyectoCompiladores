// Generated from c:/Users/HP BLUE/Desktop/Tareas/GramaticaAntlr/ValidarIf.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ValidarIfLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, IF=3, ELSE=4, IGUAL=5, PYC=6, L_LLAVE=7, R_LLAVE=8, IGUAL_IGUAL=9, 
		DIF=10, MENOR=11, MAYOR=12, ID=13, INT=14, COMMENT=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "IF", "ELSE", "IGUAL", "PYC", "L_LLAVE", "R_LLAVE", "IGUAL_IGUAL", 
			"DIF", "MENOR", "MAYOR", "ID", "INT", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'if'", "'else'", "'='", "';'", "'{'", "'}'", "'=='", 
			"'!='", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "IF", "ELSE", "IGUAL", "PYC", "L_LLAVE", "R_LLAVE", 
			"IGUAL_IGUAL", "DIF", "MENOR", "MAYOR", "ID", "INT", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ValidarIfLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValidarIf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010j\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0005\fB\b\f\n\f\f\fE\t\f\u0001\r\u0004\rH\b\r\u000b\r\f\rI\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000eP\b\u000e\n\u000e\f\u000e"+
		"S\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"Y\b\u000e\n\u000e\f\u000e\\\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"`\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000fe\b\u000f\u000b"+
		"\u000f\f\u000ff\u0001\u000f\u0001\u000f\u0001Z\u0000\u0010\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001"+
		"\u000009\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  o\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000"+
		"\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007("+
		"\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000\u000b/\u0001\u0000"+
		"\u0000\u0000\r1\u0001\u0000\u0000\u0000\u000f3\u0001\u0000\u0000\u0000"+
		"\u00115\u0001\u0000\u0000\u0000\u00138\u0001\u0000\u0000\u0000\u0015;"+
		"\u0001\u0000\u0000\u0000\u0017=\u0001\u0000\u0000\u0000\u0019?\u0001\u0000"+
		"\u0000\u0000\u001bG\u0001\u0000\u0000\u0000\u001d_\u0001\u0000\u0000\u0000"+
		"\u001fd\u0001\u0000\u0000\u0000!\"\u0005(\u0000\u0000\"\u0002\u0001\u0000"+
		"\u0000\u0000#$\u0005)\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005"+
		"i\u0000\u0000&\'\u0005f\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000()"+
		"\u0005e\u0000\u0000)*\u0005l\u0000\u0000*+\u0005s\u0000\u0000+,\u0005"+
		"e\u0000\u0000,\b\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\n\u0001"+
		"\u0000\u0000\u0000/0\u0005;\u0000\u00000\f\u0001\u0000\u0000\u000012\u0005"+
		"{\u0000\u00002\u000e\u0001\u0000\u0000\u000034\u0005}\u0000\u00004\u0010"+
		"\u0001\u0000\u0000\u000056\u0005=\u0000\u000067\u0005=\u0000\u00007\u0012"+
		"\u0001\u0000\u0000\u000089\u0005!\u0000\u00009:\u0005=\u0000\u0000:\u0014"+
		"\u0001\u0000\u0000\u0000;<\u0005<\u0000\u0000<\u0016\u0001\u0000\u0000"+
		"\u0000=>\u0005>\u0000\u0000>\u0018\u0001\u0000\u0000\u0000?C\u0007\u0000"+
		"\u0000\u0000@B\u0007\u0001\u0000\u0000A@\u0001\u0000\u0000\u0000BE\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"D\u001a\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FH\u0007\u0002"+
		"\u0000\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u001c\u0001\u0000\u0000"+
		"\u0000KL\u0005/\u0000\u0000LM\u0005/\u0000\u0000MQ\u0001\u0000\u0000\u0000"+
		"NP\b\u0003\u0000\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R`\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000TU\u0005/\u0000\u0000UV\u0005*\u0000\u0000"+
		"VZ\u0001\u0000\u0000\u0000WY\t\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000"+
		"Y\\\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005*\u0000"+
		"\u0000^`\u0005/\u0000\u0000_K\u0001\u0000\u0000\u0000_T\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ab\u0006\u000e\u0000\u0000b\u001e\u0001"+
		"\u0000\u0000\u0000ce\u0007\u0004\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hi\u0006\u000f\u0000\u0000i \u0001\u0000"+
		"\u0000\u0000\u0007\u0000CIQZ_f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}