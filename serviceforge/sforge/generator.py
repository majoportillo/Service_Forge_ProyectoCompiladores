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
        # Limpiamos la ruta y concatenamos con la base de la API
        ruta_relativa = ctx.PATH().getText()
        ruta_final = f"{self.base_path}{ruta_relativa}".replace('{', '<').replace('}', '>')
        
        # Creamos una función dummy para cada endpoint
        nombre_func = f"{metodo.lower()}_{ruta_relativa.replace('/', '_').replace('{', '').replace('}', '')}"
        
        seccion_ruta = (
            f"@app.route('{ruta_final}', methods=['{metodo}'])\n"
            f"def {nombre_func}():\n"
            f"    return jsonify({{'message': 'Endpoint {ruta_final} ejecutado con éxito'}})\n"
        )
        self.rutas.append(seccion_ruta)

    def obtener_codigo_completo(self):
        # Unimos todas las partes
        cuerpo = "\n".join(self.rutas)
        footer = "\nif __name__ == '__main__':\n    app.run(debug=True, port=5000)"
        return "\n".join(self.codigo) + "\n" + cuerpo + footer