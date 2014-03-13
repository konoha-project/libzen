
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

echo "testing python and its execution"
ZENCODE=py bash test/testfiles.sh $DIR $TDIR python

#echo "testing java.."
#ZENCODE=java bash test/testfiles.sh $DIR $TDIR javac

# echo "testing erlang and its execution"
# ZENCODE=erl bash test/testfiles.sh $DIR $TDIR escript
