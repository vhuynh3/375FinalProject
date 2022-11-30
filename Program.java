import java.util.*;
import java.io.*;

public class Program {
    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final int BOARD_SIZE = 3;

    public static final String X = "X";
    public static final String O = "O";

    public static final int RANDOM = 0;
    public static final int MINIMAX = 1;
    public static final int ALPHABETA = 2;
    public static final int ITER = 3;

    public static void main(String[] args) {
        Game game;
        int result;

        int p1wins = 0; //min
        int p2wins = 0; //max
        int tie = 0;

        for (int i = 0; i < 100; i++) {
            game = new Game(MINIMAX, RANDOM);
            result = game.playGame();
            if (result > 0) {
                p2wins ++;
            } else if (result < 0) {
                p1wins ++;
            } else {
                tie ++;
            }
        }

        System.out.println("player 1 wins: " + p1wins);
        System.out.println("player 2 wins: " + p2wins);
        System.out.println("ties: "+ tie);

    }
}