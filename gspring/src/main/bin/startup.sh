#!/bin/sh

export JAVA_HOME=/usr/local/jdk
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

if [ -z "$1" ]; then
	echo "请在参数中指定进程Id文件的名称！"
	exit 1
fi

CURRENT_DIR=$(pwd)
PROJECT_DIR=$CURRENT_DIR"/.."

# echo $PROJECT_DIR

CLASSPATH=
CLASSPATH=$CLASSPATH:$PROJECT_DIR

for i in "$PROJECT_DIR"/lib/*.jar;do
	CLASSPATH="$CLASSPATH":"$i"
done

# echo $CLASSPATH

APPNAME=com.gfar.gfspring.GfsrpingMain

java -classpath $CLASSPATH $APPNAME start

echo $! > "$PROJECT_DIR/bin/ZX-user-$1.pid"

echo "started"
