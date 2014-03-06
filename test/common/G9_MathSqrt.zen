
function sqrt(y: float): float {
        var x: float = y / 2;
        var i: int = 0;
        while (i < 10000) {
                x = (x + y/x) / 2;
                i = i + 1;
        }
        return x;
}

export function main() {
	println("#sqrt(2.0): " + sqrt(2.0));
	assert(1.4142135623730951 - sqrt(2.0) <= 0.0001);
}

