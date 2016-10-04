#Makefile for CECS 277 Project 3
SRC = Computer.java Pattern.java PokemonRPS.java
OBJ = ${patsubst %.java, %.class, ${SRC}}
MAIN = PokemonRPS
DATA = Computer.dat

build:
	javac ${SRC}

play: ${SRC}
	java PokemonRPS

clean:
	rm -f ${OBJ} ${DATA}

.PHONY:
	build play clean