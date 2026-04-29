grammar ServiceForge;

// ─── REGLA PRINCIPAL ──────────────────────────────────────────
// Permitimos líneas en blanco al inicio o entre bloques
program
    : (apiBlock | NEWLINE)* EOF
    ;

// ─── BLOQUE API ───────────────────────────────────────────────
apiBlock
    : API IDENTIFIER apiOption* (NEWLINE+ resourceBlock* | EOF)
    ;

apiOption
    : 'version' '=' VERSION_NUMBER
    | 'base'    '=' PATH
    ;

// ─── BLOQUE RESOURCE ──────────────────────────────────────────
resourceBlock
    : RESOURCE IDENTIFIER NEWLINE+
      (fieldsLine | endpointLine | relationshipLine | NEWLINE)*
    ;

// ─── FIELDS ───────────────────────────────────────────────────
fieldsLine
    : FIELDS ':' fieldDef (',' fieldDef)* NEWLINE+
    ;

fieldDef
    : IDENTIFIER dataType fieldModifier*
    ;

dataType
    : INT | STRING | EMAIL | BOOLEAN | DATETIME | DECIMAL | UUID
    ;

fieldModifier
    : REQUIRED | UNIQUE | PK
    | DEFAULT '=' (NUMBER | STRING_LITERAL | BOOLEAN_LIT)
    | MIN '=' NUMBER
    | MAX '=' NUMBER
    ;

// ─── ENDPOINTS ────────────────────────────────────────────────
endpointLine
    : ENDPOINT httpMethod PATH endpointOption* '->' returnType (NEWLINE+ | EOF)
    ;

httpMethod
    : GET | POST | PUT | DELETE | PATCH
    ;

endpointOption
    : 'auth' '=' AUTH_TYPE
    | 'with' IDENTIFIER
    | PAGINATED 
    ;

returnType
    : IDENTIFIER ('(' IDENTIFIER ')')? returnModifier*
    ;

returnModifier
    : PAGINATED
    | 'with' IDENTIFIER
    ;

// ─── RELATIONSHIPS ────────────────────────────────────────────
relationshipLine
    : RELATIONSHIP IDENTIFIER '(' relType IDENTIFIER ')' (NEWLINE+ | EOF)
    ;

relType
    : HAS_MANY | HAS_ONE | BELONGS_TO
    ;

// ═══════════════════════════════════════════════════════════════
//  TOKENS (Léxico)
// ═══════════════════════════════════════════════════════════════

// Palabras clave
API          : 'api' ;
RESOURCE     : 'resource' ;
FIELDS       : 'fields' ;
ENDPOINT     : 'endpoint' ;
RELATIONSHIP : 'relationship' ;

// Métodos HTTP
GET : 'GET' ; POST : 'POST' ; PUT : 'PUT' ; DELETE : 'DELETE' ; PATCH : 'PATCH' ;

// Tipos de datos
INT : 'int' ; STRING : 'string' ; EMAIL : 'email' ; BOOLEAN : 'boolean' ; 
DATETIME : 'datetime' ; DECIMAL : 'decimal' ; UUID : 'uuid' ;

// Modificadores
REQUIRED : 'required' ; UNIQUE : 'unique' ; PK : 'pk' ;
DEFAULT  : 'default' ; MIN : 'min' ; MAX : 'max' ;
PAGINATED : 'paginated' ;

// Autenticación y Relaciones
AUTH_TYPE : 'jwt' | 'basic' | 'none' ;
HAS_MANY : 'has_many' ; HAS_ONE : 'has_one' ; BELONGS_TO : 'belongs_to' ;

// Literales
BOOLEAN_LIT    : 'true' | 'false' ;
VERSION_NUMBER : [0-9]+ '.' [0-9]+ ;
NUMBER         : [0-9]+ ;
PATH           : '/' [a-zA-Z0-9_/{}]* ;
STRING_LITERAL : '"' (~["\r\n])* '"' ;
IDENTIFIER     : [a-zA-Z_][a-zA-Z0-9_]* ;

// Manejo de espacios
NEWLINE : '\r'? '\n' ;
WS      : [ \t]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;