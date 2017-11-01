

To Update the Grammar:

java -jar libs/antlr-4.5.3-complete.jar -package com.pachecode.jub.jbehave.parser -o  src/main/java/com/pachecode/jub/jbehave/parser/ src/main/java/com/pachecode/jub/jbehave/parser/JBehave.g4 




java -jar antlr-4.5.3-complete.jar JBehave.g4 
javac -cp "antlr-4.5.3-complete.jar" *.java
java -cp "antlr-4.5.3-complete.jar;." org.antlr.v4.gui.TestRig JBehave r ../src/test/resources/sum_scenario.story -gui