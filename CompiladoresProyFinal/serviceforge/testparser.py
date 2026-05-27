
from .parser import parse_file, parse_string

EJEMPLO_USERS = """\
api Users version=1.0 base=/api/v1
  resource User
    fields: id int pk, name string required, correo string unique, created_at datetime
    endpoint GET /users -> list(User) paginated
    endpoint POST /users -> create(User) with validation
    endpoint GET /users/{id} auth=jwt -> detail(User)
    relationship posts (has_many Post)
"""

def main():
    print("=" * 60)
    print("  ServiceForge — Prueba del Parser")
    print("=" * 60)

    # Prueba 1: desde string
    print("\n[1] Parseando ejemplo Users (desde string)...")
    tree, parser, errors = parse_string(EJEMPLO_USERS)

    if errors:
        print("Errores:")
        for e in errors:
            print(f"   {e}")
    else:
        print("Sin errores. Árbol generado:\n")
        print(tree.toStringTree(recog=parser))
        

    # ── Prueba 2
    import os
    svc_path = os.path.join(os.path.dirname(__file__), "..", "prueba.svc")
    svc_path = os.path.normpath(svc_path)

    if os.path.exists(svc_path):
        print(f"\n[2] Parseando archivo: {svc_path}")
        tree2, parser2, errors2 = parse_file(svc_path)

        if errors2:
            print("Errores en el archivo:")
            for e in errors2:
                print(f"   {e}")
        else:
            print("Archivo válido. Árbol:\n")
            print(tree2.toStringTree(recog=parser2))
    else:
        print(f"\n[2] Archivo {svc_path} no encontrado, se omite prueba de archivo.")

    print("\n" + "=" * 60)


if __name__ == "__main__":
    main()