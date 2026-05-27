import sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'grammar'))

from antlr4 import InputStream, CommonTokenStream
from serviceforge.grammar.output.ServiceForgeLexer import ServiceForgeLexer

TOKENS = {
    1:"version", 2:"=", 3:"base", 4:":", 5:",", 6:"->",
    7:"auth", 8:"with", 9:"(", 10:")", 11:"API", 12:"RESOURCE",
    13:"FIELDS", 14:"ENDPOINT", 15:"RELATIONSHIP", 16:"GET",
    17:"POST", 18:"PUT", 19:"DELETE", 20:"PATCH", 21:"INT",
    22:"STRING", 23:"EMAIL", 24:"BOOLEAN", 25:"DATETIME",
    26:"DECIMAL", 27:"UUID", 28:"REQUIRED", 29:"UNIQUE", 30:"PK",
    31:"DEFAULT", 32:"MIN", 33:"MAX", 34:"PAGINATED",
    35:"AUTH_TYPE", 36:"HAS_MANY", 37:"HAS_ONE", 38:"BELONGS_TO",
    39:"BOOLEAN_LIT", 40:"VERSION_NUMBER", 41:"NUMBER", 42:"PATH",
    43:"STRING_LITERAL", 44:"IDENTIFIER", 45:"NEWLINE",
    46:"WS", 47:"COMMENT"
}

def analizar_lexico(ruta):
    print("\n" + "="*60)
    print("        ANÁLISIS LÉXICO - ServiceForge")
    print("="*60)
    print(f"  Archivo: {ruta}\n")

    with open(ruta, 'r') as f:
        texto = f.read()

    stream   = InputStream(texto)
    lexer    = ServiceForgeLexer(stream)
    tokens   = CommonTokenStream(lexer)
    tokens.fill()

    print(f"  {'LÍNEA':<6} {'TOKEN':<20} {'VALOR'}")
    print("  " + "-"*50)

    errores = 0
    validos = 0

    for t in tokens.tokens:
        if t.type in [-1, 45, 46]:   # EOF, NEWLINE, WS 
            continue
        nombre = TOKENS.get(t.type, f"??({t.type})")
        print(f"  {t.line:<6} {nombre:<20} {repr(t.text)}")
        validos += 1

    print("  " + "-"*50)
    print(f"\n  Total tokens: {validos}")
    print(f"  Errores léxicos: {errores}")
    print("="*60)

    return tokens.tokens