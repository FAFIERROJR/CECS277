#Makefile for CECS 277 Project 3
SRC = Computer.java Pattern.java PokemonRPS.java
OBJ = ${patsubst %.java, %.class, ${SRC}}
MAIN = PokemonRPS

build:
	javac ${SRC}

play: ${SRC}
	java PokemonRPS

clean:
	rm -f ${OBJ}

.PHONY:
	build play clean