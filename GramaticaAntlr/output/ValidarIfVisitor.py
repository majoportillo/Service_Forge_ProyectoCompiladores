# Generated from c:/Users/HP BLUE/Desktop/Tareas/GramaticaAntlr/ValidarIf.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .ValidarIfParser import ValidarIfParser
else:
    from ValidarIfParser import ValidarIfParser

# This class defines a complete generic visitor for a parse tree produced by ValidarIfParser.

class ValidarIfVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ValidarIfParser#prog.
    def visitProg(self, ctx:ValidarIfParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#SentenciaIf.
    def visitSentenciaIf(self, ctx:ValidarIfParser.SentenciaIfContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#Asignacion.
    def visitAsignacion(self, ctx:ValidarIfParser.AsignacionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#BloqueMultiple.
    def visitBloqueMultiple(self, ctx:ValidarIfParser.BloqueMultipleContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#BloqueUnico.
    def visitBloqueUnico(self, ctx:ValidarIfParser.BloqueUnicoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#Numero.
    def visitNumero(self, ctx:ValidarIfParser.NumeroContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#Comparacion.
    def visitComparacion(self, ctx:ValidarIfParser.ComparacionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ValidarIfParser#Variable.
    def visitVariable(self, ctx:ValidarIfParser.VariableContext):
        return self.visitChildren(ctx)



del ValidarIfParser