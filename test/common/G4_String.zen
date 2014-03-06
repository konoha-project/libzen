

function TestString(abc: String) {
println("#abc: " + abc);
println("#abc.size(): " + abc.size());
println("#abc[1]: " + abc[1]);

println("#abc.substring(1): " + abc.substring(1));
println("#abc.substring(0,1): " + abc.substring(0,1));
println("#abc.indexOf(\"bc\"): " + abc.indexOf("bc"));
println("#abc.indexOf(\"z\"): " + abc.indexOf("z")); 
println("#abc == \"abc\": " + (abc == "abc"));
println("#abc == \"ABC\": " + (abc == "ABC"));
println("#abc.startsWith(\"ab\"): " + abc.startsWith("ab"));
println("#abc.startsWith(\"abcd\"): " + abc.startsWith("abcd"));
println("#abc.endsWith(\"bc\"): " + abc.endsWith("bc"));
println("#abc.endsWith(\"dabc\"): " + abc.endsWith("dabc"));

println("#abc+abc: " + (abc+abc));
//println("#abc+null: " + (abc+null));
//println("#null+abc: " + (null+abc));
println("#abc+1: " + (abc+1));
println("#1+abc: " + (1+abc));

assert(abc.size() == 3);
assert(abc[1] == "b");
assert(abc.substring(1) == "bc");
assert(abc.substring(0,1) == "a");
assert(abc.indexOf("bc") == 1);
assert(abc.indexOf("z") == -1);
assert(abc == "abc");
assert((abc == "ABC") == false);
assert(abc.startsWith("ab"));
assert(!abc.startsWith("abcd"));
assert(abc.endsWith("bc"));
assert(!abc.endsWith("dabc"));

assert(abc+abc == "abcabc");
//assert(abc+null == "abcnull");
//assert(null+abc == "nullabc");
assert(abc+1 == "abc1");
assert(1+abc == "1abc");
}

export function main() {
	TestString("abc");
}
