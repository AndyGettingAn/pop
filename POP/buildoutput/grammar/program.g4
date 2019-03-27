grammar program;
prule: PROGRAM VARIABLE block;

WS: [ \t\r\n]+ -> skip;

NUMBER: '-'? '0'..'9'+([.,]'0'..'9'+)?;
TEXT: '"' .* '"';
JSON: '\'' .* '\'';
OPERATOR_ADD: '+';
OPERATOR_SUB: '-';
OPERATOR_MULT: '*';
OPERATOR_DIV: '/';
OPEN_BLOCK: '{';
CLOSE_BLOCK: '}';
ASSIGNMENT: '=';
MAPDECL: 'MAP';
DOUBLEDECL: 'DOUBLE';
TEXTDECL: 'TEXT';
BOOLDECL: 'BOOLEAN';
PRINT: 'PRINT';
LISTENERDECL: 'LISTENER';
FUNCTIONDECL: 'FUN';
PROCDECL: 'PROC';
RETURN: 'RETURN';
OPEN_BRACKET: '(';
CLOSE_BRACKET: ')';
COMMA: ',';
DOT: '.';
PROGRAM: 'PROGRAM';
CALL: 'CALL';
SMALLER: '<';
GREATER: '>';
IF: 'IF';
ELSE: 'ELSE';
AND: '&';
OR: '|';
NOT: '!';
EVENT: 'EVENT';
WHILE: 'WHILE';
TRUE: 'TRUE';
FALSE: 'FALSE';
GET: 'GET';
THREAD: 'THREAD';
WAIT: 'WAIT';
SEMICOLON: ';';
VARIABLE: ('a'..'z'|'A'..'Z')+;

block: OPEN_BLOCK statement+ CLOSE_BLOCK;

statement: (assignment |
            mapdecl |
            booldecl |
            doubledecl |
            textdecl |
            print |
            call  |
            st_while |
            st_return |
            fundecl |
            st_if |
            wait_for
           ) SEMICOLON;

mapdecl: MAPDECL VARIABLE;
booldecl: BOOLDECL VARIABLE;
doubledecl: DOUBLEDECL VARIABLE;
textdecl: TEXTDECL VARIABLE;

parameterdecl: (mapdecl | booldecl | doubledecl | textdecl);
fundecl: (FUNCTIONDECL returntype | PROCDECL | LISTENERDECL)
         VARIABLE OPEN_BRACKET (parameterdecl (COMMA parameterdecl)*)? CLOSE_BRACKET block;

print: PRINT (expression | logexpression);

call: (CALL VARIABLE | THREAD VARIABLE | EVENT (VARIABLE (DOT VARIABLE)*)?) OPEN_BRACKET (expression (COMMA expression)*)? CLOSE_BRACKET;

st_if: IF logexpression block (ELSE block)?;

logexpression: condition ((AND | OR) logexpression)?;

condition: (NOT? OPEN_BRACKET logexpression CLOSE_BRACKET) |
           (expression (GREATER | SMALLER | ASSIGNMENT) expression);

st_while: WHILE logexpression block;

st_return: RETURN expression;

wait_for: WAIT expression;

returntype: TEXTDECL | DOUBLEDECL | MAPDECL | BOOLDECL;

assignment: VARIABLE ASSIGNMENT (expression | logexpression);

expression: factor ((OPERATOR_ADD|OPERATOR_SUB) expression)?;

factor: (NUMBER |
         TEXT |
         TRUE |
         FALSE |
         JSON |
         get |
         VARIABLE (OPEN_BRACKET (expression (COMMA expression)*)? CLOSE_BRACKET)? |
         OPEN_BRACKET op=expression CLOSE_BRACKET)
        ((OPERATOR_MULT | OPERATOR_DIV) factor)?;

get: GET OPEN_BRACKET expression COMMA TEXT CLOSE_BRACKET;