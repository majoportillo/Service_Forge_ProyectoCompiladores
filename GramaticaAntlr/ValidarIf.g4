grammar ValidarIf;

prog: instruccion+ EOF ;

instruccion
    : IF '(' expresion ')' (cuerpoIf | instruccion) (ELSE (cuerpoIf | instruccion))? #SentenciaIf
    | ID IGUAL expresion PYC                        #Asignacion
    ;

cuerpoIf
    : L_LLAVE instruccion* R_LLAVE                   # BloqueMultiple
    | instruccion                                     # BloqueUnico
    ;

expresion
    : ID                                            # Variable
    | INT                                           # Numero
    | expresion (OPERADOR|'&&'|'||') expresion # Comparacion
    ;

IF    : 'if' ;
ELSE  : 'else' ;
IGUAL : '=' ;
PYC   : ';' ;
L_LLAVE : '{' ;
R_LLAVE : '}' ;
OPERADOR : '==' | '!=' | '<' | '>' | '<=' | '>=' ;

ID : [a-zA-Z_][a-zA-Z0-9_]* ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;
COMENTARIO : '//' ~[\n\r]* -> skip ;
MULTILINEA : '/*' .*? '*/' -> skip ;