grammar jbehave;
jbehave  : 'Scenario:' LINE steps;         // match keyword hello followed by an identifier
steps : (given when then) | (given then);
given : 'Given:' LINE and?;
when  : 'When' LINE and?;
then  : 'Then' LINE and?;
and   :  'And' LINE and?;
LINE : (.+) BRK;             // match lower-case identifiers
BRK : '\n';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines