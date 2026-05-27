# Generated from c:/Users/Usuario/Desktop/Service_Forge_ProyectoCompiladores/serviceforge/grammar/ServiceForge.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .ServiceForgeParser import ServiceForgeParser
else:
    from ServiceForgeParser import ServiceForgeParser

# This class defines a complete generic visitor for a parse tree produced by ServiceForgeParser.

class ServiceForgeVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by ServiceForgeParser#program.
    def visitProgram(self, ctx:ServiceForgeParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#apiBlock.
    def visitApiBlock(self, ctx:ServiceForgeParser.ApiBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#apiOption.
    def visitApiOption(self, ctx:ServiceForgeParser.ApiOptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#resourceBlock.
    def visitResourceBlock(self, ctx:ServiceForgeParser.ResourceBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#fieldsLine.
    def visitFieldsLine(self, ctx:ServiceForgeParser.FieldsLineContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#fieldDef.
    def visitFieldDef(self, ctx:ServiceForgeParser.FieldDefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#dataType.
    def visitDataType(self, ctx:ServiceForgeParser.DataTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#fieldModifier.
    def visitFieldModifier(self, ctx:ServiceForgeParser.FieldModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#endpointLine.
    def visitEndpointLine(self, ctx:ServiceForgeParser.EndpointLineContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#httpMethod.
    def visitHttpMethod(self, ctx:ServiceForgeParser.HttpMethodContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#endpointOption.
    def visitEndpointOption(self, ctx:ServiceForgeParser.EndpointOptionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#returnType.
    def visitReturnType(self, ctx:ServiceForgeParser.ReturnTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#returnModifier.
    def visitReturnModifier(self, ctx:ServiceForgeParser.ReturnModifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#relationshipLine.
    def visitRelationshipLine(self, ctx:ServiceForgeParser.RelationshipLineContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ServiceForgeParser#relType.
    def visitRelType(self, ctx:ServiceForgeParser.RelTypeContext):
        return self.visitChildren(ctx)



del ServiceForgeParser