from antlr4 import *
from output.ValidarIfLexer import ValidarIfLexer
from output.ValidarIfParser import ValidarIfParser
from output.ValidarIfVisitor import ValidarIfVisitor

class AnalizadorSemantico(ValidarIfVisitor):

    def visitSentenciaIf(self, ctx):
        condicion = ctx.expresion().getText()
        print(f"==> [LOG]: Estructura IF detectada correctamente con la condicion: ({condicion})")
        return self.visitChildren(ctx)

    def visitAsignacion(self, ctx):
        var_nombre = ctx.ID().getText()
        print(f"==> [LOG]: Se ha definido la variable '{var_nombre}' en el sistema.")
        return self.visitChildren(ctx)

def ejecutar_analisis():
    print("--- INICIANDO ESCANEO DE SINTAXIS ---")
    
    try:

        input_stream = FileStream("input.txt", encoding='utf-8')
        lexer = ValidarIfLexer(input_stream)
        tokens = CommonTokenStream(lexer)
        parser = ValidarIfParser(tokens)
        arbol_sintactico = parser.prog() 
        analizador = AnalizadorSemantico()
        analizador.visit(arbol_sintactico)
        
        print("--- ANALISIS FINALIZADO CON EXITO ---")

    except Exception as e:
        print(f"Error durante el proceso: {e}")

if __name__ == '__main__':
    ejecutar_analisis()