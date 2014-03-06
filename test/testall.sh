
DIR="test/common"

echo "testing generation of java byte code"
ZENCODE=jvm bash test/testfiles.sh $DIR workingtest 

echo "testing generation of java source code"
ZENCODE=java bash test/testfiles.sh $DIR workingtest javac class java

echo "testing python.."
ZENCODE=py bash test/testfiles.sh $DIR workingtest python

#echo "testing java.."
#ZENCODE=java bash test/testfiles.sh $DIR workingtest javac
