import sys
import os

sys.path.insert(0, os.path.join(os.path.dirname(__file__), '..', 'grammar'))

from antlr4 import InputStream, CommonTokenStream
from ServiceForgeLexer import ServiceForgeLexer


TOKENS = {
    1: "version", 2: "=", 3: "base", 4: ":", 5: ",", 6: "->",
    7: "auth", 8: "with", 9: "(", 10: ")", 11: "API", 12: "RESOURCE",
    13: "FIELDS", 14: "ENDPOINT", 15: "RELATIONSHIP", 16: "GET",
    17: "POST", 18: "PUT", 19: "DELETE", 20: "PATCH", 21: "INT",
    22: "STRING", 23: "EMAIL", 24: "BOOLEAN", 25: "DATETIME",
    26: "DECIMAL", 27: "UUID", 28: "REQUIRED", 29: "UNIQUE", 30: "PK",
    31: "DEFAULT", 32: "MIN", 33: "MAX", 34: "PAGINATED",
    35: "AUTH_TYPE", 36: "HAS_MANY", 37: "HAS_ONE", 38: "BELONGS_TO",
    39: "BOOLEAN_LIT", 40: "VERSION_NUMBER", 41: "NUMBER", 42: "PATH",
    43: "STRING_LITERAL", 44: "IDENTIFIER", 45: "NEWLINE",
    46: "WS", 47: "COMMENT"
}

IGNORAR = {-1, 45, 46, 47}


def analizar_lexico(ruta):
    """
    Recibe un archivo .svc y devuelve la lista de tokens reconocidos.
    """

    with open(ruta, "r", encoding="utf-8") as archivo:
        texto = archivo.read()

    stream = InputStream(texto)
    lexer = ServiceForgeLexer(stream)
    token_stream = CommonTokenStream(lexer)
    token_stream.fill()

    tokens_validos = []

    for token in token_stream.tokens:
        if token.type in IGNORAR:
            continue

        tokens_validos.append({
            "linea": token.line,
            "columna": token.column,
            "tipo": TOKENS.get(token.type, f"DESCONOCIDO({token.type})"),
            "valor": token.text
        })

    return tokens_validos


def imprimir_analisis_lexico(ruta):
    tokens = analizar_lexico(ruta)

    print("\n" + "=" * 60)
    print("        ANÁLISIS LÉXICO - ServiceForge")
    print("=" * 60)
    print(f"  Archivo: {ruta}\n")

    print(f"  {'LÍNEA':<6} {'COLUMNA':<8} {'TOKEN':<20} {'VALOR'}")
    print("  " + "-" * 55)

    for token in tokens:
        print(
            f"  {token['linea']:<6} "
            f"{token['columna']:<8} "
            f"{token['tipo']:<20} "
            f"{repr(token['valor'])}"
        )

    print("  " + "-" * 55)
    print(f"\n  Total tokens: {len(tokens)}")
    print("=" * 60)

    return tokens


if __name__ == "__main__":
    archivo = sys.argv[1] if len(sys.argv) > 1 else os.path.join("grammar", "prueba.svc")
    imprimir_analisis_lexico(archivo)