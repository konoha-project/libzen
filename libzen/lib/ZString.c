#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>
#include<string.h>

#include<gc.h>

struct ZString {
	uintptr_t bufsize;
	uintptr_t len;
	char* string;
};

#define ZString_size (sizeof(struct ZString))

struct ZString * ZString_new(size_t bufsize) {
	struct ZString* ZStr = GC_malloc(ZString_size);
	if(ZStr == NULL) {
		exit(EXIT_FAILURE);
	}
	ZStr->bufsize = (uintptr_t)bufsize;
	ZStr->len = 0;
	ZStr->string = NULL;

	if(bufsize > 0) {
		char *str = (char *)GC_malloc_atomic(bufsize);
		if(str == NULL) {
			exit(EXIT_FAILURE);
		}
		ZStr->string = str;
	}
	return ZStr;
}

/* void ZString_delete(struct ZString* ZStr) {
	free(ZStr->string);
	free(ZStr);
} */

/* void ZString_EnsureSize(struct ZString *ZStr, size_t bufsize) {
	if(ZStr->bufsize < bufsize) {
		char *newstr = (char *)GC_realloc((void *)(ZStr->string), bufsize);
		if(newstr == NULL) {
			exit(EXIT_FAILURE);
		}
		ZStr->bufsize = bufsize;
		ZStr->string = newstr;
	}
	return;
} */

struct ZString * ZString_Create(const char *str, size_t len) {
	struct ZString *ZStr = ZString_new(len + 1);
	memcpy((void *)(ZStr->string), (const void *)str, len);
	(ZStr->string)[len] = '\0';
	ZStr->len = (uintptr_t)len;
	return ZStr;
}

#define BUFSIZE 24
struct ZString * ZString_int_toString(int64_t number) {
	char buf[BUFSIZE]; //maxlen "-9223372036854775808" = 20+1
	int len = snprintf(buf, BUFSIZE, "%lld", (long long)number);
	if(len != EOF) {
		return ZString_Create(buf, (size_t)len);
	} else {
		return ZString_new(0);
	}
}

struct ZString * ZString_StrCat(struct ZString *ZStr1, struct ZString *ZStr2) {
	size_t len1 = (size_t)ZStr1->len;
	size_t len2 = (size_t)ZStr2->len;
	size_t newlen = (size_t)(ZStr1->len + ZStr2->len);
	struct ZString *RetZStr = ZString_new(newlen + 1);

	memcpy((void *)(RetZStr->string)       , (const void *)(ZStr1->string), len1);
	memcpy((void *)(RetZStr->string) + len1, (const void *)(ZStr2->string), len2);
	(RetZStr->string)[len1 + len2] = '\0';
	RetZStr->len = (uintptr_t)(len1 + len2);
	return RetZStr;
}

int64_t ZString_StrLen(struct ZString *ZStr) {
	return (int64_t)(ZStr->len);
}

/* void ZString_print(struct ZString *ZStr) {
	printf("%s", ZStr->string);
} */

void ZString_println(struct ZString *ZStr) {
	puts(ZStr->string);
}

