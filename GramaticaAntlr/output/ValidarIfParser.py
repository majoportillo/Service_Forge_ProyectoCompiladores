# Generated from c:/Users/HP BLUE/Desktop/Tareas/GramaticaAntlr/ValidarIf.g4 by ANTLR 4.13.1
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,16,62,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,1,0,4,0,10,8,0,11,0,12,
        0,11,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,3,1,22,8,1,1,1,1,1,1,1,3,1,
        27,8,1,3,1,29,8,1,1,1,1,1,1,1,1,1,1,1,3,1,36,8,1,1,2,1,2,5,2,40,
        8,2,10,2,12,2,43,9,2,1,2,1,2,3,2,47,8,2,1,3,1,3,1,3,3,3,52,8,3,1,
        3,1,3,1,3,5,3,57,8,3,10,3,12,3,60,9,3,1,3,0,1,6,4,0,2,4,6,0,1,2,
        0,3,4,11,11,66,0,9,1,0,0,0,2,35,1,0,0,0,4,46,1,0,0,0,6,51,1,0,0,
        0,8,10,3,2,1,0,9,8,1,0,0,0,10,11,1,0,0,0,11,9,1,0,0,0,11,12,1,0,
        0,0,12,13,1,0,0,0,13,14,5,0,0,1,14,1,1,0,0,0,15,16,5,5,0,0,16,17,
        5,1,0,0,17,18,3,6,3,0,18,21,5,2,0,0,19,22,3,4,2,0,20,22,3,2,1,0,
        21,19,1,0,0,0,21,20,1,0,0,0,22,28,1,0,0,0,23,26,5,6,0,0,24,27,3,
        4,2,0,25,27,3,2,1,0,26,24,1,0,0,0,26,25,1,0,0,0,27,29,1,0,0,0,28,
        23,1,0,0,0,28,29,1,0,0,0,29,36,1,0,0,0,30,31,5,12,0,0,31,32,5,7,
        0,0,32,33,3,6,3,0,33,34,5,8,0,0,34,36,1,0,0,0,35,15,1,0,0,0,35,30,
        1,0,0,0,36,3,1,0,0,0,37,41,5,9,0,0,38,40,3,2,1,0,39,38,1,0,0,0,40,
        43,1,0,0,0,41,39,1,0,0,0,41,42,1,0,0,0,42,44,1,0,0,0,43,41,1,0,0,
        0,44,47,5,10,0,0,45,47,3,2,1,0,46,37,1,0,0,0,46,45,1,0,0,0,47,5,
        1,0,0,0,48,49,6,3,-1,0,49,52,5,12,0,0,50,52,5,13,0,0,51,48,1,0,0,
        0,51,50,1,0,0,0,52,58,1,0,0,0,53,54,10,1,0,0,54,55,7,0,0,0,55,57,
        3,6,3,2,56,53,1,0,0,0,57,60,1,0,0,0,58,56,1,0,0,0,58,59,1,0,0,0,
        59,7,1,0,0,0,60,58,1,0,0,0,9,11,21,26,28,35,41,46,51,58
    ]

class ValidarIfParser ( Parser ):

    grammarFileName = "ValidarIf.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'('", "')'", "'&&'", "'||'", "'if'", 
                     "'else'", "'='", "';'", "'{'", "'}'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "IF", "ELSE", "IGUAL", "PYC", "L_LLAVE", 
                      "R_LLAVE", "OPERADOR", "ID", "INT", "WS", "COMENTARIO", 
                      "MULTILINEA" ]

    RULE_prog = 0
    RULE_instruccion = 1
    RULE_cuerpoIf = 2
    RULE_expresion = 3

    ruleNames =  [ "prog", "instruccion", "cuerpoIf", "expresion" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    IF=5
    ELSE=6
    IGUAL=7
    PYC=8
    L_LLAVE=9
    R_LLAVE=10
    OPERADOR=11
    ID=12
    INT=13
    WS=14
    COMENTARIO=15
    MULTILINEA=16

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class ProgContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EOF(self):
            return self.getToken(ValidarIfParser.EOF, 0)

        def instruccion(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ValidarIfParser.InstruccionContext)
            else:
                return self.getTypedRuleContext(ValidarIfParser.InstruccionContext,i)


        def getRuleIndex(self):
            return ValidarIfParser.RULE_prog

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterProg" ):
                listener.enterProg(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitProg" ):
                listener.exitProg(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitProg" ):
                return visitor.visitProg(self)
            else:
                return visitor.visitChildren(self)




    def prog(self):

        localctx = ValidarIfParser.ProgContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_prog)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 9 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 8
                self.instruccion()
                self.state = 11 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==5 or _la==12):
                    break

            self.state = 13
            self.match(ValidarIfParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class InstruccionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return ValidarIfParser.RULE_instruccion

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class AsignacionContext(InstruccionContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.InstruccionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(ValidarIfParser.ID, 0)
        def IGUAL(self):
            return self.getToken(ValidarIfParser.IGUAL, 0)
        def expresion(self):
            return self.getTypedRuleContext(ValidarIfParser.ExpresionContext,0)

        def PYC(self):
            return self.getToken(ValidarIfParser.PYC, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAsignacion" ):
                listener.enterAsignacion(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAsignacion" ):
                listener.exitAsignacion(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAsignacion" ):
                return visitor.visitAsignacion(self)
            else:
                return visitor.visitChildren(self)


    class SentenciaIfContext(InstruccionContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.InstruccionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def IF(self):
            return self.getToken(ValidarIfParser.IF, 0)
        def expresion(self):
            return self.getTypedRuleContext(ValidarIfParser.ExpresionContext,0)

        def cuerpoIf(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ValidarIfParser.CuerpoIfContext)
            else:
                return self.getTypedRuleContext(ValidarIfParser.CuerpoIfContext,i)

        def instruccion(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ValidarIfParser.InstruccionContext)
            else:
                return self.getTypedRuleContext(ValidarIfParser.InstruccionContext,i)

        def ELSE(self):
            return self.getToken(ValidarIfParser.ELSE, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSentenciaIf" ):
                listener.enterSentenciaIf(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSentenciaIf" ):
                listener.exitSentenciaIf(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitSentenciaIf" ):
                return visitor.visitSentenciaIf(self)
            else:
                return visitor.visitChildren(self)



    def instruccion(self):

        localctx = ValidarIfParser.InstruccionContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_instruccion)
        try:
            self.state = 35
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [5]:
                localctx = ValidarIfParser.SentenciaIfContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 15
                self.match(ValidarIfParser.IF)
                self.state = 16
                self.match(ValidarIfParser.T__0)
                self.state = 17
                self.expresion(0)
                self.state = 18
                self.match(ValidarIfParser.T__1)
                self.state = 21
                self._errHandler.sync(self)
                la_ = self._interp.adaptivePredict(self._input,1,self._ctx)
                if la_ == 1:
                    self.state = 19
                    self.cuerpoIf()
                    pass

                elif la_ == 2:
                    self.state = 20
                    self.instruccion()
                    pass


                self.state = 28
                self._errHandler.sync(self)
                la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
                if la_ == 1:
                    self.state = 23
                    self.match(ValidarIfParser.ELSE)
                    self.state = 26
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,2,self._ctx)
                    if la_ == 1:
                        self.state = 24
                        self.cuerpoIf()
                        pass

                    elif la_ == 2:
                        self.state = 25
                        self.instruccion()
                        pass




                pass
            elif token in [12]:
                localctx = ValidarIfParser.AsignacionContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 30
                self.match(ValidarIfParser.ID)
                self.state = 31
                self.match(ValidarIfParser.IGUAL)
                self.state = 32
                self.expresion(0)
                self.state = 33
                self.match(ValidarIfParser.PYC)
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class CuerpoIfContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return ValidarIfParser.RULE_cuerpoIf

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class BloqueUnicoContext(CuerpoIfContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.CuerpoIfContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def instruccion(self):
            return self.getTypedRuleContext(ValidarIfParser.InstruccionContext,0)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBloqueUnico" ):
                listener.enterBloqueUnico(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBloqueUnico" ):
                listener.exitBloqueUnico(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitBloqueUnico" ):
                return visitor.visitBloqueUnico(self)
            else:
                return visitor.visitChildren(self)


    class BloqueMultipleContext(CuerpoIfContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.CuerpoIfContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def L_LLAVE(self):
            return self.getToken(ValidarIfParser.L_LLAVE, 0)
        def R_LLAVE(self):
            return self.getToken(ValidarIfParser.R_LLAVE, 0)
        def instruccion(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ValidarIfParser.InstruccionContext)
            else:
                return self.getTypedRuleContext(ValidarIfParser.InstruccionContext,i)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterBloqueMultiple" ):
                listener.enterBloqueMultiple(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitBloqueMultiple" ):
                listener.exitBloqueMultiple(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitBloqueMultiple" ):
                return visitor.visitBloqueMultiple(self)
            else:
                return visitor.visitChildren(self)



    def cuerpoIf(self):

        localctx = ValidarIfParser.CuerpoIfContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_cuerpoIf)
        self._la = 0 # Token type
        try:
            self.state = 46
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [9]:
                localctx = ValidarIfParser.BloqueMultipleContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 37
                self.match(ValidarIfParser.L_LLAVE)
                self.state = 41
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                while _la==5 or _la==12:
                    self.state = 38
                    self.instruccion()
                    self.state = 43
                    self._errHandler.sync(self)
                    _la = self._input.LA(1)

                self.state = 44
                self.match(ValidarIfParser.R_LLAVE)
                pass
            elif token in [5, 12]:
                localctx = ValidarIfParser.BloqueUnicoContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 45
                self.instruccion()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ExpresionContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return ValidarIfParser.RULE_expresion

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)


    class NumeroContext(ExpresionContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.ExpresionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def INT(self):
            return self.getToken(ValidarIfParser.INT, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNumero" ):
                listener.enterNumero(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNumero" ):
                listener.exitNumero(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitNumero" ):
                return visitor.visitNumero(self)
            else:
                return visitor.visitChildren(self)


    class ComparacionContext(ExpresionContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.ExpresionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def expresion(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(ValidarIfParser.ExpresionContext)
            else:
                return self.getTypedRuleContext(ValidarIfParser.ExpresionContext,i)

        def OPERADOR(self):
            return self.getToken(ValidarIfParser.OPERADOR, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterComparacion" ):
                listener.enterComparacion(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitComparacion" ):
                listener.exitComparacion(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitComparacion" ):
                return visitor.visitComparacion(self)
            else:
                return visitor.visitChildren(self)


    class VariableContext(ExpresionContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a ValidarIfParser.ExpresionContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(ValidarIfParser.ID, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterVariable" ):
                listener.enterVariable(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitVariable" ):
                listener.exitVariable(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitVariable" ):
                return visitor.visitVariable(self)
            else:
                return visitor.visitChildren(self)



    def expresion(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = ValidarIfParser.ExpresionContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 6
        self.enterRecursionRule(localctx, 6, self.RULE_expresion, _p)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 51
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [12]:
                localctx = ValidarIfParser.VariableContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx

                self.state = 49
                self.match(ValidarIfParser.ID)
                pass
            elif token in [13]:
                localctx = ValidarIfParser.NumeroContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 50
                self.match(ValidarIfParser.INT)
                pass
            else:
                raise NoViableAltException(self)

            self._ctx.stop = self._input.LT(-1)
            self.state = 58
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,8,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    localctx = ValidarIfParser.ComparacionContext(self, ValidarIfParser.ExpresionContext(self, _parentctx, _parentState))
                    self.pushNewRecursionContext(localctx, _startState, self.RULE_expresion)
                    self.state = 53
                    if not self.precpred(self._ctx, 1):
                        from antlr4.error.Errors import FailedPredicateException
                        raise FailedPredicateException(self, "self.precpred(self._ctx, 1)")
                    self.state = 54
                    _la = self._input.LA(1)
                    if not((((_la) & ~0x3f) == 0 and ((1 << _la) & 2072) != 0)):
                        self._errHandler.recoverInline(self)
                    else:
                        self._errHandler.reportMatch(self)
                        self.consume()
                    self.state = 55
                    self.expresion(2) 
                self.state = 60
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,8,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx



    def sempred(self, localctx:RuleContext, ruleIndex:int, predIndex:int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[3] = self.expresion_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def expresion_sempred(self, localctx:ExpresionContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 1)
         




