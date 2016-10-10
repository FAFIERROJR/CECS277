#Makefile for CECS 277 Project 3
SRC = Computer.java Pattern.java PokemonRPS.java
OBJ = ${patsubst %.java, %.class, ${SRC}}
MAIN = PokemonRPS
DATA = Computer.dat
DOC = *.html *.js *.css

build:
	javac ${SRC}

play: ${SRC}
	java PokemonRPS

doc:
	javadoc ${SRC}

zip:
	zip fierrop3.zip ${SRC}

clean:
	rm -f ${OBJ} ${DATA} ${DOC}

.PHONY:
	build play clean