
DIR="test/common"
TDIR="build/test"
mkdir -p $TDIR

echo "generating zen generation .."
ZENCODE=zen bash test/testfiles.sh $DIR $TDIR cat

echo "testing java bytecode generation and its execution"
ZENCODE=jvm bash test/testfiles.sh $DIR $TDIR  

echo "testing java generation and its execution"
ZENCODE=java bash test/testfiles.sh $DIR $TDIR javac class java

echo "generating c.."
ZENCODE=c bash test/testfiles.sh $DIR $TDIR

CLANG=`which clang`
LLC=`which llc`
BOEHMDIR="/opt/boehmgc" #FIXME change boehmgc library's directory to yours
if [ -x $CLANG -a -x $LLC -a -f $BOEHMDIR/lib/libgc.so ]; then
	echo "generating llvm assembly code and its execution with $CLANG, $LLC, and Boehm GC"
	ZENCODE=ll bash test/testfiles.sh $DIR $TDIR "bash test/execllvm.sh $BOEHMDIR"
else
	echo "generating llvm assembly code .."
	ZENCODE=ll bash test/testfiles.sh $DIR $TDIR
fi

NODE=`which node`
if [ -x $NODE ]; then
	echo "testing javascript and its execution with $NODE"
	ZENCODE=js bash test/testfiles.sh $DIR $TDIR $NODE
else
	echo "testing javascript .."
	ZENCODE=js bash test/testfiles.sh $DIR $TDIR
fi

ERLANG=`which escript`
if [ -x $ERLANG ]; then
	echo "testing erlang and its execution with $ERLANG"
	ZENCODE=erl bash test/testfiles.sh $DIR $TDIR $ERLANG
else
	echo "generating eralang .erl files"
	ZENCODE=erl bash test/testfiles.sh $DIR $TDIR
fi

CSHARP=`which mcs`
if [ -x $CSHARP ]; then
	echo "testing C# and its execution with mono"
	ZENCODE=cs bash test/testfiles.sh $DIR $TDIR mcs exe mono
else
	echo "generating C# .cs files"
	ZENCODE=cs bash test/testfiles.sh $DIR $TDIR
fi

echo "testing python and its execution"
ZENCODE=py bash test/testfiles.sh $DIR $TDIR python

#echo "testing java.."
#ZENCODE=java bash test/testfiles.sh $DIR $TDIR javac

# echo "testing erlang and its execution"
# ZENCODE=erl bash test/testfiles.sh $DIR $TDIR escript
