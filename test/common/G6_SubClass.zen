
class Point2d {
	var x: int = 2;
	var y = 3;
}

function area(p: Point2d): int {
	return p.x * p.y;
}

class Point3d extends Point2d {
	var z: int = 4;
}

function area(p: Point3d): int {
	return p.x * p.y * p.z;
}

export function main() {
	var p3: Point3d = new Point3d();
	println("#p3.x: " + p3.x);
	println("#p3.y: " + p3.y);
	println("#p3.z: " + p3.z);
	println("#p3.area(): " + p3.area());
	println("#area(p3): " + area(p3));
	assert(p3.x == 2);
	assert(p3.y == 3);
	assert(p3.z == 4);
	assert(p3.area() == 24);
	p3.x = 1;
	p3.y = 2;
	p3.z = 3;
	println("#p3.x(=1): " + p3.x);
	println("#p3.y(=2): " + p3.y);
	println("#p3.z(=3): " + p3.z);
	assert(p3.x == 1);
        assert(p3.y == 2);
        assert(p3.z == 3);
        assert(p3.area() == 6);

	var p: Point2d = p3;
	println("#p.x(p=p3): " + p.x);
	println("#p.y(p=p3): " + p.y);
	println("#p.area(): " + p.area());  // static binding
	println("#area(p): " + area(p));    // static binding
}

