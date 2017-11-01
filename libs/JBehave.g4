grammar JBehave;
r: scenario steps+ EOF;
scenario: TEXT NEWLINE;
steps: GIVEN WHITESPACE TEXT NEWLINE;

   // when
   // then;//(given EOL when EOL then) || (given EOL then);

/** LEXER **/
fragment G: ('G' | 'g');
fragment I: ('I' | 'i');
fragment V: ('V' | 'v');
fragment E: ('E' | 'e');
fragment N: ('N' | 'n');


fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;
fragment NUMBER  : [0-9] ;
fragment SYMBOLS  : [',:;."] ;
WHITESPACE          : (' ' | '\t') ;
GIVEN: 'Given';

NEWLINE: ('\r'? '\n' | '\r')+ ;
//TEXT : (LOWERCASE | UPPERCASE | SYMBOLS | NUMBER | SPACE)+;             // match lower-case identifiers
//WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
TEXT                : (LOWERCASE | UPPERCASE | NUMBER | WHITESPACE| SYMBOLS)+ ;
