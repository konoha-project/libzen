# build:  do static checking and build
# test:   test java implementation
.SILENT:
JavaBin="./libzen.jar"
INSTALL_PREFIX?="$(HOME)"
TEST_BASEDIR="test/common"
TEST_OUTDIR="$(TEST_BASEDIR)/test-result"

TEST_FILES:=$(wildcard test/common/*.green)

all: build

build: buildj

dist: distj distts

test:

buildj: $(JavaBin)
	echo Build LibZen

check_java_env:
	java -version > /dev/null
	ant -version  > /dev/null

$(JavaBin): check_java_env
	echo Building Java implementation
	ant jar

clean:
	-rm -rf bin/*.class *.jar

install: installj

installj: distj
	echo Installing Java implementation
	install -d $(INSTALL_PREFIX)/bin

test: buildj

.PHONY: all build buildj test testj clean dist buildj installj
