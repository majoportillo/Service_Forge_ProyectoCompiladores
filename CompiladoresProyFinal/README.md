# ServiceForge — Generador y Gestor de Microservicios REST

**ServiceForge** es una herramienta de línea de comandos (CLI) diseñada para automatizar la creación de microservicios RESTful. Utiliza un Lenguaje de Dominio Específico (DSL) con extensión `.svc` que es procesado por un compilador completo para generar servidores funcionales en **Python/Flask**.

##  Equipo de Desarrollo (UMG - 7mo Semestre)

*   **Astrid:** Diseño de Gramática ANTLR (`.g4`).
*   **María José:** Configuración de entorno y generación del Lexer.
*   **Ángel:** Implementación y pruebas de tokens del Lexer.
*   **Danilo:** Implementación del Parser y generación del Árbol Sintáctico (AST).
*   **Ergil Cárdenas:** Integración total, Análisis Semántico, Generación de Código y Gestión de Procesos (CLI).

##  Guía de Ejecución Rápida

Para facilitar la evaluación, se ha incluido un script de automatización que gestiona todo el flujo:

1. Ejecute en la terminal raíz:
   ```bash
   .\serviceforge.bat
   
Siga las instrucciones en pantalla para validar, compilar y encender el servicio.

 Comandos del CLI (main.py)
Si desea ejecutar las fases de forma manual, utilice los siguientes comandos:

Validación: Comprueba sintaxis y errores semánticos (rutas duplicadas).

Bash
python main.py validate grammar/prueba.svc

*   **Compilación:** Genera el archivo `app_generada.py`.
    ```bash
    python main.py compile grammar/prueba.svc
    ```
*   **Rutas:** Muestra la tabla de endpoints detectados.
    ```bash
    python main.py routes grammar/prueba.svc
    
Ciclo de Vida: Controla el encendido y apagado del servidor.

Bash
python main.py start --port 5000
python main.py status
python main.py stop


## Fases del Compilador
1. **Análisis Léxico/Sintáctico:** Implementado con ANTLR4.
2. **Análisis Semántico:** Validación de lógica de negocio (endpoints únicos).
3. **Generación de Código:** Traducción dirigida por sintaxis a Flask.
4. **Gestión de Procesos:** Control de ejecución mediante archivos de rastreo de PID.
