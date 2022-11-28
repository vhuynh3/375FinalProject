all: Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java IterPlayer.java
	javac Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java IterPlayer.java

clean:
	rm *.class