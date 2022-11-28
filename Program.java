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
        Game game = new Game(RANDOM, RANDOM);
    }
}