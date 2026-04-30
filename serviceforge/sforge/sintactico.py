import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'grammar'))

from antlr4 import InputStream, CommonTokenStream, TerminalNode
from antlr4.error.ErrorListener import ErrorListener
from ServiceForgeLexer  import ServiceForgeLexer
from ServiceForgeParser import ServiceForgeParser

class MiColectorErrores(ErrorListener):
    def __init__(self):
        super().__init__()
        self.errores = []

    def syntaxError(self, recognizer, symbol, line, col, msg, e):
        self.errores.append(f"Línea {line}, col {col}: {msg}")

def imprimir_arbol(nodo, reglas, nivel=0):
    sangria = "  " * nivel
    if isinstance(nodo, TerminalNode):
        texto = nodo.getText()
        if texto not in ['\n', '\r\n', '<EOF>']:
            print(f"{sangria}  '{texto}'")
    else:
        nombre = reglas[nodo.getRuleIndex()]
        print(f"{sangria} [{nombre}]")
        for hijo in nodo.getChildren():
            imprimir_arbol(hijo, reglas, nivel + 1)

def analizar_sintactico(ruta):
    print("\n" + "="*60)
    print("      ANÁLISIS SINTÁCTICO - ServiceForge")
    print("="*60)
    print(f"  Archivo: {ruta}\n")

    with open(ruta, 'r') as f:
        texto = f.read()

    stream  = InputStream(texto)
    lexer   = ServiceForgeLexer(stream)
    tokens  = CommonTokenStream(lexer)
    parser  = ServiceForgeParser(tokens)

    colector = MiColectorErrores()
    parser.removeErrorListeners()
    parser.addErrorListener(colector)

    arbol = parser.program()

    if colector.errores:
        print("  ERRORES SINTÁCTICOS:")
        for e in colector.errores:
            print(f"     {e}")
    else:
        print("  Sin errores sintácticos\n")
        print("  ÁRBOL DE PARSEO:")
        print("  " + "-"*50)
        imprimir_arbol(arbol, ServiceForgeParser.ruleNames)

    print("="*60)
    return arbol, colector.errores