// written by kimio kuramitsu

function IfTest1(n: int): int {
	if(n > 0) {
		assert(true);
		return 1;
	}
	else {
		return 0;
	}
}

function IfTest2(n: int): int {
	if(n > 0) {
		assert(true);
		return 1;
	}
	return 0;
}

function IfTest3(n: int): int {
	if(n == 0) {
	}
	else {
		assert(true);
		return 1;
	}
	return 0;
}

function NestedIfTest(x: int, y: int) {
	if(x > 0) {
		assert(true);
		if(y > 0) {
			return 11;
		}
		else {
			return 10;
		}
	}
	else {
		if(y > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

function ElseIfTest(x: int): int {
	if(x == 0) {
		return 0;
	}
	else if(x == 1) {
		return 1;
	}
	else if(x == 2) {
		return 2;
	}
	else {
		return x;
	}
}

export function main() {
	println("#IfTest1(1): " + IfTest1(1));
	println("#IfTest1(0): " + IfTest1(0));
	println("#IfTest2(1): " + IfTest2(1));
	println("#IfTest2(0): " + IfTest2(0));
	println("#IfTest3(1): " + IfTest3(1));
	println("#IfTest3(0): " + IfTest3(0));
	println("#NestedIfTest(0,0): " + NestedIfTest(0,0));
	println("#NestedIfTest(1,0): " + NestedIfTest(1,0));
	println("#NestedIfTest(0,1): " + NestedIfTest(0,1));
	println("#NestedIfTest(1,1): " + NestedIfTest(1,1));
	println("#ElseIfTest(0): " + ElseIfTest(0));
	println("#ElseIfTest(1): " + ElseIfTest(1));
	println("#ElseIfTest(2): " + ElseIfTest(2));
	println("#ElseIfTest(3): " + ElseIfTest(3));
	assert(IfTest1(1) == 1);
	assert(IfTest1(0) == 0);
	assert(IfTest2(1) == 1);
	assert(IfTest2(0) == 0);
	assert(IfTest3(1) == 1);
	assert(IfTest3(0) == 0);
	assert(NestedIfTest(0,0) == 0);
	assert(NestedIfTest(1,0) == 10);
	assert(NestedIfTest(0,1) == 1);
	assert(NestedIfTest(1,1) == 11);
	assert(ElseIfTest(0) == 0);
	assert(ElseIfTest(1) == 1);
	assert(ElseIfTest(2) == 2);
	assert(ElseIfTest(3) == 3);
}

