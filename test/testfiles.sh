#!/bin/bash

if [ -d $1 -a -d $2 ]; then
	SRCDIR=$1
	OUTDIR=$2
else
	echo "usage: srcdir outdir engine"
	exit 1
fi

if [ -n "$3" ]; then
	ZENEXE=$3
fi

if [ -z $ZENCODE ]; then
	echo "set ZENCODE!!"
	exit 1
fi

if [ -z $ZENJAR ]; then
        ZENJAR='libzen.jar'
fi

if [ -n "$5" ]; then
	IRCODE=$4
	IREXEC=$5
fi

OUTLOG="$OUTDIR/$ZENCODE.log"
OUTLOG1="$OUTLOG.1"
OUTLOG2="$OUTLOG.2"

if [ -f $OUTLOG ]; then
	rm -f "$OUTLOG" 
	rm -f "$OUTLOG1"
	rm -f "$OUTLOG2"
fi

for SRCPATH in $SRCDIR/*.zen
do
	SRCFILE=`basename $SRCPATH .zen`
	OUTPATH="$OUTDIR/$SRCFILE"
	echo "" >> $OUTLOG2
	echo "java -ea -jar $ZENJAR -o $OUTPATH $SRCPATH" >> $OUTLOG2
	java -ea -jar $ZENJAR -o $OUTPATH $SRCPATH >> $OUTLOG2
	if [ $? -ne 0 ]; then
		echo "[FAILED] $SRCFILE"  >> $OUTLOG1
		echo "[FAILED] $SRCFILE"
		continue
	fi
	if [ -n "$ZENEXE" ]; then
		echo "$ZENEXE $OUTPATH.$ZENCODE" >> $OUTLOG2
		$ZENEXE "$OUTPATH.$ZENCODE" >> $OUTLOG2
	fi
	if [ $? -ne 0 ]; then
		echo "[FAILED] $SRCFILE"  >> $OUTLOG1
		echo "[FAILED] $SRCFILE"
		continue
	fi
	if [ -n "$IREXE" ]; then
		echo "$IREXE $OUTPATH.$IRCODE" >> $OUTLOG2
		$IREXE "$OUTPATH.$IRCODE" >> $OUTLOG2
	fi
	if [ $? -ne 0 ]; then
		echo "[FAILED] $SRCFILE"  >> $OUTLOG1
		echo "[FAILED] $SRCFILE"
	else
		echo "[OK] $SRCFILE" >> $OUTLOG1
		echo "[OK] $SRCFILE"
	fi
done

cat $OUTLOG1 $OUTLOG2 > $OUTLOG
rm -f $OUTLOG1
rm -f $OUTLOG2

