# ServiceForge: Language Compiler (DSL)

### Integrantes del Grupo:
* **María José Portillo**
* **Astrid Peña**
* **Ergil Cardenas**
* **Danilo Ucelo**
* **Ángel López**

---

ServiceForge es un Lenguaje de Especificación de Dominio (DSL) diseñado para la definición, validación semántica y generación automática de arquitecturas de servicios y endpoints en entornos Backend.

---

## Guía de Instalación Paso a Paso

Para asegurar el correcto funcionamiento del compilador y aislar las dependencias (como ANTLR4 y librerías del sistema), siga estos pasos en su terminal local:

### 1. Clonar el repositorio y posicionarse en la raíz
```bash
git clone [https://github.com/majoportillo/Service_Forge_ProyectoCompiladores.git](https://github.com/majoportillo/Service_Forge_ProyectoCompiladores.git)
cd Service_Forge_ProyectoCompiladores
```

### 2. Crear y activar el Entorno Virtual (Recomendado)
Para evitar conflictos de permisos globales de Python en Windows:

```bash
# Crear entorno virtual
python -m venv .venv

# Activar en Windows (Git Bash)
source .venv/Scripts/activate

# O si usa PowerShell estándar:
# .venv\Scripts\Activate.ps1
```

### 3. Instalación del paquete oficial desde PyPI
Instale la distribución oficial del compilador directamente desde el repositorio de paquetes de Python utilizando el siguiente comando:

```bash
pip install serviceforge-umg
```
(Al finalizar la instalación, el comando global sforge quedará registrado y disponible para su uso en la terminal).

## Guía de Uso del CLI (Comandos Disponibles)
El compilador interactúa a través de la interfaz de línea de comandos sforge. A continuación se detallan los comandos soportados:

### 1. Comando de Ayuda (--help)
Muestra el manual de usuario del CLI, las opciones disponibles y la sintaxis de comandos.

```bash
sforge --help
```

### 2. Compilación del Lenguaje (compile)
Toma un archivo con extensión .svc (código fuente del DSL), ejecuta el análisis léxico, sintáctico, semántico y genera el código final del servidor.

### Compilar por defecto (a Python/Flask):

```bash
sforge compile examples/usuarios.svc
```

### Compilar especificando el lenguaje de destino (--target):
El compilador soporta la transpilación hacia dos entornos distintos utilizando banderas:

```bash
# Target Python (Genera app_generada.py)
sforge compile examples/usuarios.svc --target python

# Target NodeJS/Express (Genera app_generada.js)
sforge compile examples/usuarios.svc --target node
```

### 3. Inicialización de un nuevo proyecto (build)
Crea una plantilla base con la estructura de directorios y un archivo .svc inicial de ejemplo en el directorio actual.

```bash
sforge build
```

### 4. Ejecución del Servidor Generado (start)
Levanta de forma automática el backend generado en el paso de compilación en el puerto especificado por el DSL (por defecto http://localhost:5000).

```bash
sforge start
```

### 5. Verificar el Estado del Servidor (status)
Comprueba si el servidor generado se encuentra actualmente activo, corriendo en segundo plano y muestra el PID (Identificador de Proceso) asignado por el sistema operativo.

```bash
sforge status
```

### 6. Detener el Servidor (stop)
Apaga de forma segura el servidor backend que está corriendo en segundo plano, liberando el puerto ocupado (ej. puerto 5000) para evitar conflictos en futuras ejecuciones.

```bash
sforge stop
```
## Sintaxis del Lenguaje (DSL) y Gramática

ServiceForge utiliza archivos con extensión `.svc` para definir microservicios REST de forma declarativa.

### Estructura general

```
api <NombreAPI> version=<versión> base=<ruta_base>
  resource <NombreRecurso>
    fields: <campo> <tipo> <modificador>, ...
    endpoint <MÉTODO> <ruta> -> <acción>(<Recurso>)
    relationship <nombre> (<tipo> <Recurso>)
```

### Tipos de datos disponibles

| Tipo | Descripción |
|---|---|
| `int` | Número entero |
| `string` | Cadena de texto |
| `boolean` | Verdadero o falso |
| `decimal` | Número decimal |
| `datetime` | Fecha y hora |
| `uuid` | Identificador único |
| `email` | Correo electrónico |

### Modificadores de campo

| Modificador | Descripción |
|---|---|
| `pk` | Llave primaria |
| `required` | Campo obligatorio |
| `unique` | Valor único |
| `default=<valor>` | Valor por defecto |

### Métodos HTTP soportados

`GET` `POST` `PUT` `DELETE` `PATCH`

### Opciones de endpoint

| Opción | Descripción |
|---|---|
| `auth=jwt` | Requiere autenticación JWT |
| `paginated` | Resultado paginado |
| `with validation` | Aplica validaciones al crear |

### Tipos de relación

| Tipo | Descripción |
|---|---|
| `has_many` | Uno a muchos |
| `has_one` | Uno a uno |
| `belongs_to` | Pertenece a |

### Ejemplo completo

```svc
api Users version=1.0 base=/api/v1
  resource User
    fields: id int pk, name string required, correo string unique, created_at datetime
    endpoint GET /users -> list(User) paginated
    endpoint POST /users -> create(User) with validation
    endpoint GET /users/{id} auth=jwt -> detail(User)
    relationship posts (has_many Post)
```

### Ejemplo simple

```svc
api MiApi version=1.0 base=/api
  resource Clientes
    fields: id int pk, nombre string required
    endpoint GET /listar -> Clientes
    endpoint POST /crear -> Clientes
    endpoint GET /buscar/{id} -> Clientes
```

---

# Optimizaciones documentadas para ServiceForge

En el proyecto ServiceForge se documentan tres optimizaciones que pueden aplicarse antes de generar el código final a partir de los archivos `.svc`. Estas optimizaciones tienen como finalidad mejorar la calidad de la salida generada por el compilador, evitando errores comunes en la escritura de rutas, organizando mejor los endpoints y eliminando instrucciones repetidas que podrían provocar conflictos durante la ejecución del servicio generado.
ServiceForge trabaja con un lenguaje específico de dominio en el que el usuario puede declarar servicios y endpoints de forma más sencilla. Luego, el compilador toma esas instrucciones y las transforma en código para un lenguaje destino, como Python o Node. Sin embargo, durante la escritura del archivo `.svc`, pueden aparecer detalles que no necesariamente representan un error grave en la intención del usuario, pero sí afectan la limpieza, el orden y la confiabilidad del código generado.
Por esta razón, las optimizaciones propuestas buscan actuar antes de la generación final del código. La idea no es cambiar la intención del usuario, sino limpiar la información, ordenarla y verificar que no existan repeticiones innecesarias. Esto permite que ServiceForge produzca una salida más clara, más ordenada y más fácil de mantener.

Las tres optimizaciones documentadas son:

* **1. Normalizar rutas, por ejemplo convertir `//users` en `/users`.** 
* **2. Ordenar endpoints, colocando primero `GET`, luego `POST`, después `PUT` y finalmente `DELETE`.**
* **3. Eliminar endpoints duplicados antes de generar el código final.**

Cada optimización incluye su propuesta, el problema que resuelve, ejemplos de antes y después, funcionamiento sugerido dentro del compilador y el beneficio que aporta al proyecto.

---

# 1. Optimización: Normalizar rutas

## Propuesta

La primera optimización propuesta consiste en normalizar las rutas declaradas en los archivos `.svc` antes de generar el código final. Normalizar una ruta significa revisar su estructura y corregir detalles de formato para que todas las rutas tengan una escritura uniforme, clara y válida.
Esta optimización es importante porque las rutas son una parte central de cualquier servicio web. Cada endpoint depende de una ruta para poder ser utilizado correctamente. Por eso, si una ruta queda mal escrita en el archivo `.svc`, el código generado también puede conservar ese error y producir una salida poco limpia o difícil de interpretar.
La normalización de rutas permite corregir casos como los siguientes:

```text
//users              → /users
/users              → /users
/orders//details    → /orders/details
users/{id}          → /users/{id}
/products           → /products
/products/          → /products
```

En estos ejemplos, el compilador conserva la intención del usuario, pero corrige la forma en que la ruta está escrita. Esto permite que el resultado final sea más ordenado y consistente.
La propuesta es que ServiceForge revise todas las rutas antes de generar código y aplique reglas básicas de limpieza, como eliminar dobles diagonales, quitar espacios innecesarios y asegurar que cada ruta inicie con `/`.

## Problema que resuelve

El problema principal que resuelve esta optimización es la escritura irregular de rutas dentro del archivo `.svc`. Cuando el usuario trabaja con varios endpoints, es común que pueda equivocarse en detalles pequeños, como colocar una diagonal de más, dejar espacios al final de una ruta o escribir una ruta sin la diagonal inicial.
Aunque estos errores pueden parecer simples, afectan directamente la calidad del código generado. Un compilador debe intentar producir una salida limpia y entendible, por lo que normalizar las rutas antes de generar el código ayuda a evitar que esos errores pequeños lleguen al archivo final.
Algunos problemas comunes son:

```text
1. Rutas con doble diagonal al inicio.
2. Rutas con doble diagonal en medio.
3. Rutas sin diagonal inicial.
4. Espacios innecesarios antes o después de la ruta.
5. Diferencias de formato entre rutas similares.
```

Por ejemplo, el usuario puede escribir:

```svc
endpoint GET //users -> list(User)
```

La intención es crear un endpoint para listar usuarios, pero la ruta fue escrita como `//users`. Lo correcto sería que el compilador la normalice a `/users`.

También puede ocurrir algo como esto:

```svc
endpoint DELETE users/{id} -> delete(User)
```

En este caso, la ruta no inicia con `/`, por lo que debería corregirse a `/users/{id}` antes de generar el código.

## Antes de aplicar la optimización

```svc
service UserService

endpoint GET //users -> list(User)
endpoint POST /users  -> create(User)
endpoint GET /orders//details -> list(OrderDetail)
endpoint DELETE users/{id} -> delete(User)
endpoint PUT /products/ -> update(Product)
```

## Después de aplicar la optimización

```svc
service UserService

endpoint GET /users -> list(User)
endpoint POST /users -> create(User)
endpoint GET /orders/details -> list(OrderDetail)
endpoint DELETE /users/{id} -> delete(User)
endpoint PUT /products -> update(Product)
```

## Explicación del antes y después

En el ejemplo anterior, las rutas fueron corregidas sin cambiar la intención original del usuario. El endpoint sigue representando la misma acción, pero la ruta queda más limpia.

Cambios realizados:

```text
GET //users                 → GET /users
POST /users                 → POST /users
GET /orders//details        → GET /orders/details
DELETE users/{id}           → DELETE /users/{id}
PUT /products/              → PUT /products
```

Con esto, el archivo `.svc` queda más uniforme y el código generado será más fácil de leer.

## Funcionamiento propuesto dentro del compilador

El compilador puede aplicar esta optimización después del análisis del archivo `.svc` y antes de la generación del código final. En esta etapa, ServiceForge ya conoce los endpoints declarados, por lo que puede recorrerlos uno por uno y limpiar sus rutas.

Reglas sugeridas:

```text
1. Quitar espacios al inicio y al final de la ruta.
2. Reemplazar dobles diagonales por una sola diagonal.
3. Agregar "/" al inicio si la ruta no lo tiene.
4. Eliminar la diagonal final cuando no sea necesaria.
5. Mantener intactos los parámetros como {id}.
6. Conservar el nombre original del recurso.
```

Ejemplo del proceso:

```text
Ruta original: //users
Ruta corregida: /users
```

Otro ejemplo:

```text
Ruta original: users/{id}
Ruta corregida: /users/{id}
```

Otro ejemplo:

```text
Ruta original: /orders//details
Ruta corregida: /orders/details
```

## Posible código generado antes de optimizar

```python
@app.route('//users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})
```

## Posible código generado después de optimizar

```python
@app.route('/users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})
```

## Beneficio

La normalización de rutas mejora la salida generada por ServiceForge porque evita que errores simples de escritura pasen directamente al código final. También permite que todos los endpoints mantengan una estructura parecida, facilitando la lectura y revisión del proyecto.

Beneficios principales:

```text
1. Genera rutas más limpias.
2. Reduce errores por dobles diagonales.
3. Mantiene una estructura uniforme.
4. Mejora la calidad del código generado.
5. Facilita la revisión del archivo final.
6. Hace que el compilador sea más tolerante ante errores simples del usuario.
```

---

# 2. Optimización: Ordenar endpoints

## Propuesta

La segunda optimización propuesta consiste en ordenar los endpoints antes de generar el código final. Esta optimización no cambia la función de los endpoints, sino únicamente el orden en que aparecen en la salida generada.

El orden sugerido es:

```text
GET
POST
PUT
DELETE
```

Este orden es útil porque primero se presentan las operaciones de consulta, luego las operaciones de creación, después las operaciones de actualización y finalmente las operaciones de eliminación.
En una API, este orden resulta más claro porque sigue una secuencia lógica de trabajo. Primero se consulta la información, luego se crea, después se modifica y al final se elimina. Por eso, aunque el usuario escriba los endpoints en desorden dentro del archivo `.svc`, el compilador puede reorganizarlos para que el resultado final sea más ordenado.

## Problema que resuelve

El problema que resuelve esta optimización es la falta de orden en los endpoints generados. El usuario puede escribir los endpoints en cualquier secuencia, y aunque eso no siempre afecta el funcionamiento del servicio, sí puede dificultar la lectura del código final.
Por ejemplo, si el archivo generado inicia con rutas `DELETE`, luego continúa con `POST`, después muestra `GET` y al final `PUT`, el código puede parecer desorganizado. Esto se vuelve más notorio cuando el proyecto crece y contiene varios servicios o muchas rutas.
Un archivo generado con endpoints ordenados facilita que cualquier integrante del equipo pueda revisar rápidamente qué rutas existen y qué tipo de operación realiza cada una.

## Antes de aplicar la optimización

```svc
service UserService

endpoint DELETE /users/{id} -> delete(User)
endpoint POST /users -> create(User)
endpoint GET /users -> list(User)
endpoint PUT /users/{id} -> update(User)
```

## Después de aplicar la optimización

```svc
service UserService

endpoint GET /users -> list(User)
endpoint POST /users -> create(User)
endpoint PUT /users/{id} -> update(User)
endpoint DELETE /users/{id} -> delete(User)
```

## Explicación del antes y después

En el ejemplo anterior, los endpoints no cambian su comportamiento. La acción `GET /users` sigue listando usuarios, `POST /users` sigue creando usuarios, `PUT /users/{id}` sigue actualizando usuarios y `DELETE /users/{id}` sigue eliminando usuarios.
Lo único que cambia es el orden en que se presentan.

Orden aplicado:

```text
1. GET /users
2. POST /users
3. PUT /users/{id}
4. DELETE /users/{id}
```

Esto permite que el código generado tenga una estructura más lógica y fácil de revisar.

## Funcionamiento propuesto dentro del compilador

Para aplicar esta optimización, el compilador puede asignar una prioridad a cada método HTTP.

Prioridad sugerida:

```text
GET = 1
POST = 2
PUT = 3
DELETE = 4
```

Después, ServiceForge puede ordenar la lista de endpoints antes de enviarla al generador de código. Si existen varios endpoints con el mismo método, se puede aplicar un segundo ordenamiento por ruta.

Ejemplo:

```svc
endpoint GET /users -> list(User)
endpoint GET /products -> list(Product)
endpoint GET /orders -> list(Order)
```

Después de ordenar alfabéticamente por ruta:

```svc
endpoint GET /orders -> list(Order)
endpoint GET /products -> list(Product)
endpoint GET /users -> list(User)
```

## Ejemplo más completo antes de aplicar la optimización

```svc
service ApiService

endpoint DELETE /products/{id} -> delete(Product)
endpoint GET /users -> list(User)
endpoint POST /products -> create(Product)
endpoint PUT /products/{id} -> update(Product)
endpoint GET /products -> list(Product)
endpoint POST /users -> create(User)
endpoint DELETE /users/{id} -> delete(User)
endpoint PUT /users/{id} -> update(User)
```

## Ejemplo más completo después de aplicar la optimización

```svc
service ApiService

endpoint GET /products -> list(Product)
endpoint GET /users -> list(User)
endpoint POST /products -> create(Product)
endpoint POST /users -> create(User)
endpoint PUT /products/{id} -> update(Product)
endpoint PUT /users/{id} -> update(User)
endpoint DELETE /products/{id} -> delete(Product)
endpoint DELETE /users/{id} -> delete(User)
```

## Posible código generado antes de optimizar

```python
@app.route('/users/<id>', methods=['DELETE'])
def delete_user(id):
    return jsonify({"message": "Usuario eliminado"})

@app.route('/users', methods=['POST'])
def create_user():
    return jsonify({"message": "Usuario creado"})

@app.route('/users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})

@app.route('/users/<id>', methods=['PUT'])
def update_user(id):
    return jsonify({"message": "Usuario actualizado"})
```

## Posible código generado después de optimizar

```python
@app.route('/users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})

@app.route('/users', methods=['POST'])
def create_user():
    return jsonify({"message": "Usuario creado"})

@app.route('/users/<id>', methods=['PUT'])
def update_user(id):
    return jsonify({"message": "Usuario actualizado"})

@app.route('/users/<id>', methods=['DELETE'])
def delete_user(id):
    return jsonify({"message": "Usuario eliminado"})
```

## Beneficio

El ordenamiento de endpoints mejora la presentación del código generado. Aunque no cambia la lógica de la API, sí permite que el archivo final tenga una estructura más clara.

Beneficios principales:

```text
1. Organiza mejor el código generado.
2. Facilita la lectura de los endpoints.
3. Permite ubicar rápidamente las rutas.
4. Ayuda al mantenimiento del proyecto.
5. Mejora la presentación del compilador.
6. Facilita el trabajo en equipo.
```

---

# 3. Optimización: Eliminar endpoints duplicados antes de generar

## Propuesta

La tercera optimización propuesta consiste en detectar y eliminar endpoints duplicados antes de generar el código final. Un endpoint se considera duplicado cuando tiene el mismo método HTTP y la misma ruta.
Por ejemplo:

```svc
endpoint GET /users -> list(User)
endpoint GET /users -> list(User)
```

En este caso, ambos endpoints son iguales porque usan el método `GET` y la ruta `/users`. Si el compilador genera ambos, el resultado puede contener código repetido o conflictivo.
La propuesta es que ServiceForge revise los endpoints antes de generar el código. Si encuentra una repetición, puede conservar solo la primera definición o mostrar un mensaje de advertencia o error.

## Problema que resuelve

El problema que resuelve esta optimización es la existencia de rutas duplicadas dentro del archivo `.svc`. Esto puede ocurrir cuando el usuario copia y pega endpoints, cuando trabaja rápido o cuando varias personas modifican el mismo archivo.
Si el compilador no detecta estos duplicados, puede generar código repetido. En algunos casos, el servidor generado podría presentar conflictos porque una misma ruta con el mismo método estaría declarada más de una vez.

## Antes de aplicar la optimización

```svc
service UserService

endpoint GET /users -> list(User)
endpoint POST /users -> create(User)
endpoint GET /users -> list(User)
endpoint DELETE /users/{id} -> delete(User)
endpoint POST /users -> create(User)
```

## Después de aplicar la optimización

```svc
service UserService

endpoint GET /users -> list(User)
endpoint POST /users -> create(User)
endpoint DELETE /users/{id} -> delete(User)
```

## Explicación del antes y después

En el ejemplo anterior, existen dos endpoints duplicados:

```text
GET /users
POST /users
```

Ambos aparecen dos veces. Después de aplicar la optimización, el compilador conserva solo una definición de cada uno.

Esto evita que se genere código repetido y mantiene más limpio el resultado final.

## Funcionamiento propuesto dentro del compilador

El compilador puede crear una clave única para cada endpoint. Esa clave puede formarse combinando el método HTTP y la ruta.

Ejemplos de claves:

```text
GET /users
POST /users
PUT /users/{id}
DELETE /users/{id}
```

Cuando el compilador analiza los endpoints, puede guardar cada clave en una lista o conjunto. Si una clave aparece nuevamente, significa que ese endpoint ya fue declarado.

Opciones para manejar duplicados:

```text
1. Conservar únicamente la primera definición encontrada.
2. Mostrar una advertencia y continuar.
3. Detener la compilación con un error semántico.
```

La opción más recomendable es mostrar una advertencia o error, porque así el usuario puede identificar el problema y corregir el archivo `.svc`.

## Ejemplo de advertencia propuesta

```text
Advertencia: endpoint duplicado encontrado: GET /users.
Se conservará únicamente la primera definición.
```

## Ejemplo de error semántico propuesto

```text
Error semántico: el endpoint GET /users ya fue declarado anteriormente.
```

## Posible código generado antes de optimizar

```python
@app.route('/users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})

@app.route('/users', methods=['GET'])
def list_users_duplicate():
    return jsonify({"message": "Listando usuarios"})

@app.route('/users', methods=['POST'])
def create_user():
    return jsonify({"message": "Usuario creado"})

@app.route('/users', methods=['POST'])
def create_user_duplicate():
    return jsonify({"message": "Usuario creado"})
```

## Posible código generado después de optimizar

```python
@app.route('/users', methods=['GET'])
def list_users():
    return jsonify({"message": "Listando usuarios"})

@app.route('/users', methods=['POST'])
def create_user():
    return jsonify({"message": "Usuario creado"})
```

## Otro ejemplo antes

```svcc


service ProductService

endpoint GET /products -> list(Product)
endpoint GET /products -> list(Product)
endpoint POST /products -> create(Product)
endpoint POST /products -> create(Product)
endpoint PUT /products/{id} -> update(Product)
endpoint DELETE /products/{id} -> delete(Product)
```

## Otro ejemplo después

```svc
service ProductService

endpoint GET /products -> list(Product)
endpoint POST /products -> create(Product)
endpoint PUT /products/{id} -> update(Product)
endpoint DELETE /products/{id} -> delete(Product)
```

## Beneficio

Esta optimización mejora la confiabilidad del compilador porque evita que se generen endpoints repetidos. También ayuda a mantener limpio el archivo final y reduce posibles errores al ejecutar el servicio.

Beneficios principales:

```text
1. Evita código repetido.
2. Reduce conflictos en las rutas generadas.
3. Mejora la claridad del archivo final.
4. Permite detectar errores en el archivo .svc.
5. Hace que el compilador sea más seguro.
6. Mejora la calidad de la salida generada.
```

---

# Ejemplo general aplicando las tres optimizaciones

## Archivo `.svc` antes de aplicar las optimizaciones

```svc
service UserService

endpoint DELETE /users/{id} -> delete(User)
endpoint GET //users -> list(User)
endpoint POST /users  -> create(User)
endpoint GET //users -> list(User)
endpoint PUT users/{id} -> update(User)
endpoint POST /users -> create(User)
```

## Problemas encontrados

```text
1. La ruta //users tiene doble diagonal.
2. La ruta users/{id} no inicia con "/".
3. El endpoint POST /users tiene espacios innecesarios.
4. Los endpoints están desordenados.
5. El endpoint GET //users está duplicado.
6. El endpoint POST /users está duplicado.
```

## Paso 1: normalización de rutas

```text
//users      → /users
/users      → /users
users/{id}  → /users/{id}
```

Después de este paso, las rutas quedan corregidas.

## Paso 2: eliminación de duplicados

```text
GET /users aparece dos veces → se conserva una sola vez.
POST /users aparece dos veces → se conserva una sola vez.
```

Después de este paso, ya no existen endpoints repetidos.

## Paso 3: ordenamiento de endpoints

```text
GET
POST
PUT
DELETE
```

Después de este paso, los endpoints quedan organizados según el método HTTP.

## Archivo `.svc` después de aplicar las optimizaciones

```svc
service UserService

endpoint GET /users -> list(User)
endpoint POST /users -> create(User)
endpoint PUT /users/{id} -> update(User)
endpoint DELETE /users/{id} -> delete(User)
```

## Resultado esperado

Después de aplicar las tres optimizaciones, el archivo queda más limpio, ordenado y sin duplicados. Las rutas fueron corregidas, los endpoints quedaron organizados y las repeticiones fueron eliminadas antes de generar el código final.

---

# Comparación general de las optimizaciones

| Optimización | Problema que resuelve | Antes | Después | Beneficio |
|-------------|------------------------|-------|---------|-----------|
| Normalizar rutas | Rutas con formato incorrecto | `//users` | `/users` | Rutas más limpias |
| Ordenar endpoints | Endpoints escritos en desorden | `DELETE`, `POST`, `GET`, `PUT` | `GET`, `POST`, `PUT`, `DELETE` | Código más organizado |
| Eliminar duplicados | Endpoints repetidos | Dos veces `GET /users` | Una sola vez `GET /users` | Evita conflictos |

---

# Importancia de estas optimizaciones en ServiceForge

Estas optimizaciones son importantes porque permiten que ServiceForge genere código de mejor calidad. Un compilador no solo debe producir una salida, también debe procurar que esa salida sea clara, ordenada y útil para el usuario.
La normalización de rutas evita que errores simples de escritura lleguen al código generado. El ordenamiento de endpoints mejora la presentación del resultado final. La eliminación de duplicados ayuda a prevenir conflictos antes de ejecutar el servicio.
Además, estas optimizaciones pueden servir como base para futuras mejoras del compilador. Más adelante se podrían agregar validaciones semánticas más completas, mensajes de error con número de línea o reportes de advertencias para que el usuario pueda corregir su archivo `.svc` con mayor facilidad.

---

## Limitaciones del Compilador
Como parte del alcance del diseño de esta gramática, el compilador posee las siguientes restricciones semánticas y técnicas:

### * Restricción de Tipos de Datos: El compilador únicamente valida de forma nativa tipos de datos primitivos (string, int, boolean, float). No se admite la declaración de objetos complejos personalizados anidados dentro de los esquemas del DSL en esta versión.
### * Estructuras de Control Limitadas: La validación semántica está optimizada para condicionales de flujo de solicitudes API. No se cuenta con soporte para bucles iterativos complejos (for, while) dentro de la declaración de lógica de los endpoints.
### * Persistencia en Memoria (Mock Data): Los endpoints generados para operaciones CRUD (Create, Read, Update, Delete) simulan el almacenamiento de datos en estructuras en memoria (arrays locales). No incluye la generación automática de cadenas de conexión para bases de datos relacionales (SQL) o NoSQL.
### * Dependencia del Entorno de Ejecución: El comando sforge start requiere que la máquina anfitriona tenga preinstalados los entornos de ejecución correspondientes (python con flask o node con express) según el --target seleccionado, de lo contrario la inicialización del servidor fallará.

## Galería de Ejemplos
Los archivos fuentes de demostración interactiva con la extensión .svc se encuentran disponibles dentro del directorio /examples en la raíz de este proyecto para realizar pruebas completas de compilación.
