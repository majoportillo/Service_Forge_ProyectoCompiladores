from grammar.ServiceForgeParser import ServiceForgeParser
from grammar.ServiceForgeListener import ServiceForgeListener

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

    def obtener_codigo_completo(self):
        
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
        # En Node.js (Express), las variables de ruta usan ':' en lugar de '{}' (ej: /users/:id)
        ruta_express = ruta.replace('{', ':').replace('}', '')
        ruta_completa = f"{self.base_path}{ruta_express}".replace('//', '/')
        
        self.codigo.append(f"app.{metodo}('{ruta_completa}', (req, res) => {{")
        self.codigo.append(f"    res.status(200).json({{ message: 'Endpoint {ruta_completa} ejecutado con éxito' }});")
        self.codigo.append("});\n")

    def obtener_codigo_completo(self):
        self.codigo.append(f"app.listen(3000, () => {{")
        self.codigo.append(f"    console.log('Servidor {self.nombre_api} corriendo en http://localhost:3000');")
        self.codigo.append(f"}});")
        return "\n".join(self.codigo)