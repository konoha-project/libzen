
function apply(f: Func<int,int>, n:int) : int {
	return f(n);
}

export function main() {
	var succ = function(n: int) : int {
		assert(n>0);
		return n+1;
	}
	var f = succ;
	println("#succ(1): " + succ(1));
	println("#f(1): " + f(1));
	println("#apply(succ,1): " + apply(succ,1));
	println("#apply(f,1): " + apply(f,1));
	assert(succ(1) == 2);
	assert(f(1) == 2);
	assert(apply(succ,1) == 2);
	assert(apply(f,1) == 2);
}

