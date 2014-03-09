
function TryFinally(n: int) {
	try {
		n = n + 1;
		println("#Try(n=1):" + n);
	}
	catch(e) {
		n = n + 2;
		println("#Catch(n=3):" + n);
		assert(n == 1);  // never happen
	}
	finally {
		n = n + 4;
		println("#Finally(n=5): " + n);
	}
	assert(n == 5);
}

export function main() {
	TryFinally(0);
}

