SRC = $(shell find com -name "*.java")
OUT = out
MAIN = com.schottenTotten.model.Joueur

.PHONY: all run clean

all:
	javac -d $(OUT) $(SRC)

run: all
	java -cp $(OUT) $(MAIN)

clean:
	rm -rf $(OUT)