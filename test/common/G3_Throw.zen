
function Throw() {
	throw "error";
}

function TryCatch(n: int) {
	try {
		n = n + 1;
		println("#Try(n=1):" + n);
		Throw();
		n = n + 100;
	}
	catch(e) {
		n = n + 2;
		println("#Catch(n=3):" + n);
	}
	finally {
		n = n + 4;
		println("#Finally(n=7): " + n);
	}
	assert(n == 7);
}

export function main() {
	TryCatch(0);
}

