#include<stdio.h>
#include<stdlib.h>

void ZStdLib_assert(char expr) {
	if(expr == 0) {
		fprintf(stderr, "Assertion Failure");
		exit(EXIT_FAILURE);
	}
}

