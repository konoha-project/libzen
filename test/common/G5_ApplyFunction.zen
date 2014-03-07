
let succ = function(n: int) : int {
	return n+1;
}

function apply(f: Func<int,int>, n:int) : int {
	return f(n);
}

export function main() {
	println("#apply(lambda, 1): " + apply(function(n: int):int { return n+1; },1));
	println("#apply(function, 1: " + apply(function(n: int) : int {
		assert(n > 0);
		return n+1;
	},1));
	assert(apply(function(n: int):int { return n+1; },1) == 2);
	assert(apply(function(n: int):int {
		assert(n > 0);
		return n+1;
	},1) == 2);
}

