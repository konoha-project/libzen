

function TestString(abc: String) {
println("#abc: " + abc);
println("#abc.size(): " + abc.size());
println("#abc[1]: " + abc[1]);

println("#abc.substring(1): " + abc.substring(1));
println("#abc.substring(0,1): " + abc.substring(0,1));
println("#abc.indexOf(\"いう\"): " + abc.indexOf("いう"));
println("#abc.indexOf(\"お\"): " + abc.indexOf("お")); 
println("#abc == \"あいう\": " + (abc == "あいう"));
println("#abc == \"アイウ\": " + (abc == "アイウ"));
println("#abc.startsWith(\"あい\"): " + abc.startsWith("あい"));
println("#abc.startsWith(\"あいうえ\"): " + abc.startsWith("あいうえ"));
println("#abc.endsWith(\"いう\"): " + abc.endsWith("いう"));
println("#abc.endsWith(\"いあいう\"): " + abc.endsWith("いあいう"));

println("#abc+abc: " + (abc+abc));
//println("#abc+null: " + (abc+null));
//println("#null+abc: " + (null+abc));
println("#abc+1: " + (abc+1));
println("#1+abc: " + (1+abc));

assert(abc.size() == 3);
assert(abc[1] != "b");
assert(abc.substring(1) == "いう");
assert(abc.substring(0,1) == "あ");
assert(abc.indexOf("bc") != 1);
assert(abc.indexOf("z") == -1);
assert(abc == "あいう");
assert((abc == "アイウ") == false);
assert(abc.startsWith("あい"));
assert(!abc.startsWith("あいうえ"));
assert(abc.endsWith("いう"));
assert(!abc.endsWith("いあいう"));

assert(abc+abc == "あいうあいう");
//assert(abc+null == "abcnull");
//assert(null+abc == "nullabc");
assert(abc+1 == "あいう1");
assert(1+abc == "1あいう");
}

export function main() {
	TestString("あいう");
}
