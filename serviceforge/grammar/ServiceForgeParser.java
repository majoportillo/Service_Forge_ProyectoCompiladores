// Generated from ServiceForge.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ServiceForgeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, API=11, RESOURCE=12, FIELDS=13, ENDPOINT=14, RELATIONSHIP=15, 
		GET=16, POST=17, PUT=18, DELETE=19, PATCH=20, INT=21, STRING=22, EMAIL=23, 
		BOOLEAN=24, DATETIME=25, DECIMAL=26, UUID=27, REQUIRED=28, UNIQUE=29, 
		PK=30, DEFAULT=31, MIN=32, MAX=33, PAGINATED=34, AUTH_TYPE=35, HAS_MANY=36, 
		HAS_ONE=37, BELONGS_TO=38, BOOLEAN_LIT=39, VERSION_NUMBER=40, NUMBER=41, 
		PATH=42, STRING_LITERAL=43, IDENTIFIER=44, NEWLINE=45, WS=46, COMMENT=47;
	public static final int
		RULE_program = 0, RULE_apiBlock = 1, RULE_apiOption = 2, RULE_resourceBlock = 3, 
		RULE_fieldsLine = 4, RULE_fieldDef = 5, RULE_dataType = 6, RULE_fieldModifier = 7, 
		RULE_endpointLine = 8, RULE_httpMethod = 9, RULE_endpointOption = 10, 
		RULE_returnType = 11, RULE_returnModifier = 12, RULE_relationshipLine = 13, 
		RULE_relType = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "apiBlock", "apiOption", "resourceBlock", "fieldsLine", "fieldDef", 
			"dataType", "fieldModifier", "endpointLine", "httpMethod", "endpointOption", 
			"returnType", "returnModifier", "relationshipLine", "relType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'version'", "'='", "'base'", "':'", "','", "'->'", "'auth'", "'with'", 
			"'('", "')'", "'api'", "'resource'", "'fields'", "'endpoint'", "'relationship'", 
			"'GET'", "'POST'", "'PUT'", "'DELETE'", "'PATCH'", "'int'", "'string'", 
			"'email'", "'boolean'", "'datetime'", "'decimal'", "'uuid'", "'required'", 
			"'unique'", "'pk'", "'default'", "'min'", "'max'", "'paginated'", null, 
			"'has_many'", "'has_one'", "'belongs_to'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "API", 
			"RESOURCE", "FIELDS", "ENDPOINT", "RELATIONSHIP", "GET", "POST", "PUT", 
			"DELETE", "PATCH", "INT", "STRING", "EMAIL", "BOOLEAN", "DATETIME", "DECIMAL", 
			"UUID", "REQUIRED", "UNIQUE", "PK", "DEFAULT", "MIN", "MAX", "PAGINATED", 
			"AUTH_TYPE", "HAS_MANY", "HAS_ONE", "BELONGS_TO", "BOOLEAN_LIT", "VERSION_NUMBER", 
			"NUMBER", "PATH", "STRING_LITERAL", "IDENTIFIER", "NEWLINE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "ServiceForge.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ServiceForgeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ServiceForgeParser.EOF, 0); }
		public List<ApiBlockContext> apiBlock() {
			return getRuleContexts(ApiBlockContext.class);
		}
		public ApiBlockContext apiBlock(int i) {
			return getRuleContext(ApiBlockContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==API || _la==NEWLINE) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case API:
					{
					setState(30);
					apiBlock();
					}
					break;
				case NEWLINE:
					{
					setState(31);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ApiBlockContext extends ParserRuleContext {
		public TerminalNode API() { return getToken(ServiceForgeParser.API, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ServiceForgeParser.IDENTIFIER, 0); }
		public TerminalNode EOF() { return getToken(ServiceForgeParser.EOF, 0); }
		public List<ApiOptionContext> apiOption() {
			return getRuleContexts(ApiOptionContext.class);
		}
		public ApiOptionContext apiOption(int i) {
			return getRuleContext(ApiOptionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public List<ResourceBlockContext> resourceBlock() {
			return getRuleContexts(ResourceBlockContext.class);
		}
		public ResourceBlockContext resourceBlock(int i) {
			return getRuleContext(ResourceBlockContext.class,i);
		}
		public ApiBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterApiBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitApiBlock(this);
		}
	}

	public final ApiBlockContext apiBlock() throws RecognitionException {
		ApiBlockContext _localctx = new ApiBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_apiBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(API);
			setState(40);
			match(IDENTIFIER);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__2) {
				{
				{
				setState(41);
				apiOption();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(48); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(47);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(50); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RESOURCE) {
					{
					{
					setState(52);
					resourceBlock();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case EOF:
				{
				setState(58);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ApiOptionContext extends ParserRuleContext {
		public TerminalNode VERSION_NUMBER() { return getToken(ServiceForgeParser.VERSION_NUMBER, 0); }
		public TerminalNode PATH() { return getToken(ServiceForgeParser.PATH, 0); }
		public ApiOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apiOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterApiOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitApiOption(this);
		}
	}

	public final ApiOptionContext apiOption() throws RecognitionException {
		ApiOptionContext _localctx = new ApiOptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_apiOption);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(T__0);
				setState(62);
				match(T__1);
				setState(63);
				match(VERSION_NUMBER);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__2);
				setState(65);
				match(T__1);
				setState(66);
				match(PATH);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceBlockContext extends ParserRuleContext {
		public TerminalNode RESOURCE() { return getToken(ServiceForgeParser.RESOURCE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ServiceForgeParser.IDENTIFIER, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public List<FieldsLineContext> fieldsLine() {
			return getRuleContexts(FieldsLineContext.class);
		}
		public FieldsLineContext fieldsLine(int i) {
			return getRuleContext(FieldsLineContext.class,i);
		}
		public List<EndpointLineContext> endpointLine() {
			return getRuleContexts(EndpointLineContext.class);
		}
		public EndpointLineContext endpointLine(int i) {
			return getRuleContext(EndpointLineContext.class,i);
		}
		public List<RelationshipLineContext> relationshipLine() {
			return getRuleContexts(RelationshipLineContext.class);
		}
		public RelationshipLineContext relationshipLine(int i) {
			return getRuleContext(RelationshipLineContext.class,i);
		}
		public ResourceBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterResourceBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitResourceBlock(this);
		}
	}

	public final ResourceBlockContext resourceBlock() throws RecognitionException {
		ResourceBlockContext _localctx = new ResourceBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_resourceBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(RESOURCE);
			setState(70);
			match(IDENTIFIER);
			setState(72); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(71);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(74); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(80);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FIELDS:
						{
						setState(76);
						fieldsLine();
						}
						break;
					case ENDPOINT:
						{
						setState(77);
						endpointLine();
						}
						break;
					case RELATIONSHIP:
						{
						setState(78);
						relationshipLine();
						}
						break;
					case NEWLINE:
						{
						setState(79);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldsLineContext extends ParserRuleContext {
		public TerminalNode FIELDS() { return getToken(ServiceForgeParser.FIELDS, 0); }
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public FieldsLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldsLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterFieldsLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitFieldsLine(this);
		}
	}

	public final FieldsLineContext fieldsLine() throws RecognitionException {
		FieldsLineContext _localctx = new FieldsLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldsLine);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(FIELDS);
			setState(86);
			match(T__3);
			setState(87);
			fieldDef();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(88);
				match(T__4);
				setState(89);
				fieldDef();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(95);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(98); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDefContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ServiceForgeParser.IDENTIFIER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterFieldDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitFieldDef(this);
		}
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IDENTIFIER);
			setState(101);
			dataType();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0)) {
				{
				{
				setState(102);
				fieldModifier();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ServiceForgeParser.INT, 0); }
		public TerminalNode STRING() { return getToken(ServiceForgeParser.STRING, 0); }
		public TerminalNode EMAIL() { return getToken(ServiceForgeParser.EMAIL, 0); }
		public TerminalNode BOOLEAN() { return getToken(ServiceForgeParser.BOOLEAN, 0); }
		public TerminalNode DATETIME() { return getToken(ServiceForgeParser.DATETIME, 0); }
		public TerminalNode DECIMAL() { return getToken(ServiceForgeParser.DECIMAL, 0); }
		public TerminalNode UUID() { return getToken(ServiceForgeParser.UUID, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 266338304L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldModifierContext extends ParserRuleContext {
		public TerminalNode REQUIRED() { return getToken(ServiceForgeParser.REQUIRED, 0); }
		public TerminalNode UNIQUE() { return getToken(ServiceForgeParser.UNIQUE, 0); }
		public TerminalNode PK() { return getToken(ServiceForgeParser.PK, 0); }
		public TerminalNode DEFAULT() { return getToken(ServiceForgeParser.DEFAULT, 0); }
		public TerminalNode NUMBER() { return getToken(ServiceForgeParser.NUMBER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(ServiceForgeParser.STRING_LITERAL, 0); }
		public TerminalNode BOOLEAN_LIT() { return getToken(ServiceForgeParser.BOOLEAN_LIT, 0); }
		public TerminalNode MIN() { return getToken(ServiceForgeParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(ServiceForgeParser.MAX, 0); }
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitFieldModifier(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldModifier);
		int _la;
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REQUIRED:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(REQUIRED);
				}
				break;
			case UNIQUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(UNIQUE);
				}
				break;
			case PK:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(PK);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(DEFAULT);
				setState(114);
				match(T__1);
				setState(115);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 11544872091648L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				match(MIN);
				setState(117);
				match(T__1);
				setState(118);
				match(NUMBER);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				match(MAX);
				setState(120);
				match(T__1);
				setState(121);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EndpointLineContext extends ParserRuleContext {
		public TerminalNode ENDPOINT() { return getToken(ServiceForgeParser.ENDPOINT, 0); }
		public HttpMethodContext httpMethod() {
			return getRuleContext(HttpMethodContext.class,0);
		}
		public TerminalNode PATH() { return getToken(ServiceForgeParser.PATH, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ServiceForgeParser.EOF, 0); }
		public List<EndpointOptionContext> endpointOption() {
			return getRuleContexts(EndpointOptionContext.class);
		}
		public EndpointOptionContext endpointOption(int i) {
			return getRuleContext(EndpointOptionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public EndpointLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpointLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterEndpointLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitEndpointLine(this);
		}
	}

	public final EndpointLineContext endpointLine() throws RecognitionException {
		EndpointLineContext _localctx = new EndpointLineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_endpointLine);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(ENDPOINT);
			setState(125);
			httpMethod();
			setState(126);
			match(PATH);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179869568L) != 0)) {
				{
				{
				setState(127);
				endpointOption();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__5);
			setState(134);
			returnType();
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(135);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case EOF:
				{
				setState(140);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HttpMethodContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(ServiceForgeParser.GET, 0); }
		public TerminalNode POST() { return getToken(ServiceForgeParser.POST, 0); }
		public TerminalNode PUT() { return getToken(ServiceForgeParser.PUT, 0); }
		public TerminalNode DELETE() { return getToken(ServiceForgeParser.DELETE, 0); }
		public TerminalNode PATCH() { return getToken(ServiceForgeParser.PATCH, 0); }
		public HttpMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_httpMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterHttpMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitHttpMethod(this);
		}
	}

	public final HttpMethodContext httpMethod() throws RecognitionException {
		HttpMethodContext _localctx = new HttpMethodContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_httpMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2031616L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class EndpointOptionContext extends ParserRuleContext {
		public TerminalNode AUTH_TYPE() { return getToken(ServiceForgeParser.AUTH_TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ServiceForgeParser.IDENTIFIER, 0); }
		public TerminalNode PAGINATED() { return getToken(ServiceForgeParser.PAGINATED, 0); }
		public EndpointOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpointOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterEndpointOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitEndpointOption(this);
		}
	}

	public final EndpointOptionContext endpointOption() throws RecognitionException {
		EndpointOptionContext _localctx = new EndpointOptionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_endpointOption);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(T__6);
				setState(146);
				match(T__1);
				setState(147);
				match(AUTH_TYPE);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__7);
				setState(149);
				match(IDENTIFIER);
				}
				break;
			case PAGINATED:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(PAGINATED);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ServiceForgeParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ServiceForgeParser.IDENTIFIER, i);
		}
		public List<ReturnModifierContext> returnModifier() {
			return getRuleContexts(ReturnModifierContext.class);
		}
		public ReturnModifierContext returnModifier(int i) {
			return getRuleContext(ReturnModifierContext.class,i);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(IDENTIFIER);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(154);
				match(T__8);
				setState(155);
				match(IDENTIFIER);
				setState(156);
				match(T__9);
				}
			}

			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7 || _la==PAGINATED) {
				{
				{
				setState(159);
				returnModifier();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnModifierContext extends ParserRuleContext {
		public TerminalNode PAGINATED() { return getToken(ServiceForgeParser.PAGINATED, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ServiceForgeParser.IDENTIFIER, 0); }
		public ReturnModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterReturnModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitReturnModifier(this);
		}
	}

	public final ReturnModifierContext returnModifier() throws RecognitionException {
		ReturnModifierContext _localctx = new ReturnModifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnModifier);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAGINATED:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(PAGINATED);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(T__7);
				setState(167);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationshipLineContext extends ParserRuleContext {
		public TerminalNode RELATIONSHIP() { return getToken(ServiceForgeParser.RELATIONSHIP, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(ServiceForgeParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ServiceForgeParser.IDENTIFIER, i);
		}
		public RelTypeContext relType() {
			return getRuleContext(RelTypeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ServiceForgeParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ServiceForgeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ServiceForgeParser.NEWLINE, i);
		}
		public RelationshipLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationshipLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterRelationshipLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitRelationshipLine(this);
		}
	}

	public final RelationshipLineContext relationshipLine() throws RecognitionException {
		RelationshipLineContext _localctx = new RelationshipLineContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relationshipLine);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(RELATIONSHIP);
			setState(171);
			match(IDENTIFIER);
			setState(172);
			match(T__8);
			setState(173);
			relType();
			setState(174);
			match(IDENTIFIER);
			setState(175);
			match(T__9);
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(177); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(176);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(179); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case EOF:
				{
				setState(181);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelTypeContext extends ParserRuleContext {
		public TerminalNode HAS_MANY() { return getToken(ServiceForgeParser.HAS_MANY, 0); }
		public TerminalNode HAS_ONE() { return getToken(ServiceForgeParser.HAS_ONE, 0); }
		public TerminalNode BELONGS_TO() { return getToken(ServiceForgeParser.BELONGS_TO, 0); }
		public RelTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).enterRelType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ServiceForgeListener ) ((ServiceForgeListener)listener).exitRelType(this);
		}
	}

	public final RelTypeContext relType() throws RecognitionException {
		RelTypeContext _localctx = new RelTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 481036337152L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001/\u00bb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001+\b\u0001\n\u0001\f\u0001"+
		".\t\u0001\u0001\u0001\u0004\u00011\b\u0001\u000b\u0001\f\u00012\u0001"+
		"\u0001\u0005\u00016\b\u0001\n\u0001\f\u00019\t\u0001\u0001\u0001\u0003"+
		"\u0001<\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003I\b\u0003\u000b\u0003\f\u0003J\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003Q\b\u0003\n\u0003\f\u0003T\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"[\b\u0004\n\u0004\f\u0004^\t\u0004\u0001\u0004\u0004\u0004a\b\u0004\u000b"+
		"\u0004\f\u0004b\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005h\b\u0005"+
		"\n\u0005\f\u0005k\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007{\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0081\b\b\n\b\f\b\u0084\t\b\u0001"+
		"\b\u0001\b\u0001\b\u0004\b\u0089\b\b\u000b\b\f\b\u008a\u0001\b\u0003\b"+
		"\u008e\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0098\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u009e\b\u000b\u0001\u000b\u0005\u000b\u00a1\b\u000b\n\u000b\f\u000b"+
		"\u00a4\t\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u00a9\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u00b2\b\r\u000b\r\f"+
		"\r\u00b3\u0001\r\u0003\r\u00b7\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0000\u0000\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u0000\u0004\u0001\u0000\u0015\u001b\u0003\u0000"+
		"\'\'))++\u0001\u0000\u0010\u0014\u0001\u0000$&\u00c9\u0000\"\u0001\u0000"+
		"\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u0004C\u0001\u0000\u0000"+
		"\u0000\u0006E\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nd\u0001"+
		"\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000ez\u0001\u0000\u0000"+
		"\u0000\u0010|\u0001\u0000\u0000\u0000\u0012\u008f\u0001\u0000\u0000\u0000"+
		"\u0014\u0097\u0001\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000"+
		"\u0018\u00a8\u0001\u0000\u0000\u0000\u001a\u00aa\u0001\u0000\u0000\u0000"+
		"\u001c\u00b8\u0001\u0000\u0000\u0000\u001e!\u0003\u0002\u0001\u0000\u001f"+
		"!\u0005-\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 \u001f\u0001\u0000"+
		"\u0000\u0000!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\'(\u0005\u000b"+
		"\u0000\u0000(,\u0005,\u0000\u0000)+\u0003\u0004\u0002\u0000*)\u0001\u0000"+
		"\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-;\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000"+
		"/1\u0005-\u0000\u00000/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000037\u0001\u0000\u0000"+
		"\u000046\u0003\u0006\u0003\u000054\u0001\u0000\u0000\u000069\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008<\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u0000:<\u0005\u0000\u0000\u0001"+
		";0\u0001\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000<\u0003\u0001\u0000"+
		"\u0000\u0000=>\u0005\u0001\u0000\u0000>?\u0005\u0002\u0000\u0000?D\u0005"+
		"(\u0000\u0000@A\u0005\u0003\u0000\u0000AB\u0005\u0002\u0000\u0000BD\u0005"+
		"*\u0000\u0000C=\u0001\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000D\u0005"+
		"\u0001\u0000\u0000\u0000EF\u0005\f\u0000\u0000FH\u0005,\u0000\u0000GI"+
		"\u0005-\u0000\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KR\u0001\u0000\u0000"+
		"\u0000LQ\u0003\b\u0004\u0000MQ\u0003\u0010\b\u0000NQ\u0003\u001a\r\u0000"+
		"OQ\u0005-\u0000\u0000PL\u0001\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\u0007\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005\r\u0000\u0000VW\u0005"+
		"\u0004\u0000\u0000W\\\u0003\n\u0005\u0000XY\u0005\u0005\u0000\u0000Y["+
		"\u0003\n\u0005\u0000ZX\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000_a\u0005-\u0000\u0000`_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000c\t\u0001\u0000\u0000\u0000de\u0005,\u0000\u0000ei\u0003\f"+
		"\u0006\u0000fh\u0003\u000e\u0007\u0000gf\u0001\u0000\u0000\u0000hk\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"j\u000b\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0007\u0000"+
		"\u0000\u0000m\r\u0001\u0000\u0000\u0000n{\u0005\u001c\u0000\u0000o{\u0005"+
		"\u001d\u0000\u0000p{\u0005\u001e\u0000\u0000qr\u0005\u001f\u0000\u0000"+
		"rs\u0005\u0002\u0000\u0000s{\u0007\u0001\u0000\u0000tu\u0005 \u0000\u0000"+
		"uv\u0005\u0002\u0000\u0000v{\u0005)\u0000\u0000wx\u0005!\u0000\u0000x"+
		"y\u0005\u0002\u0000\u0000y{\u0005)\u0000\u0000zn\u0001\u0000\u0000\u0000"+
		"zo\u0001\u0000\u0000\u0000zp\u0001\u0000\u0000\u0000zq\u0001\u0000\u0000"+
		"\u0000zt\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{\u000f\u0001"+
		"\u0000\u0000\u0000|}\u0005\u000e\u0000\u0000}~\u0003\u0012\t\u0000~\u0082"+
		"\u0005*\u0000\u0000\u007f\u0081\u0003\u0014\n\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u0006\u0000\u0000\u0086\u008d\u0003\u0016\u000b\u0000\u0087\u0089\u0005"+
		"-\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008e\u0005\u0000"+
		"\u0000\u0001\u008d\u0088\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u0011\u0001\u0000\u0000\u0000\u008f\u0090\u0007\u0002"+
		"\u0000\u0000\u0090\u0013\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0007"+
		"\u0000\u0000\u0092\u0093\u0005\u0002\u0000\u0000\u0093\u0098\u0005#\u0000"+
		"\u0000\u0094\u0095\u0005\b\u0000\u0000\u0095\u0098\u0005,\u0000\u0000"+
		"\u0096\u0098\u0005\"\u0000\u0000\u0097\u0091\u0001\u0000\u0000\u0000\u0097"+
		"\u0094\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0015\u0001\u0000\u0000\u0000\u0099\u009d\u0005,\u0000\u0000\u009a\u009b"+
		"\u0005\t\u0000\u0000\u009b\u009c\u0005,\u0000\u0000\u009c\u009e\u0005"+
		"\n\u0000\u0000\u009d\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e\u00a2\u0001\u0000\u0000\u0000\u009f\u00a1\u0003\u0018"+
		"\f\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a3\u0017\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a9\u0005\"\u0000\u0000\u00a6\u00a7\u0005\b\u0000\u0000"+
		"\u00a7\u00a9\u0005,\u0000\u0000\u00a8\u00a5\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a9\u0019\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\u000f\u0000\u0000\u00ab\u00ac\u0005,\u0000\u0000\u00ac\u00ad"+
		"\u0005\t\u0000\u0000\u00ad\u00ae\u0003\u001c\u000e\u0000\u00ae\u00af\u0005"+
		",\u0000\u0000\u00af\u00b6\u0005\n\u0000\u0000\u00b0\u00b2\u0005-\u0000"+
		"\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005\u0000\u0000"+
		"\u0001\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u001b\u0001\u0000\u0000\u0000\u00b8\u00b9\u0007\u0003\u0000"+
		"\u0000\u00b9\u001d\u0001\u0000\u0000\u0000\u0017 \",27;CJPR\\biz\u0082"+
		"\u008a\u008d\u0097\u009d\u00a2\u00a8\u00b3\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}