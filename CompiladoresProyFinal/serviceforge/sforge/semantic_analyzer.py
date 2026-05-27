from serviceforge.grammar.output.ServiceForgeParser import ServiceForgeParser
from serviceforge.grammar.output.ServiceForgeListener import ServiceForgeListener

class AnalizadorSemantico(ServiceForgeListener):
    def __init__(self):
        self.rutas_definidas = set()
        self.errores = []

    # Se ejecuta cada vez que el parser encuentra un endpoint
    def enterEndpointLine(self, ctx: ServiceForgeParser.EndpointLineContext):
        # Extraemos el método (GET, POST, etc.) y la ruta (/users)
        metodo = ctx.httpMethod().getText()
        ruta = ctx.PATH().getText()
        
        combinacion = f"{metodo} {ruta}"
        
        # REGLA: No puede haber rutas duplicadas con el mismo método
        if combinacion in self.rutas_definidas:
            linea = ctx.start.line
            self.errores.append(f"Línea {linea}: La ruta '{combinacion}' ya ha sido definida.")
        else:
            self.rutas_definidas.add(combinacion)