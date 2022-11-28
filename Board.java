import java.util.*;
import java.io.*;

public class Board {

    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final int BOARD_SIZE = 3;

    public static final String X = "X";
    public static final String O = "O";

    public static final int RANDOM = 0;
    public static final int MINIMAX = 1;
    public static final int ALPHABETA = 2;
    public static final int ITER = 3;
    
    String[] board; // 1 - X, 0 - O
    ArrayList<Integer> empty;

    public Board(){
        board = new String[BOARD_SIZE * BOARD_SIZE]; //array size 9
        empty = new ArrayList<Integer>();
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i ++) {
            empty.add(i);
            board[i] = " "; //initialize board to be empty
        }

    }

    public String toString() {
        String[] rows = new String[BOARD_SIZE];
        for (int r = 0; r < BOARD_SIZE; r ++) {
            rows[r] = String.join("|", board[r * 3 + 0], board[r * 3 + 1], board[r * 3 + 2]);
            rows[r] += "\n";
        } 
        return String.join("-+-+-\n", rows);
    }

    public int turn(String mark, int idx) {
        if (board[idx].equals(" ")) {
            board[idx] = mark;
            return 1;
        }
        return -1; //spot was not empty
    }

}