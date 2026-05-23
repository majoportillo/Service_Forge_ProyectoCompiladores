import sys
import os
import click
import subprocess
import signal
from antlr4 import ParseTreeWalker

# 1. Configuración de rutas de importación
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
sys.path.insert(0, os.path.abspath(os.path.dirname(__file__)))

from sforge.sintactico import analizar_sintactico
from sforge.generator import GeneradorFlask, GeneradorNode
from sforge.semantic_analyzer import AnalizadorSemantico
from grammar.ServiceForgeListener import ServiceForgeListener
from grammar.ServiceForgeParser import ServiceForgeParser

PID_FILE = "servidor.pid"

# --- 2. VISITADOR PARA LISTAR RUTAS ---
class ListadorRutas(ServiceForgeListener):
    def __init__(self):
        self.rutas = []

    def enterEndpointLine(self, ctx: ServiceForgeParser.EndpointLineContext):
        metodo = ctx.httpMethod().getText()
        ruta = ctx.PATH().getText()
        self.rutas.append(f"{metodo:<8} {ruta}")

# --- 3. CLI BASE ---
@click.group()
def cli():
    """ServiceForge — generador y gestor de microservicios REST."""
    pass

# --- 4. COMANDO: sforge validate ---
@cli.command()
@click.argument('archivo', type=click.Path(exists=True, dir_okay=False))
def validate(archivo):
    """Valida la sintaxis y semántica del archivo .svc."""
    arbol, errores_sintacticos = analizar_sintactico(archivo)
    if errores_sintacticos:
        click.secho("✖ Errores de Sintaxis detectados.", fg="red")
        return 

    walker = ParseTreeWalker()
    semantico = AnalizadorSemantico()
    walker.walk(semantico, arbol)
    if semantico.errores:
        click.secho("\n✖ Errores Semánticos detectados:", fg="yellow", bold=True)
        for err in semantico.errores:
            click.secho(f"  -> {err}", fg="yellow")
        sys.exit(1)  #si hay errores se detiene
    else:
        click.secho("\n El archivo es válido sintáctica y semánticamente.", fg="green", bold=True)


# --- 5. COMANDO: sforge compile ---
@cli.command()
@click.argument('archivo', type=click.Path(exists=True))
@click.option('--target', default='python', help='Lenguaje destino (python o node)')
def compile(archivo, target):
    """Genera el código fuente (Flask o Express)."""
    arbol, errores = analizar_sintactico(archivo)
    if errores: 
        return

    api_ctx = arbol.apiBlock(0)
    nombre_api = api_ctx.IDENTIFIER().getText()
    base_path = next((opt.getChild(2).getText() for opt in api_ctx.apiOption() if opt.getChild(0).getText() == 'base'), "/")

    walker = ParseTreeWalker()

    if target.lower() == 'python':
        generador = GeneradorFlask(nombre_api, base_path)
        walker.walk(generador, arbol)
        with open("app_generada.py", "w", encoding="utf-8") as f:
            f.write(generador.obtener_codigo_completo())
        click.secho("✔ Compilación exitosa: 'app_generada.py' creado.", fg="green")
        
    elif target.lower() == 'node':
        generador = GeneradorNode(nombre_api, base_path)
        walker.walk(generador, arbol)
        with open("app_generada.js", "w", encoding="utf-8") as f:
            f.write(generador.obtener_codigo_completo())
        click.secho("✔ Compilación exitosa: 'app_generada.js' creado.", fg="cyan")
        
    else:
        click.secho(f"✖ Error: Target '{target}' no soportado. Usa 'python' o 'node'.", fg="red")

# --- 6. COMANDO: sforge routes ---
@cli.command()
@click.argument('archivo', type=click.Path(exists=True))
def routes(archivo):
    """Lista las rutas definidas en el archivo .svc."""
    arbol, _ = analizar_sintactico(archivo)
    walker = ParseTreeWalker()
    listador = ListadorRutas()
    walker.walk(listador, arbol)
    
    click.secho("\n--- RUTAS COMPILADAS ---", fg="cyan", bold=True)
    for r in listador.rutas: click.echo(r)

# --- 7. COMANDO: sforge start ---
@cli.command()
@click.option('--port', default=5000)
def start(port):
    """Arranca el servicio y guarda el PID."""
    if os.path.exists(PID_FILE):
        click.secho("El servidor ya parece estar corriendo.", fg="yellow")
        return

    click.secho(f"🚀 Iniciando servicio en puerto {port}...", fg="magenta", bold=True)
    
    # Iniciamos el proceso de forma independiente
    app_path = os.path.join(os.path.dirname(__file__), "app_generada.py")
    proceso = subprocess.Popen(
        [sys.executable, app_path],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL
    )
    
    # Guardamos el PID para poder detenerlo luego
    with open(PID_FILE, "w") as f: f.write(str(proceso.pid))
    click.secho(f"✔ Servicio iniciado (PID: {proceso.pid}).", fg="green")

# --- 8. COMANDO: sforge stop ---
@cli.command()
def stop():
    """Detiene el servicio usando el PID guardado."""
    if not os.path.exists(PID_FILE):
        click.echo("No hay ningún servicio activo para detener.")
        return

    with open(PID_FILE, "r") as f: pid = int(f.read())
    
    try:
        os.kill(pid, signal.SIGTERM)
        os.remove(PID_FILE)
        click.secho("Servicio detenido correctamente.", fg="yellow", bold=True)
    except OSError:
        click.echo("El proceso ya no existe. Limpiando rastro...")
        os.remove(PID_FILE)

# --- 9. COMANDO: sforge status ---
@cli.command()
def status():
    """Verifica si el servicio está corriendo."""
    if os.path.exists(PID_FILE):
        click.secho("● ServiceForge está ACTIVO.", fg="green", bold=True)
    else:
        click.secho("○ ServiceForge está DETENIDO.", fg="red")


if __name__ == "__main__":
    cli()