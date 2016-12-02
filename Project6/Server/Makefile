SRC = Server.java Computer.java Pattern.java
OBJ = ${patsubst %.java, %.class, ${SRC}}
MAIN = Server

all:
	javac ${SRC}
	java ${MAIN}

.PHONY:
	all