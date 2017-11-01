grammar JBehave;
r:
    referenceScenario EOL
    steps;
referenceScenario:
    'Scenario:' TXT '\n';         // match keyword hello followed by an identifier

steps :
    given EOL
    when EOL
    then;

   // when
   // then;//(given EOL when EOL then) || (given EOL then);


given: 'Given ' TXT '\n';
when: 'When ' TXT '\n';
then: 'Then ' TXT '\n';
and: 'And ' TXT '\n';
TXT : [a-zA-Z ]+;             // match lower-case identifiers
EOL: '\r\n';
