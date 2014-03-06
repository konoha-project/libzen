
DIR="test/common"
TDIR="build/test"
mkdir -p $TDIR

echo "testing java bytecode generation and its execution"
ZENCODE=jvm bash test/testfiles.sh $DIR $TDIR  

echo "testing java generation and its execution"
ZENCODE=java bash test/testfiles.sh $DIR $TDIR javac class java

echo "testing c.."
ZENCODE=c bash test/testfiles.sh $DIR $TDIR

echo "testing python and its execution"
ZENCODE=py bash test/testfiles.sh $DIR $TDIR python

#echo "testing java.."
#ZENCODE=java bash test/testfiles.sh $DIR $TDIR javac
