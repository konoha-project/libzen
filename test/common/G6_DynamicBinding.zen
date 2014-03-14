
class Point2d {
	var x: int = 2;
	var y: int = 3;
	var area: Func<Point2d,int>;
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
	var p2: Point2d = new Point2d();
	println("#dynamic p2.area(): " + p2.area());
	println("#static   area(p2): " + area(p2));
	var p3: Point3d = new Point3d();
	println("#dymaic  p3.area(): " + p3.area());
	println("#static   area(p3): " + area(p3));
	var p: Point2d = p3;
	println("#dymaic   p.area(): " + p.area());  // dynamic binding
	println("#static    area(p): " + area(p));    // static binding
	assert(p2.area() == 6);
	assert(area(p2)  == 6);
	assert(p3.area() == 24);
	assert(area(p3)  == 24);
	assert(p.area()  == 24);
	assert(area(p)   == 6);
}

