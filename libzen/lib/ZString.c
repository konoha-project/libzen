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

struct ZString * ZString_float_toString(double number) {
	char buf[BUFSIZE];
	int len = snprintf(buf, BUFSIZE, "%lf", number);
	if(len != EOF) {
		return ZString_Create(buf, (size_t)len);
	} else {
		return ZString_new(0);
	}
}

struct ZString * ZString_boolean_toString(char boolean) {
	if(boolean & (char)1) {
		return ZString_Create("false", 5);
	} else {
		return ZString_Create("true", 4);
	}
}

struct ZString * ZString_NullString() {
	return ZString_Create("null", 4);
}

char ZString_StrCmp(struct ZString *ZStr1, struct ZString *ZStr2) {
	uintptr_t len = ZStr1->len;
	if(len == ZStr2->len) {
		if(strncmp(ZStr1->string, ZStr2->string, (size_t)len) == 0) {
			return -1/* true */;
		}
	}
	return 0/* false */;
}

//(ZStr1).StartsWith(ZStr2)
char ZString_StartsWith(struct ZString *ZStr1, struct ZString *ZStr2) {
	uintptr_t len = ZStr2->len;
	if(ZStr1->len >= len) {
		if(strncmp(ZStr1->string, ZStr2->string, (size_t)len) == 0) {
			return -1/* true */;
		}
	}
	return 0/* false */;
}

struct ZString * ZString_StrCat(struct ZString *ZStr1, struct ZString *ZStr2) {
	struct ZString *LeftZStr = ZStr1;
	if(LeftZStr == NULL) {
		LeftZStr = ZString_NullString();
	}
	struct ZString *RightZStr = ZStr2;
	if(RightZStr == NULL) {
		RightZStr = ZString_NullString();
	}	

	size_t len1 = (size_t)LeftZStr->len;
	size_t len2 = (size_t)RightZStr->len;
	size_t newlen = (size_t)(LeftZStr->len + RightZStr->len);
	struct ZString *RetZStr = ZString_new(newlen + 1);

	memcpy((void *)(RetZStr->string)       , (const void *)(LeftZStr->string), len1);
	memcpy((void *)(RetZStr->string) + len1, (const void *)(RightZStr->string), len2);
	(RetZStr->string)[len1 + len2] = '\0';
	RetZStr->len = (uintptr_t)(len1 + len2);
	return RetZStr;
}

int64_t ZString_StrLen(struct ZString *ZStr) {
	return (int64_t)(ZStr->len);
}

void ZString_print(struct ZString *ZStr) {
	printf("%s", ZStr->string);
}

void ZString_println(struct ZString *ZStr) {
	puts(ZStr->string);
}

