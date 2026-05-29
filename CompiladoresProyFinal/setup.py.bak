from setuptools import setup, find_packages

setup(
    name="serviceforge-umg",
    version="1.0.0",
    author="Maria Jose, Astrid, Ergil, Angel, Jorge",
    description="Generador y gestor de microservicios REST desde consola",
    long_description="ServiceForge es una herramienta CLI para automatizar la creacion de microservicios RESTful usando un DSL (.svc).",
    long_description_content_type="text/plain",
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        "antlr4-python3-runtime==4.13.1",
        "click",
        "flask",
    ],
    entry_points={
        "console_scripts": [
            "sforge=serviceforge.main:cli",
        ],
    },
    classifiers=[
        "Programming Language :: Python :: 3",
        "Operating System :: OS Independent",
    ],
    python_requires=">=3.11",
)