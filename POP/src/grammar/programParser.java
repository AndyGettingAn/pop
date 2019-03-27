// Generated from /Users/bdludwig/Dropbox/workspace/VL_POP/src/grammar/program.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class programParser extends Parser {
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
	public static final int
		RULE_prule = 0, RULE_block = 1, RULE_statement = 2, RULE_mapdecl = 3, 
		RULE_booldecl = 4, RULE_doubledecl = 5, RULE_textdecl = 6, RULE_parameterdecl = 7, 
		RULE_fundecl = 8, RULE_print = 9, RULE_call = 10, RULE_st_if = 11, RULE_logexpression = 12, 
		RULE_condition = 13, RULE_st_while = 14, RULE_st_return = 15, RULE_wait_for = 16, 
		RULE_returntype = 17, RULE_assignment = 18, RULE_expression = 19, RULE_factor = 20, 
		RULE_get = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prule", "block", "statement", "mapdecl", "booldecl", "doubledecl", "textdecl", 
			"parameterdecl", "fundecl", "print", "call", "st_if", "logexpression", 
			"condition", "st_while", "st_return", "wait_for", "returntype", "assignment", 
			"expression", "factor", "get"
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

	@Override
	public String getGrammarFileName() { return "program.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public programParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PruleContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(programParser.PROGRAM, 0); }
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterPrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitPrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitPrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PruleContext prule() throws RecognitionException {
		PruleContext _localctx = new PruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(PROGRAM);
			setState(45);
			match(VARIABLE);
			setState(46);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OPEN_BLOCK() { return getToken(programParser.OPEN_BLOCK, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(programParser.CLOSE_BLOCK, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(OPEN_BLOCK);
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				statement();
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAPDECL) | (1L << DOUBLEDECL) | (1L << TEXTDECL) | (1L << BOOLDECL) | (1L << PRINT) | (1L << LISTENERDECL) | (1L << FUNCTIONDECL) | (1L << PROCDECL) | (1L << RETURN) | (1L << CALL) | (1L << IF) | (1L << EVENT) | (1L << WHILE) | (1L << THREAD) | (1L << WAIT) | (1L << VARIABLE))) != 0) );
			setState(54);
			match(CLOSE_BLOCK);
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(programParser.SEMICOLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MapdeclContext mapdecl() {
			return getRuleContext(MapdeclContext.class,0);
		}
		public BooldeclContext booldecl() {
			return getRuleContext(BooldeclContext.class,0);
		}
		public DoubledeclContext doubledecl() {
			return getRuleContext(DoubledeclContext.class,0);
		}
		public TextdeclContext textdecl() {
			return getRuleContext(TextdeclContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public St_whileContext st_while() {
			return getRuleContext(St_whileContext.class,0);
		}
		public St_returnContext st_return() {
			return getRuleContext(St_returnContext.class,0);
		}
		public FundeclContext fundecl() {
			return getRuleContext(FundeclContext.class,0);
		}
		public St_ifContext st_if() {
			return getRuleContext(St_ifContext.class,0);
		}
		public Wait_forContext wait_for() {
			return getRuleContext(Wait_forContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				{
				setState(56);
				assignment();
				}
				break;
			case MAPDECL:
				{
				setState(57);
				mapdecl();
				}
				break;
			case BOOLDECL:
				{
				setState(58);
				booldecl();
				}
				break;
			case DOUBLEDECL:
				{
				setState(59);
				doubledecl();
				}
				break;
			case TEXTDECL:
				{
				setState(60);
				textdecl();
				}
				break;
			case PRINT:
				{
				setState(61);
				print();
				}
				break;
			case CALL:
			case EVENT:
			case THREAD:
				{
				setState(62);
				call();
				}
				break;
			case WHILE:
				{
				setState(63);
				st_while();
				}
				break;
			case RETURN:
				{
				setState(64);
				st_return();
				}
				break;
			case LISTENERDECL:
			case FUNCTIONDECL:
			case PROCDECL:
				{
				setState(65);
				fundecl();
				}
				break;
			case IF:
				{
				setState(66);
				st_if();
				}
				break;
			case WAIT:
				{
				setState(67);
				wait_for();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(70);
			match(SEMICOLON);
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

	public static class MapdeclContext extends ParserRuleContext {
		public TerminalNode MAPDECL() { return getToken(programParser.MAPDECL, 0); }
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public MapdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterMapdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitMapdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitMapdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapdeclContext mapdecl() throws RecognitionException {
		MapdeclContext _localctx = new MapdeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mapdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(MAPDECL);
			setState(73);
			match(VARIABLE);
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

	public static class BooldeclContext extends ParserRuleContext {
		public TerminalNode BOOLDECL() { return getToken(programParser.BOOLDECL, 0); }
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public BooldeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booldecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterBooldecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitBooldecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitBooldecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooldeclContext booldecl() throws RecognitionException {
		BooldeclContext _localctx = new BooldeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_booldecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(BOOLDECL);
			setState(76);
			match(VARIABLE);
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

	public static class DoubledeclContext extends ParserRuleContext {
		public TerminalNode DOUBLEDECL() { return getToken(programParser.DOUBLEDECL, 0); }
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public DoubledeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubledecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterDoubledecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitDoubledecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitDoubledecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubledeclContext doubledecl() throws RecognitionException {
		DoubledeclContext _localctx = new DoubledeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_doubledecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(DOUBLEDECL);
			setState(79);
			match(VARIABLE);
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

	public static class TextdeclContext extends ParserRuleContext {
		public TerminalNode TEXTDECL() { return getToken(programParser.TEXTDECL, 0); }
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public TextdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterTextdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitTextdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitTextdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextdeclContext textdecl() throws RecognitionException {
		TextdeclContext _localctx = new TextdeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_textdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(TEXTDECL);
			setState(82);
			match(VARIABLE);
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

	public static class ParameterdeclContext extends ParserRuleContext {
		public MapdeclContext mapdecl() {
			return getRuleContext(MapdeclContext.class,0);
		}
		public BooldeclContext booldecl() {
			return getRuleContext(BooldeclContext.class,0);
		}
		public DoubledeclContext doubledecl() {
			return getRuleContext(DoubledeclContext.class,0);
		}
		public TextdeclContext textdecl() {
			return getRuleContext(TextdeclContext.class,0);
		}
		public ParameterdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterParameterdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitParameterdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitParameterdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterdeclContext parameterdecl() throws RecognitionException {
		ParameterdeclContext _localctx = new ParameterdeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameterdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAPDECL:
				{
				setState(84);
				mapdecl();
				}
				break;
			case BOOLDECL:
				{
				setState(85);
				booldecl();
				}
				break;
			case DOUBLEDECL:
				{
				setState(86);
				doubledecl();
				}
				break;
			case TEXTDECL:
				{
				setState(87);
				textdecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class FundeclContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(programParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(programParser.CLOSE_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode FUNCTIONDECL() { return getToken(programParser.FUNCTIONDECL, 0); }
		public ReturntypeContext returntype() {
			return getRuleContext(ReturntypeContext.class,0);
		}
		public TerminalNode PROCDECL() { return getToken(programParser.PROCDECL, 0); }
		public TerminalNode LISTENERDECL() { return getToken(programParser.LISTENERDECL, 0); }
		public List<ParameterdeclContext> parameterdecl() {
			return getRuleContexts(ParameterdeclContext.class);
		}
		public ParameterdeclContext parameterdecl(int i) {
			return getRuleContext(ParameterdeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(programParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(programParser.COMMA, i);
		}
		public FundeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fundecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterFundecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitFundecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitFundecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FundeclContext fundecl() throws RecognitionException {
		FundeclContext _localctx = new FundeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fundecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTIONDECL:
				{
				setState(90);
				match(FUNCTIONDECL);
				setState(91);
				returntype();
				}
				break;
			case PROCDECL:
				{
				setState(92);
				match(PROCDECL);
				}
				break;
			case LISTENERDECL:
				{
				setState(93);
				match(LISTENERDECL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(96);
			match(VARIABLE);
			setState(97);
			match(OPEN_BRACKET);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAPDECL) | (1L << DOUBLEDECL) | (1L << TEXTDECL) | (1L << BOOLDECL))) != 0)) {
				{
				setState(98);
				parameterdecl();
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(99);
					match(COMMA);
					setState(100);
					parameterdecl();
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(108);
			match(CLOSE_BRACKET);
			setState(109);
			block();
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(programParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(PRINT);
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(112);
				expression();
				}
				break;
			case 2:
				{
				setState(113);
				logexpression();
				}
				break;
			}
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

	public static class CallContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(programParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(programParser.CLOSE_BRACKET, 0); }
		public TerminalNode CALL() { return getToken(programParser.CALL, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(programParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(programParser.VARIABLE, i);
		}
		public TerminalNode THREAD() { return getToken(programParser.THREAD, 0); }
		public TerminalNode EVENT() { return getToken(programParser.EVENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(programParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(programParser.COMMA, i);
		}
		public List<TerminalNode> DOT() { return getTokens(programParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(programParser.DOT, i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CALL:
				{
				setState(116);
				match(CALL);
				setState(117);
				match(VARIABLE);
				}
				break;
			case THREAD:
				{
				setState(118);
				match(THREAD);
				setState(119);
				match(VARIABLE);
				}
				break;
			case EVENT:
				{
				setState(120);
				match(EVENT);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VARIABLE) {
					{
					setState(121);
					match(VARIABLE);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==DOT) {
						{
						{
						setState(122);
						match(DOT);
						setState(123);
						match(VARIABLE);
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(133);
			match(OPEN_BRACKET);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << TEXT) | (1L << JSON) | (1L << OPEN_BRACKET) | (1L << TRUE) | (1L << FALSE) | (1L << GET) | (1L << VARIABLE))) != 0)) {
				{
				setState(134);
				expression();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135);
					match(COMMA);
					setState(136);
					expression();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(CLOSE_BRACKET);
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

	public static class St_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(programParser.IF, 0); }
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(programParser.ELSE, 0); }
		public St_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterSt_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitSt_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitSt_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final St_ifContext st_if() throws RecognitionException {
		St_ifContext _localctx = new St_ifContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_st_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IF);
			setState(147);
			logexpression();
			setState(148);
			block();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(149);
				match(ELSE);
				setState(150);
				block();
				}
			}

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

	public static class LogexpressionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(programParser.AND, 0); }
		public TerminalNode OR() { return getToken(programParser.OR, 0); }
		public LogexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterLogexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitLogexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitLogexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogexpressionContext logexpression() throws RecognitionException {
		LogexpressionContext _localctx = new LogexpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			condition();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND || _la==OR) {
				{
				setState(154);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(155);
				logexpression();
				}
			}

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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(programParser.OPEN_BRACKET, 0); }
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(programParser.CLOSE_BRACKET, 0); }
		public TerminalNode NOT() { return getToken(programParser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(programParser.GREATER, 0); }
		public TerminalNode SMALLER() { return getToken(programParser.SMALLER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(programParser.ASSIGNMENT, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(158);
					match(NOT);
					}
				}

				setState(161);
				match(OPEN_BRACKET);
				setState(162);
				logexpression();
				setState(163);
				match(CLOSE_BRACKET);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(165);
				expression();
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGNMENT) | (1L << SMALLER) | (1L << GREATER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				expression();
				}
				}
				break;
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

	public static class St_whileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(programParser.WHILE, 0); }
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public St_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterSt_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitSt_while(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitSt_while(this);
			else return visitor.visitChildren(this);
		}
	}

	public final St_whileContext st_while() throws RecognitionException {
		St_whileContext _localctx = new St_whileContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_st_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(WHILE);
			setState(172);
			logexpression();
			setState(173);
			block();
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

	public static class St_returnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(programParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public St_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterSt_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitSt_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitSt_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final St_returnContext st_return() throws RecognitionException {
		St_returnContext _localctx = new St_returnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_st_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(RETURN);
			setState(176);
			expression();
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

	public static class Wait_forContext extends ParserRuleContext {
		public TerminalNode WAIT() { return getToken(programParser.WAIT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Wait_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wait_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterWait_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitWait_for(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitWait_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wait_forContext wait_for() throws RecognitionException {
		Wait_forContext _localctx = new Wait_forContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_wait_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(WAIT);
			setState(179);
			expression();
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

	public static class ReturntypeContext extends ParserRuleContext {
		public TerminalNode TEXTDECL() { return getToken(programParser.TEXTDECL, 0); }
		public TerminalNode DOUBLEDECL() { return getToken(programParser.DOUBLEDECL, 0); }
		public TerminalNode MAPDECL() { return getToken(programParser.MAPDECL, 0); }
		public TerminalNode BOOLDECL() { return getToken(programParser.BOOLDECL, 0); }
		public ReturntypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returntype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterReturntype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitReturntype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitReturntype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturntypeContext returntype() throws RecognitionException {
		ReturntypeContext _localctx = new ReturntypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returntype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAPDECL) | (1L << DOUBLEDECL) | (1L << TEXTDECL) | (1L << BOOLDECL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(programParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogexpressionContext logexpression() {
			return getRuleContext(LogexpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(VARIABLE);
			setState(184);
			match(ASSIGNMENT);
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(185);
				expression();
				}
				break;
			case 2:
				{
				setState(186);
				logexpression();
				}
				break;
			}
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

	public static class ExpressionContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OPERATOR_ADD() { return getToken(programParser.OPERATOR_ADD, 0); }
		public TerminalNode OPERATOR_SUB() { return getToken(programParser.OPERATOR_SUB, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			factor();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPERATOR_ADD || _la==OPERATOR_SUB) {
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==OPERATOR_ADD || _la==OPERATOR_SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				expression();
				}
			}

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

	public static class FactorContext extends ParserRuleContext {
		public ExpressionContext op;
		public TerminalNode NUMBER() { return getToken(programParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(programParser.TEXT, 0); }
		public TerminalNode TRUE() { return getToken(programParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(programParser.FALSE, 0); }
		public TerminalNode JSON() { return getToken(programParser.JSON, 0); }
		public GetContext get() {
			return getRuleContext(GetContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(programParser.VARIABLE, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(programParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(programParser.CLOSE_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode OPERATOR_MULT() { return getToken(programParser.OPERATOR_MULT, 0); }
		public TerminalNode OPERATOR_DIV() { return getToken(programParser.OPERATOR_DIV, 0); }
		public List<TerminalNode> COMMA() { return getTokens(programParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(programParser.COMMA, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(194);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(195);
				match(TEXT);
				}
				break;
			case TRUE:
				{
				setState(196);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				setState(197);
				match(FALSE);
				}
				break;
			case JSON:
				{
				setState(198);
				match(JSON);
				}
				break;
			case GET:
				{
				setState(199);
				get();
				}
				break;
			case VARIABLE:
				{
				setState(200);
				match(VARIABLE);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_BRACKET) {
					{
					setState(201);
					match(OPEN_BRACKET);
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << TEXT) | (1L << JSON) | (1L << OPEN_BRACKET) | (1L << TRUE) | (1L << FALSE) | (1L << GET) | (1L << VARIABLE))) != 0)) {
						{
						setState(202);
						expression();
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(203);
							match(COMMA);
							setState(204);
							expression();
							}
							}
							setState(209);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(212);
					match(CLOSE_BRACKET);
					}
				}

				}
				break;
			case OPEN_BRACKET:
				{
				setState(215);
				match(OPEN_BRACKET);
				setState(216);
				((FactorContext)_localctx).op = expression();
				setState(217);
				match(CLOSE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPERATOR_MULT || _la==OPERATOR_DIV) {
				{
				setState(221);
				_la = _input.LA(1);
				if ( !(_la==OPERATOR_MULT || _la==OPERATOR_DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(222);
				factor();
				}
			}

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

	public static class GetContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(programParser.GET, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(programParser.OPEN_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(programParser.COMMA, 0); }
		public TerminalNode TEXT() { return getToken(programParser.TEXT, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(programParser.CLOSE_BRACKET, 0); }
		public GetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).enterGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof programListener ) ((programListener)listener).exitGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof programVisitor ) return ((programVisitor<? extends T>)visitor).visitGet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetContext get() throws RecognitionException {
		GetContext _localctx = new GetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_get);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(GET);
			setState(226);
			match(OPEN_BRACKET);
			setState(227);
			expression();
			setState(228);
			match(COMMA);
			setState(229);
			match(TEXT);
			setState(230);
			match(CLOSE_BRACKET);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\6\3\65\n\3\r\3\16\3\66\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4G\n\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t[\n\t\3\n\3\n\3\n\3\n\5\na\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\5\nm\n\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\5\13u\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\177\n\f\f\f\16\f\u0082"+
		"\13\f\5\f\u0084\n\f\5\f\u0086\n\f\3\f\3\f\3\f\3\f\7\f\u008c\n\f\f\f\16"+
		"\f\u008f\13\f\5\f\u0091\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u009a\n\r"+
		"\3\16\3\16\3\16\5\16\u009f\n\16\3\17\5\17\u00a2\n\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00ac\n\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00be\n\24\3\25"+
		"\3\25\3\25\5\25\u00c3\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u00d0\n\26\f\26\16\26\u00d3\13\26\5\26\u00d5\n\26\3\26"+
		"\5\26\u00d8\n\26\3\26\3\26\3\26\3\26\5\26\u00de\n\26\3\26\3\26\5\26\u00e2"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2!\"\4\2\r\r\35\36\3\2\16\21\3\2\7"+
		"\b\3\2\t\n\2\u00ff\2.\3\2\2\2\4\62\3\2\2\2\6F\3\2\2\2\bJ\3\2\2\2\nM\3"+
		"\2\2\2\fP\3\2\2\2\16S\3\2\2\2\20Z\3\2\2\2\22`\3\2\2\2\24q\3\2\2\2\26\u0085"+
		"\3\2\2\2\30\u0094\3\2\2\2\32\u009b\3\2\2\2\34\u00ab\3\2\2\2\36\u00ad\3"+
		"\2\2\2 \u00b1\3\2\2\2\"\u00b4\3\2\2\2$\u00b7\3\2\2\2&\u00b9\3\2\2\2(\u00bf"+
		"\3\2\2\2*\u00dd\3\2\2\2,\u00e3\3\2\2\2./\7\33\2\2/\60\7,\2\2\60\61\5\4"+
		"\3\2\61\3\3\2\2\2\62\64\7\13\2\2\63\65\5\6\4\2\64\63\3\2\2\2\65\66\3\2"+
		"\2\2\66\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\7\f\2\29\5\3\2\2\2:G\5"+
		"&\24\2;G\5\b\5\2<G\5\n\6\2=G\5\f\7\2>G\5\16\b\2?G\5\24\13\2@G\5\26\f\2"+
		"AG\5\36\20\2BG\5 \21\2CG\5\22\n\2DG\5\30\r\2EG\5\"\22\2F:\3\2\2\2F;\3"+
		"\2\2\2F<\3\2\2\2F=\3\2\2\2F>\3\2\2\2F?\3\2\2\2F@\3\2\2\2FA\3\2\2\2FB\3"+
		"\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2GH\3\2\2\2HI\7+\2\2I\7\3\2\2\2JK\7"+
		"\16\2\2KL\7,\2\2L\t\3\2\2\2MN\7\21\2\2NO\7,\2\2O\13\3\2\2\2PQ\7\17\2\2"+
		"QR\7,\2\2R\r\3\2\2\2ST\7\20\2\2TU\7,\2\2U\17\3\2\2\2V[\5\b\5\2W[\5\n\6"+
		"\2X[\5\f\7\2Y[\5\16\b\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\21\3"+
		"\2\2\2\\]\7\24\2\2]a\5$\23\2^a\7\25\2\2_a\7\23\2\2`\\\3\2\2\2`^\3\2\2"+
		"\2`_\3\2\2\2ab\3\2\2\2bc\7,\2\2cl\7\27\2\2di\5\20\t\2ef\7\31\2\2fh\5\20"+
		"\t\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2ld\3\2"+
		"\2\2lm\3\2\2\2mn\3\2\2\2no\7\30\2\2op\5\4\3\2p\23\3\2\2\2qt\7\22\2\2r"+
		"u\5(\25\2su\5\32\16\2tr\3\2\2\2ts\3\2\2\2u\25\3\2\2\2vw\7\34\2\2w\u0086"+
		"\7,\2\2xy\7)\2\2y\u0086\7,\2\2z\u0083\7$\2\2{\u0080\7,\2\2|}\7\32\2\2"+
		"}\177\7,\2\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083{\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085v\3\2\2\2\u0085x\3\2\2\2\u0085z\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0090\7\27\2\2\u0088\u008d\5(\25\2\u0089"+
		"\u008a\7\31\2\2\u008a\u008c\5(\25\2\u008b\u0089\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\7\30\2\2\u0093\27\3\2\2\2\u0094\u0095\7\37\2\2\u0095"+
		"\u0096\5\32\16\2\u0096\u0099\5\4\3\2\u0097\u0098\7 \2\2\u0098\u009a\5"+
		"\4\3\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\31\3\2\2\2\u009b"+
		"\u009e\5\34\17\2\u009c\u009d\t\2\2\2\u009d\u009f\5\32\16\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\33\3\2\2\2\u00a0\u00a2\7#\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\27"+
		"\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\7\30\2\2\u00a6\u00ac\3\2\2\2\u00a7"+
		"\u00a8\5(\25\2\u00a8\u00a9\t\3\2\2\u00a9\u00aa\5(\25\2\u00aa\u00ac\3\2"+
		"\2\2\u00ab\u00a1\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac\35\3\2\2\2\u00ad\u00ae"+
		"\7%\2\2\u00ae\u00af\5\32\16\2\u00af\u00b0\5\4\3\2\u00b0\37\3\2\2\2\u00b1"+
		"\u00b2\7\26\2\2\u00b2\u00b3\5(\25\2\u00b3!\3\2\2\2\u00b4\u00b5\7*\2\2"+
		"\u00b5\u00b6\5(\25\2\u00b6#\3\2\2\2\u00b7\u00b8\t\4\2\2\u00b8%\3\2\2\2"+
		"\u00b9\u00ba\7,\2\2\u00ba\u00bd\7\r\2\2\u00bb\u00be\5(\25\2\u00bc\u00be"+
		"\5\32\16\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\'\3\2\2\2\u00bf"+
		"\u00c2\5*\26\2\u00c0\u00c1\t\5\2\2\u00c1\u00c3\5(\25\2\u00c2\u00c0\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3)\3\2\2\2\u00c4\u00de\7\4\2\2\u00c5\u00de"+
		"\7\5\2\2\u00c6\u00de\7&\2\2\u00c7\u00de\7\'\2\2\u00c8\u00de\7\6\2\2\u00c9"+
		"\u00de\5,\27\2\u00ca\u00d7\7,\2\2\u00cb\u00d4\7\27\2\2\u00cc\u00d1\5("+
		"\25\2\u00cd\u00ce\7\31\2\2\u00ce\u00d0\5(\25\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d8\7\30\2\2\u00d7\u00cb\3\2\2\2\u00d7\u00d8\3"+
		"\2\2\2\u00d8\u00de\3\2\2\2\u00d9\u00da\7\27\2\2\u00da\u00db\5(\25\2\u00db"+
		"\u00dc\7\30\2\2\u00dc\u00de\3\2\2\2\u00dd\u00c4\3\2\2\2\u00dd\u00c5\3"+
		"\2\2\2\u00dd\u00c6\3\2\2\2\u00dd\u00c7\3\2\2\2\u00dd\u00c8\3\2\2\2\u00dd"+
		"\u00c9\3\2\2\2\u00dd\u00ca\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\u00e1\3\2"+
		"\2\2\u00df\u00e0\t\6\2\2\u00e0\u00e2\5*\26\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2+\3\2\2\2\u00e3\u00e4\7(\2\2\u00e4\u00e5\7\27\2\2"+
		"\u00e5\u00e6\5(\25\2\u00e6\u00e7\7\31\2\2\u00e7\u00e8\7\5\2\2\u00e8\u00e9"+
		"\7\30\2\2\u00e9-\3\2\2\2\31\66FZ`ilt\u0080\u0083\u0085\u008d\u0090\u0099"+
		"\u009e\u00a1\u00ab\u00bd\u00c2\u00d1\u00d4\u00d7\u00dd\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}