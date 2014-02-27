
python libzen/zen.py libzen/parser.zen src/zen/type/ZType.java src/zen/type/*.java src/zen/ast/*java src/zen/parser/*.java src/zen/lang/ZenTypeSafer.java
python libzen/zen.py libzen/grammar.zen src/zen/grammar/*.java 
python libzen/zen.py libzen/lang.zen    src/zen/lang/ZenGrammar.java src/zen/lang/ZenPrecedence.java
python libzen/zen.py libzen/codegen.zen src/zen/codegen/c/*.java

rm -f libzen/libzen.zen
cat libzen/native.zen libzen/parser.zen libzen/grammar.zen libzen/lang.zen libzen/codegen.zen > libzen/libzen.zen
