all: Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java
	javac Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java

clean:
	rm *.class