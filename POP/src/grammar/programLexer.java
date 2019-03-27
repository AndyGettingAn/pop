// Generated from /Users/bdludwig/Dropbox/workspace/VL_POP/src/grammar/program.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class programLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NUMBER=2, TEXT=3, JSON=4, OPERATOR_ADD=5, OPERATOR_SUB=6, OPERATOR_MULT=7, 
		OPERATOR_DIV=8, OPEN_BLOCK=9, CLOSE_BLOCK=10, ASSIGNMENT=11, MAPDECL=12, 
		DOUBLEDECL=13, TEXTDECL=14, BOOLDECL=15, PRINT=16, LISTENERDECL=17, FUNCTIONDECL=18, 
		PROCDECL=19, RETURN=20, OPEN_BRACKET=21, CLOSE_BRACKET=22, COMMA=23, DOT=24, 
		PROGRAM=25, CALL=26, SMALLER=27, GREATER=28, IF=29, ELSE=30, AND=31, OR=32, 
		NOT=33, EVENT=34, WHILE=35, TRUE=36, FALSE=37, GET=38, THREAD=39, WAIT=40, 
		SEMICOLON=41, VARIABLE=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "NUMBER", "TEXT", "JSON", "OPERATOR_ADD", "OPERATOR_SUB", "OPERATOR_MULT", 
			"OPERATOR_DIV", "OPEN_BLOCK", "CLOSE_BLOCK", "ASSIGNMENT", "MAPDECL", 
			"DOUBLEDECL", "TEXTDECL", "BOOLDECL", "PRINT", "LISTENERDECL", "FUNCTIONDECL", 
			"PROCDECL", "RETURN", "OPEN_BRACKET", "CLOSE_BRACKET", "COMMA", "DOT", 
			"PROGRAM", "CALL", "SMALLER", "GREATER", "IF", "ELSE", "AND", "OR", "NOT", 
			"EVENT", "WHILE", "TRUE", "FALSE", "GET", "THREAD", "WAIT", "SEMICOLON", 
			"VARIABLE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'{'", "'}'", 
			"'='", "'MAP'", "'DOUBLE'", "'TEXT'", "'BOOLEAN'", "'PRINT'", "'LISTENER'", 
			"'FUN'", "'PROC'", "'RETURN'", "'('", "')'", "','", "'.'", "'PROGRAM'", 
			"'CALL'", "'<'", "'>'", "'IF'", "'ELSE'", "'&'", "'|'", "'!'", "'EVENT'", 
			"'WHILE'", "'TRUE'", "'FALSE'", "'GET'", "'THREAD'", "'WAIT'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "NUMBER", "TEXT", "JSON", "OPERATOR_ADD", "OPERATOR_SUB", 
			"OPERATOR_MULT", "OPERATOR_DIV", "OPEN_BLOCK", "CLOSE_BLOCK", "ASSIGNMENT", 
			"MAPDECL", "DOUBLEDECL", "TEXTDECL", "BOOLDECL", "PRINT", "LISTENERDECL", 
			"FUNCTIONDECL", "PROCDECL", "RETURN", "OPEN_BRACKET", "CLOSE_BRACKET", 
			"COMMA", "DOT", "PROGRAM", "CALL", "SMALLER", "GREATER", "IF", "ELSE", 
			"AND", "OR", "NOT", "EVENT", "WHILE", "TRUE", "FALSE", "GET", "THREAD", 
			"WAIT", "SEMICOLON", "VARIABLE"
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


	public programLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "program.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u011a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\6\2Y\n\2\r\2\16\2Z\3\2\3\2\3\3\5\3`\n\3\3\3\6\3c\n\3\r\3\16\3d\3\3"+
		"\3\3\6\3i\n\3\r\3\16\3j\5\3m\n\3\3\4\3\4\7\4q\n\4\f\4\16\4t\13\4\3\4\3"+
		"\4\3\5\3\5\7\5z\n\5\f\5\16\5}\13\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3+\6+\u0117\n+\r"+
		"+\16+\u0118\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\5\5\2\13\f\17\17\"\""+
		"\4\2..\60\60\4\2C\\c|\2\u0121\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3X\3\2\2\2\5_\3\2\2\2\7n\3\2\2"+
		"\2\tw\3\2\2\2\13\u0080\3\2\2\2\r\u0082\3\2\2\2\17\u0084\3\2\2\2\21\u0086"+
		"\3\2\2\2\23\u0088\3\2\2\2\25\u008a\3\2\2\2\27\u008c\3\2\2\2\31\u008e\3"+
		"\2\2\2\33\u0092\3\2\2\2\35\u0099\3\2\2\2\37\u009e\3\2\2\2!\u00a6\3\2\2"+
		"\2#\u00ac\3\2\2\2%\u00b5\3\2\2\2\'\u00b9\3\2\2\2)\u00be\3\2\2\2+\u00c5"+
		"\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2\63\u00cd\3\2\2"+
		"\2\65\u00d5\3\2\2\2\67\u00da\3\2\2\29\u00dc\3\2\2\2;\u00de\3\2\2\2=\u00e1"+
		"\3\2\2\2?\u00e6\3\2\2\2A\u00e8\3\2\2\2C\u00ea\3\2\2\2E\u00ec\3\2\2\2G"+
		"\u00f2\3\2\2\2I\u00f8\3\2\2\2K\u00fd\3\2\2\2M\u0103\3\2\2\2O\u0107\3\2"+
		"\2\2Q\u010e\3\2\2\2S\u0113\3\2\2\2U\u0116\3\2\2\2WY\t\2\2\2XW\3\2\2\2"+
		"YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\b\2\2\2]\4\3\2\2\2^`\7/\2"+
		"\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\4\62;\2ba\3\2\2\2cd\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2el\3\2\2\2fh\t\3\2\2gi\4\62;\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2"+
		"\2jk\3\2\2\2km\3\2\2\2lf\3\2\2\2lm\3\2\2\2m\6\3\2\2\2nr\7$\2\2oq\13\2"+
		"\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7$"+
		"\2\2v\b\3\2\2\2w{\7)\2\2xz\13\2\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7)\2\2\177\n\3\2\2\2\u0080\u0081\7-\2"+
		"\2\u0081\f\3\2\2\2\u0082\u0083\7/\2\2\u0083\16\3\2\2\2\u0084\u0085\7,"+
		"\2\2\u0085\20\3\2\2\2\u0086\u0087\7\61\2\2\u0087\22\3\2\2\2\u0088\u0089"+
		"\7}\2\2\u0089\24\3\2\2\2\u008a\u008b\7\177\2\2\u008b\26\3\2\2\2\u008c"+
		"\u008d\7?\2\2\u008d\30\3\2\2\2\u008e\u008f\7O\2\2\u008f\u0090\7C\2\2\u0090"+
		"\u0091\7R\2\2\u0091\32\3\2\2\2\u0092\u0093\7F\2\2\u0093\u0094\7Q\2\2\u0094"+
		"\u0095\7W\2\2\u0095\u0096\7D\2\2\u0096\u0097\7N\2\2\u0097\u0098\7G\2\2"+
		"\u0098\34\3\2\2\2\u0099\u009a\7V\2\2\u009a\u009b\7G\2\2\u009b\u009c\7"+
		"Z\2\2\u009c\u009d\7V\2\2\u009d\36\3\2\2\2\u009e\u009f\7D\2\2\u009f\u00a0"+
		"\7Q\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7G\2\2\u00a3"+
		"\u00a4\7C\2\2\u00a4\u00a5\7P\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7R\2\2\u00a7"+
		"\u00a8\7T\2\2\u00a8\u00a9\7K\2\2\u00a9\u00aa\7P\2\2\u00aa\u00ab\7V\2\2"+
		"\u00ab\"\3\2\2\2\u00ac\u00ad\7N\2\2\u00ad\u00ae\7K\2\2\u00ae\u00af\7U"+
		"\2\2\u00af\u00b0\7V\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b3"+
		"\7G\2\2\u00b3\u00b4\7T\2\2\u00b4$\3\2\2\2\u00b5\u00b6\7H\2\2\u00b6\u00b7"+
		"\7W\2\2\u00b7\u00b8\7P\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7R\2\2\u00ba\u00bb"+
		"\7T\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7E\2\2\u00bd(\3\2\2\2\u00be\u00bf"+
		"\7T\2\2\u00bf\u00c0\7G\2\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7W\2\2\u00c2"+
		"\u00c3\7T\2\2\u00c3\u00c4\7P\2\2\u00c4*\3\2\2\2\u00c5\u00c6\7*\2\2\u00c6"+
		",\3\2\2\2\u00c7\u00c8\7+\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7.\2\2\u00ca\60"+
		"\3\2\2\2\u00cb\u00cc\7\60\2\2\u00cc\62\3\2\2\2\u00cd\u00ce\7R\2\2\u00ce"+
		"\u00cf\7T\2\2\u00cf\u00d0\7Q\2\2\u00d0\u00d1\7I\2\2\u00d1\u00d2\7T\2\2"+
		"\u00d2\u00d3\7C\2\2\u00d3\u00d4\7O\2\2\u00d4\64\3\2\2\2\u00d5\u00d6\7"+
		"E\2\2\u00d6\u00d7\7C\2\2\u00d7\u00d8\7N\2\2\u00d8\u00d9\7N\2\2\u00d9\66"+
		"\3\2\2\2\u00da\u00db\7>\2\2\u00db8\3\2\2\2\u00dc\u00dd\7@\2\2\u00dd:\3"+
		"\2\2\2\u00de\u00df\7K\2\2\u00df\u00e0\7H\2\2\u00e0<\3\2\2\2\u00e1\u00e2"+
		"\7G\2\2\u00e2\u00e3\7N\2\2\u00e3\u00e4\7U\2\2\u00e4\u00e5\7G\2\2\u00e5"+
		">\3\2\2\2\u00e6\u00e7\7(\2\2\u00e7@\3\2\2\2\u00e8\u00e9\7~\2\2\u00e9B"+
		"\3\2\2\2\u00ea\u00eb\7#\2\2\u00ebD\3\2\2\2\u00ec\u00ed\7G\2\2\u00ed\u00ee"+
		"\7X\2\2\u00ee\u00ef\7G\2\2\u00ef\u00f0\7P\2\2\u00f0\u00f1\7V\2\2\u00f1"+
		"F\3\2\2\2\u00f2\u00f3\7Y\2\2\u00f3\u00f4\7J\2\2\u00f4\u00f5\7K\2\2\u00f5"+
		"\u00f6\7N\2\2\u00f6\u00f7\7G\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7V\2\2\u00f9"+
		"\u00fa\7T\2\2\u00fa\u00fb\7W\2\2\u00fb\u00fc\7G\2\2\u00fcJ\3\2\2\2\u00fd"+
		"\u00fe\7H\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7N\2\2\u0100\u0101\7U\2\2"+
		"\u0101\u0102\7G\2\2\u0102L\3\2\2\2\u0103\u0104\7I\2\2\u0104\u0105\7G\2"+
		"\2\u0105\u0106\7V\2\2\u0106N\3\2\2\2\u0107\u0108\7V\2\2\u0108\u0109\7"+
		"J\2\2\u0109\u010a\7T\2\2\u010a\u010b\7G\2\2\u010b\u010c\7C\2\2\u010c\u010d"+
		"\7F\2\2\u010dP\3\2\2\2\u010e\u010f\7Y\2\2\u010f\u0110\7C\2\2\u0110\u0111"+
		"\7K\2\2\u0111\u0112\7V\2\2\u0112R\3\2\2\2\u0113\u0114\7=\2\2\u0114T\3"+
		"\2\2\2\u0115\u0117\t\4\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119V\3\2\2\2\13\2Z_djlr{\u0118\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}