import sys, os
sys.path.insert(0, os.path.dirname(__file__))

from sforge.lexico     import analizar_lexico
from sforge.sintactico import analizar_sintactico

def main():
    archivo = sys.argv[1] if len(sys.argv) > 1 else os.path.join('grammar', 'prueba.svc')

    if not os.path.exists(archivo):
        print(f"Archivo no encontrado: {archivo}")
        sys.exit(1)

    analizar_lexico(archivo)
    arbol, errores = analizar_sintactico(archivo)

    print("\n" + "="*60)
    print("  RESUMEN FINAL")
    print("="*60)
    if not errores:
        print("  El archivo .svc pasó léxico y sintáctico correctamente")
    else:
        print(f"  {len(errores)} error(es) encontrado(s)")
    print("="*60 + "\n")


if __name__ == "__main__":
    main()