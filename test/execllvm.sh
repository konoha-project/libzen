#!/bin/bash


if [ -d $1 -a -f $2 ]; then
	BOEHMDIR=$1
	SRC=$2
else
	echo "usage: boehmgc-dir srcfile"
	exit 1
fi

clang -c ./libzen/lib/ZStdLib.c -o ZStdLib.o
if [ $? -ne 0 ]; then
	exit 1
fi
clang -c ./libzen/lib/ZString.c -o ZString.o -I$BOEHMDIR/include
if [ $? -ne 0 ]; then
	exit 1
fi
llc $2 -filetype=obj -o _main.o
if [ $? -ne 0 ]; then
	exit 1
fi
clang _main.o ZStdLib.o ZString.o -L$BOEHMDIR/lib -lgc -o a.out
if [ $? -ne 0 ]; then
	exit 1
fi
LD_LIBRARY_PATH=$BOEHMDIR/lib ./a.out
if [ $? -ne 0 ]; then
	rm -f ZString.o ZStdLib.o a.out _main.o
	exit 1
else
	rm -f ZString.o ZStdLib.o a.out _main.o
	exit 0
fi
