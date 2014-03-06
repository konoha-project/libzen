
function even(n : int) : boolean {
    if(n == 0) {
        return true;
    }
    return odd(n - 1);
}

function odd(n : int) : boolean {
    if(n == 0) {
        return false;
    }
    return even(n - 1);
}

export function main() {
	println("#odd(10): " + odd(10));
	println("#even(10): " + even(10));
	assert(odd(10) == false);
	assert(even(10));
}
