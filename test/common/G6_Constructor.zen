
class Point2d {
	var x: int = 0;
	var y = 0;
}

class Point3d extends Point2d {
	var z: int = 0;
}

function Point2d(this: Point2d, x: int, y: int) : Point2d {
	this.x = x;
	this.y = y;
	return this;
}

function Point3d(this: Point3d, x: int, y: int, z: int) : Point3d {
	this.x = x;
	this.y = y;
	this.z = z;
	return this;
}

export function main() {
	var p2: Point2d = new Point2d(1, 2);
	var p3: Point3d = new Point3d(1, 2, 3);
	println("#p2.{x,y}: " + p2.x + ", " + p2.y);
	println("#p3.{x,y,z}: " + p3.x + ", " + p3.y + ", " + p3.z);
	assert(p2.x == 1);
	assert(p2.y == 2);
	assert(p3.x == 1);
	assert(p3.y == 2);
	assert(p3.z == 3);
}

	 
