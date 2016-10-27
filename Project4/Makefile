SRC1 = Heap.java Song.java Jukebox.java
SRC2 = Heap.java Job.java TaskList.java

jukebox:
	javac -Xlint ${SRC1}
	java Jukebox

tasklist:
	javac -Xlint ${SRC2}
	java TaskList

zip:
	zip Fierro4.zip ${SRC1} ${SRC2}

doc:
	javadoc ${SRC1} ${SRC2}

clean:
	rm -f *.class *.html *.css *.js

.PHONY:
	jukebox tasklist clean