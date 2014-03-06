
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
	var p: Point3d = new Point3d();
	var p3: Point2d = p;
	var p2: Point2d = new Point2d();
	println("#p instanceof Point3d: " + (p instanceof Point3d));
	println("#p2 instanceof Point3d: " + (p2 instanceof Point3d));
	println("#p3 instanceof Point3d: " + (p instanceof Point3d));
	assert(p instanceof Point3d);
	assert(!(p2 instanceof Point3d));
	assert(p3 instanceof Point3d);
}

