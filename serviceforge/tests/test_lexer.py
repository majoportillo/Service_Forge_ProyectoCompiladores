import os
import tempfile

from sforge.lexer import analizar_lexico


def crear_archivo_temporal(contenido):
    archivo = tempfile.NamedTemporaryFile(
        delete=False,
        suffix=".svc",
        mode="w",
        encoding="utf-8"
    )
    archivo.write(contenido)
    archivo.close()
    return archivo.name


def obtener_tipos(tokens):
    return [token["tipo"] for token in tokens]


def obtener_valores(tokens):
    return [token["valor"] for token in tokens]


def test_reconoce_api():
    ruta = crear_archivo_temporal("api Users version=1.0 base=/api/v1")

    tokens = analizar_lexico(ruta)
    tipos = obtener_tipos(tokens)
    valores = obtener_valores(tokens)

    assert "API" in tipos
    assert "IDENTIFIER" in tipos
    assert "VERSION_NUMBER" in tipos
    assert "PATH" in tipos
    assert "api" in valores
    assert "Users" in valores

    os.remove(ruta)


def test_reconoce_resource():
    ruta = crear_archivo_temporal("resource User")

    tokens = analizar_lexico(ruta)
    tipos = obtener_tipos(tokens)

    assert "RESOURCE" in tipos
    assert "IDENTIFIER" in tipos

    os.remove(ruta)


def test_reconoce_fields():
    contenido = "fields: id int pk, name string required, correo string unique"
    ruta = crear_archivo_temporal(contenido)

    tokens = analizar_lexico(ruta)
    tipos = obtener_tipos(tokens)

    assert "FIELDS" in tipos
    assert "INT" in tipos
    assert "STRING" in tipos
    assert "PK" in tipos
    assert "REQUIRED" in tipos
    assert "UNIQUE" in tipos

    os.remove(ruta)


def test_reconoce_endpoint_paginated():
    contenido = "endpoint GET /users -> list(User) paginated"
    ruta = crear_archivo_temporal(contenido)

    tokens = analizar_lexico(ruta)
    tipos = obtener_tipos(tokens)
    valores = obtener_valores(tokens)

    assert "ENDPOINT" in tipos
    assert "GET" in tipos
    assert "PATH" in tipos
    assert "PAGINATED" in tipos
    assert "->" in valores

    os.remove(ruta)


def test_reconoce_auth_jwt():
    contenido = "endpoint GET /users/{id} auth=jwt -> detail(User)"
    ruta = crear_archivo_temporal(contenido)

    tokens = analizar_lexico(ruta)
    tipos = obtener_tipos(tokens)
    valores = obtener_valores(tokens)

    assert "ENDPOINT" in tipos
    assert "GET" in tipos
    assert "AUTH_TYPE" in tipos
    assert "auth" in valores
    assert "jwt" in valores

    os.remove(ruta)