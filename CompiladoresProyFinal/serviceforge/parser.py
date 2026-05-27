
import sys
from antlr4 import CommonTokenStream, FileStream, InputStream
from serviceforge.grammar.output.ServiceForgeLexer import ServiceForgeLexer
from serviceforge.grammar.output.ServiceForgeParser import ServiceForgeParser
from antlr4.error.ErrorListener import ErrorListener

class ServiceForgeErrorListener(ErrorListener):
    """Captura errores sintácticos y los acumula en una lista."""

    def __init__(self):
        super().__init__()
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.errors.append(f"Línea {line}:{column} — {msg}")


def parse_file(path: str):
    
    # 1. Leer el archivo fuente
    input_stream = FileStream(path, encoding="utf-8")

    # 2. Análisis léxico
    lexer = ServiceForgeLexer(input_stream)
    lexer.removeErrorListeners()                     
    lexer_errors = ServiceForgeErrorListener()
    lexer.addErrorListener(lexer_errors)

    token_stream = CommonTokenStream(lexer)

    # 3. Análisis sintáctico
    parser = ServiceForgeParser(token_stream)
    parser.removeErrorListeners()                     
    parser_errors = ServiceForgeErrorListener()
    parser.addErrorListener(parser_errors)

    # 4. Generar árbol desde la regla raíz
    tree = parser.program()

    # 5. Combinar errores léxicos + sintácticos
    all_errors = lexer_errors.errors + parser_errors.errors

    return tree, parser, all_errors


def parse_string(source: str):
    
    input_stream = InputStream(source)

    lexer = ServiceForgeLexer(input_stream)
    lexer.removeErrorListeners()
    lexer_errors = ServiceForgeErrorListener()
    lexer.addErrorListener(lexer_errors)

    token_stream = CommonTokenStream(lexer)

    parser = ServiceForgeParser(token_stream)
    parser.removeErrorListeners()
    parser_errors = ServiceForgeErrorListener()
    parser.addErrorListener(parser_errors)

    tree = parser.program()
    all_errors = lexer_errors.errors + parser_errors.errors

    return tree, parser, all_errors



    if len(sys.argv) < 2:
        print("Uso: python parser.py <archivo.svc>")
        sys.exit(1)

    svc_path = sys.argv[1]
    tree, parser, errors = parse_file(svc_path)

    if errors:
        print(" Errores encontrados:")
        for err in errors:
            print(f"   {err}")
        sys.exit(1)
    else:
        print("Archivo válido. Árbol sintáctico:")
        print(tree.toStringTree(recog=parser))