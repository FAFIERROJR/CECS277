SRC = *.java
OBJ = *.class
DATA = player.dat
DOC = *.html *.css *.js package-list

all:
	javac ${SRC}

play: ${SRC}
	java PokemonGame

doc:
	javadoc ${SRC}

clean:
	rm -f ${OBJ} ${DATA} ${DOC}

.PHONY: 
	clean all play doc
