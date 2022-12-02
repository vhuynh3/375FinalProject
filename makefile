all: Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java
	javac Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java

tests:
	java Program RANDOM RANDOM 100 RANvRAN.txt
	java Program MINIMAX MINIMAX 100 MINIMAXvMINIMAX.txt
	java Program ALPHABETA ALPHABETA 100 ALPHABETAvALPHABETA.txt
	java Program MEM MEM 100 MEMvMEM.txt
	java Program ALPHABETA MINIMAX 100 ALPHABETAvMINIMAX.txt
	java Program MEM MINIMAX 100 MEMvMINIMAX.txt

clean:
	rm *.class