#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>
#include<string.h>

#include<gc.h>

struct ZArray {
	uintptr_t bufsize;
	uintptr_t len;
	void *element;
};

#define ZArray_size (sizeof(struct ZArray))

struct ZArray * ZArray_new(size_t bufsize) {
	struct ZArray* ZArr = GC_malloc(ZArray_size);
	if(ZArr == NULL) {
		exit(EXIT_FAILURE);
	}
	ZArr->bufsize = (uintptr_t)bufsize;
	ZArr->len = 0;
	ZArr->element = NULL;

	if(bufsize > 0) {
		void *o = GC_malloc(bufsize);
		if(o == NULL) {
			exit(EXIT_FAILURE);
		}
		ZArr->element = o;
	}
	return ZArr;
}

void ZArray_EnsureSize(struct ZArray *ZArr, size_t bufsize) {
	if((size_t)ZArr->bufsize < bufsize) {
		void *newarr = GC_realloc((ZArr->element), bufsize);
		if(newarr == NULL) {
			exit(EXIT_FAILURE);
		}
		ZArr->bufsize = bufsize;
		ZArr->element = newarr;
	}
	return;
}

struct ZArray * ZArray_Construct(const void *arr, size_t len, size_t elmsize) {
	size_t bufsize = elmsize * len;
	struct ZArray *ZArr = ZArray_new(bufsize);
	memcpy(ZArr->element, arr, bufsize);
	ZArr->len = (uintptr_t)bufsize;
	return ZArr;
}

struct ZArray * ZArray_Clone(struct ZArray *ZArr) {
	size_t len = (size_t)ZArr->len;
	struct ZArray *RetZArr = ZArray_new(len);
	memcpy(RetZArr->element, ZArr->element, len);
	RetZArr->len = (uintptr_t)len;
	return RetZArr;
}

int64_t ZArray_Length(struct ZArray *ZArr, size_t elmsize) {
	return (int64_t)((size_t)ZArr->len / elmsize);
}

void * ZArray_Get(struct ZArray *ZArr, int64_t index, size_t elmsize) {
	size_t bufindex = (size_t)index * elmsize;

	if((size_t)ZArr->len > bufindex) {
		return ZArr->element + bufindex;
	}
	else {
		exit(EXIT_FAILURE);
	}
}

struct ZArray * ZArray_Set(struct ZArray *ZArr, int64_t index, void* setelement, size_t elmsize) {
	size_t len = (size_t)ZArr->len;
	size_t bufindex = (size_t)index * elmsize;
	struct ZArray *RetZArr = ZArray_Clone(ZArr);
	ZArray_EnsureSize(RetZArr, bufindex + elmsize);

	memcpy(RetZArr->element + bufindex, setelement, elmsize);
	return RetZArr;
}

struct ZArray * ZArray_Add(struct ZArray *ZArr, void* addelement, size_t elmsize) {
	size_t len = (size_t)ZArr->len;
	struct ZArray *RetZArr = ZArray_new(len + elmsize);

	if(len > 0) {
		memcpy(RetZArr->element, ZArr->element, len);
	}
	memcpy(RetZArr->element + len, addelement, elmsize);
	RetZArr->len = (uintptr_t)(len + 1);
	return RetZArr;
}

struct ZArray * ZArray_Insert(struct ZArray *ZArr, int64_t index, void* addelement, size_t elmsize) {
	size_t len = (size_t)ZArr->len;
	size_t bufindex = (size_t)index * elmsize;
	struct ZArray *RetZArr = ZArray_new(len + elmsize);

	if(bufindex > 0) {
		memcpy(RetZArr->element, ZArr->element, bufindex);
	}
	memcpy(RetZArr->element + bufindex, addelement, elmsize);
	if(len-bufindex > 0) {
		memcpy(RetZArr->element + bufindex + elmsize, ZArr->element + bufindex, len-bufindex);
	}
	RetZArr->len = (uintptr_t)(len + 1);
	return RetZArr;
}

char ZArray_Equals(struct ZArray *ZArr1, struct ZArray *ZArr2) {
	uintptr_t len = ZArr2->len;
	if(ZArr1->len == len) {
		if(memcmp(ZArr1->element, ZArr2->element, (size_t)len) == 0) {
			return -1/* true */;
		}
	}
	return 0/* false */;
}

//(ZArr1).StartsWith(ZArr2)
char ZArray_StartsWith(struct ZArray *ZArr1, struct ZArray *ZArr2) {
	uintptr_t len = ZArr2->len;
	if(ZArr1->len >= len) {
		if(memcmp(ZArr1->element, ZArr2->element, (size_t)len) == 0) {
			return -1/* true */;
		}
	}
	return 0/* false */;
}

struct ZArray * ZArray_ConCat(struct ZArray *ZArr1, struct ZArray *ZArr2) {
	size_t len1 = (size_t)ZArr1->len;
	size_t len2 = (size_t)ZArr2->len;
	struct ZArray *RetZArr = ZArray_new(len1 + len2);

	memcpy(RetZArr->element       , ZArr1->element, len1);
	memcpy(RetZArr->element + len1, ZArr2->element, len2);
	RetZArr->len = (uintptr_t)(len1 + len2);
	return RetZArr;
}





#define SIZE_I64 8
struct ZArray * ZIntArray_Construct(const void *arr, size_t len, size_t elmsize) {
	return ZArray_Construct(arr, len, SIZE_I64);
}
int64_t ZIntArray_Length(struct ZArray *ZArr, size_t elmsize) {
	return ZArray_Length(ZArr, SIZE_I64);
}
void * ZIntArray_Get(struct ZArray *ZArr, int64_t index, size_t elmsize) {
	return ZArray_Get(ZArr, index, SIZE_I64);
}
struct ZArray * ZIntArray_Set(struct ZArray *ZArr, int64_t index, int64_t setelement, size_t elmsize) {
	return ZArray_Set(ZArr, index, (void *)&setelement, SIZE_I64);
}
struct ZArray * ZIntArray_Add(struct ZArray *ZArr, int64_t addelement, size_t elmsize) {
	return ZArray_Add(ZArr, (void *)&addelement, SIZE_I64);
}
struct ZArray * ZIntArray_Insert(struct ZArray *ZArr, int64_t index, int64_t addelement, size_t elmsize) {
	return ZArray_Insert(ZArr, index, (void *)&addelement, SIZE_I64);
}

#define SIZE_DOUBLE 8
struct ZArray * ZFloatArray_Construct(const void *arr, size_t len, size_t elmsize) {
	return ZArray_Construct(arr, len, SIZE_DOUBLE);
}
int64_t ZFloatArray_Length(struct ZArray *ZArr, size_t elmsize) {
	return ZArray_Length(ZArr, SIZE_DOUBLE);
}
void * ZFloatArray_Get(struct ZArray *ZArr, int64_t index, size_t elmsize) {
	return ZArray_Get(ZArr, index, SIZE_DOUBLE);
}
struct ZArray * ZFloatArray_Set(struct ZArray *ZArr, int64_t index, double setelement, size_t elmsize) {
	return ZArray_Set(ZArr, index, (void *)&setelement, SIZE_DOUBLE);
}
struct ZArray * ZFloatArray_Add(struct ZArray *ZArr, double addelement, size_t elmsize) {
	return ZArray_Add(ZArr, (void *)&addelement, SIZE_DOUBLE);
}
struct ZArray * ZFloatArray_Insert(struct ZArray *ZArr, int64_t index, double addelement, size_t elmsize) {
	return ZArray_Insert(ZArr, index, (void *)&addelement, SIZE_DOUBLE);
}

#define SIZE_POINTER 8
struct ZArray * ZObjArray_Construct(const void *arr, size_t len, size_t elmsize) {
	return ZArray_Construct(arr, len, SIZE_POINTER);
}
int64_t ZObjArray_Length(struct ZArray *ZArr, size_t elmsize) {
	return ZArray_Length(ZArr, SIZE_POINTER);
}
void * ZObjArray_Get(struct ZArray *ZArr, int64_t index, size_t elmsize) {
	return ZArray_Get(ZArr, index, SIZE_POINTER);
}
struct ZArray * ZObjArray_Set(struct ZArray *ZArr, int64_t index, void* setelement, size_t elmsize) {
	return ZArray_Set(ZArr, index, setelement, SIZE_POINTER);
}
struct ZArray * ZObjArray_Add(struct ZArray *ZArr, void* addelement, size_t elmsize) {
	return ZArray_Add(ZArr, addelement, SIZE_POINTER);
}
struct ZArray * ZObjArray_Insert(struct ZArray *ZArr, int64_t index, void* addelement, size_t elmsize) {
	return ZArray_Insert(ZArr, index, addelement, SIZE_POINTER);
}
