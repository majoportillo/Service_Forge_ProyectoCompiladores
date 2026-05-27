import os
from serviceforge.grammar.output.ServiceForgeListener import ServiceForgeListener
from serviceforge.grammar.output.ServiceForgeParser import ServiceForgeParser

class GeneradorFlask(ServiceForgeListener):
    def __init__(self, nombre_api, base_path):
        self.nombre_api = nombre_api
        self.base_path = base_path.strip('"')
        self.rutas = []
        # Plantilla base para el servidor Flask
        self.codigo = [
            "from flask import Flask, jsonify, request",
            f"app = Flask('{nombre_api}')",
            ""
        ]

    def enterEndpointLine(self, ctx: ServiceForgeParser.EndpointLineContext):
        metodo = ctx.httpMethod().getText()
        ruta_relativa = ctx.PATH().getText()
        ruta_final = f"{self.base_path}{ruta_relativa}".replace('{', '<').replace('}', '>')
        
        nombre_func = f"{metodo.lower()}_{ruta_relativa.replace('/', '_').replace('{', '').replace('}', '')}"
        
        seccion_ruta = (
            f"@app.route('{ruta_final}', methods=['{metodo}'])\n"
            f"def {nombre_func}():\n"
            f"    return jsonify({{'message': 'Endpoint {ruta_final} ejecutado con exito'}}), 200\n"
        )
        self.rutas.append(seccion_ruta)

    def obtener_codigo_completo(self, output_dir="."):
        #INYECCIÓN EXTRA DE DOCKER PARA FLASK
        try:
            os.makedirs(output_dir, exist_ok=True)
            # 1. Dockerfile
            with open(os.path.join(output_dir, "Dockerfile"), "w", encoding="utf-8") as f:
                f.write("FROM python:3.11-slim\nWORKDIR /app\nCOPY requirements.txt .\nRUN pip install --no-cache-dir -r requirements.txt\nCOPY . .\nEXPOSE 5000\nCMD [\"python\", \"app.py\"]\n")
            # 2. requirements.txt
            with open(os.path.join(output_dir, "requirements.txt"), "w", encoding="utf-8") as f:
                f.write("flask==3.1.3\nblinker>=1.9.0\nitsdangerous>=2.2.0\nwerkzeug>=3.1.0\n")
            # 3. docker-compose.yml
            with open(os.path.join(output_dir, "docker-compose.yml"), "w", encoding="utf-8") as f:
                f.write(f"version: '3.8'\nservices:\n  {self.nombre_api.lower()}:\n    build: .\n    ports:\n      - \"5000:5000\"\n")
            print("¡Entorno Docker para Flask generado con éxito!")
        except Exception:
            pass

        cuerpo = "\n".join(self.rutas)
        footer = "\nif __name__ == '__main__':\n    app.run(debug=True, port=5000)"
        return "\n".join(self.codigo) + "\n" + cuerpo + footer
    

class GeneradorNode(ServiceForgeListener):
    def __init__(self, nombre_api, base_path):
        self.nombre_api = nombre_api
        self.base_path = base_path
        self.codigo = []
        self.codigo.append("const express = require('express');")
        self.codigo.append("const app = express();")
        self.codigo.append("app.use(express.json());\n")

    def enterEndpointLine(self, ctx):
        metodo = ctx.httpMethod().getText().lower()
        ruta = ctx.PATH().getText()
        ruta_express = ruta.replace('{', ':').replace('}', '')
        ruta_completa = f"{self.base_path}{ruta_express}".replace('//', '/')
        
        self.codigo.append(f"app.{metodo}('{ruta_completa}', (req, res) => {{")
        self.codigo.append(f"    res.status(200).json({{ message: 'Endpoint {ruta_completa} ejecutado con éxito' }});")
        self.codigo.append("});\n")

    def obtener_codigo_completo(self, output_dir="."):
        # INYECCIÓN EXTRA DE DOCKER PARA NODE
        try:
            os.makedirs(output_dir, exist_ok=True)
            # 1. Dockerfile
            with open(os.path.join(output_dir, "Dockerfile"), "w", encoding="utf-8") as f:
                f.write("FROM node:18-slim\nWORKDIR /app\nCOPY package.json .\nRUN npm install\nCOPY . .\nEXPOSE 3000\nCMD [\"node\", \"server.js\"]\n")
            # 2. package.json básico
            with open(os.path.join(output_dir, "package.json"), "w", encoding="utf-8") as f:
                f.write(f'{{\n  "name": "{self.nombre_api.lower()}",\n  "version": "1.0.0",\n  "main": "server.js",\n  "dependencies": {{\n    "express": "^4.19.2"\n  }}\n}}')
            # 3. docker-compose.yml
            with open(os.path.join(output_dir, "docker-compose.yml"), "w", encoding="utf-8") as f:
                f.write(f"version: '3.8'\nservices:\n  {self.nombre_api.lower()}:\n    build: .\n    ports:\n      - \"3000:3000\"\n")
            print("💡 [EXTRA WOW] ¡Entorno Docker para Node/Express generado con éxito!")
        except Exception:
            pass

        self.codigo.append(f"app.listen(3000, () => {{")
        self.codigo.append(f"    console.log('Servidor {self.nombre_api} corriendo en http://localhost:3000');")
        self.codigo.append(f"}});")
        return "\n".join(self.codigo)