
class Point2d {
	var x: int = 1;
	var y = 2;
}

function area(this: Point2d) : int{
	return this.x * this.y;
}

export function main() {
	var p: Point2d = new Point2d();
	println("#p.x: " + p.x);
	println("#p.y: " + p.y);
	var x :int = p.x;
	p.x = p.y;
	println("#x(=p.x): " + x);
	println("#p.x(=p.y): " + p.x);
	println("#p.area(): " + p.area());
	println("#area(p): " + area(p));
	assert(x == 1);
	assert(p.x == 2);
	assert(p.y == 2);
	assert(p.area() == 4);
	assert(area(p) == 4);

	var p2: Point2d = new Point2d();
	println("#p2 == p: " + (p2 == p));
	println("#p2.x: " + p2.x);
	assert(p2.x == 1);
	assert(p2 != p);
	p2 = p;
	println("#p2 == p(p2=p): " + (p2 == p));
	println("#p2.x(p2=p): " + p2.x);
	assert(p2 == p);
}

	 
