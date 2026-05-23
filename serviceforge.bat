@echo off
title ServiceForge CLI - Workflow Completo
cls

echo ==========================================
echo    ServiceForge - Integracion Final
echo ==========================================

:: 1. Activar el entorno virtual
echo [*] Preparando entorno...
call .\venv\Scripts\activate

:: 2. Entrar a la carpeta del codigo
cd serviceforge

:: 3. Validacion completa
echo [*] Fase 1: Validando definicion (.svc)...
:: Quitamos el ..\ porque grammar esta aqui mismo
python main.py validate grammar\prueba.svc
if %errorlevel% neq 0 (
    echo [!] Fallo en la validacion. Revisa el archivo .svc
    pause
    exit /b
)

:: 4. Compilacion
echo [*] Fase 2: Compilando a Python/Flask...
python main.py compile grammar\prueba.svc

:: 5. Listar Rutas
echo [*] Fase 3: Extrayendo rutas generadas...
python main.py routes grammar\prueba.svc

:: 6. Gestion de procesos
echo.
echo ==========================================
echo    Gestion del Ciclo de Vida
echo ==========================================
set /p choice="¿Deseas encender el microservicio ahora? (s/n): "

if /i "%choice%"=="s" (
    python main.py start --port 5000
    timeout /t 2 >nul
    python main.py status
    echo.
    echo [!] El servidor esta corriendo de fondo.
    echo [!] Para detenerlo, usa: python main.py stop
) else (
    python main.py status
)

echo.
echo Proceso finalizado. 
pause