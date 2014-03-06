

function BubbleSort(a: int[]) {
	var i = 0;
	while(i < a.size()-1) {
		var j = i + 1;
		while(j < a.size()) {
			if(a[i] > a[j]) {
				var temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			j = j + 1;
		}
		i = i + 1;
	}
}

export function main() {
	var a = [1, 5, 0, 2, 6];
	BubbleSort(a);
	var i = 0;
	while(i < a.size()) {
		println("#a["+i+"]: " + a[i]);
		i = i + 1;
	}
	assert(a[0] == 0);
	assert(a[1] == 1);
	assert(a[2] == 2);
	assert(a[3] == 5);
	assert(a[4] == 6);
}
