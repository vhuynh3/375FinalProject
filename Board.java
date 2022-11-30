import java.util.*;
import java.io.*;

public class Board {
    public static final int MAX_PLAY = 1;
    public static final int MIN_PLAY = 0;

    public static final int BOARD_SIZE = 3;

    public static final String X = "X"; //max player
    public static final String O = "O"; //min player

    public static final int RANDOM = 0;
    public static final int MINIMAX = 1;
    public static final int ALPHABETA = 2;
    public static final int ITER = 3;
    
    String[] board; // 1 - X, 0 - O
    /*
    [
        0|1|2
        -+-+-
        3|4|5
        -+-+-
        6|7|8
    ]
    */
    ArrayList<Integer> empty;

    public Board(){
        board = new String[BOARD_SIZE * BOARD_SIZE]; //array size 9
        empty = new ArrayList<Integer>();
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i ++) {
            empty.add(i);
            board[i] = " "; //initialize board to be empty
        }

    }

    public String toString() { //print board
        String[] rows = new String[BOARD_SIZE];
        for (int r = 0; r < BOARD_SIZE; r ++) {
            rows[r] = String.join("|", board[r * 3 + 0], board[r * 3 + 1], board[r * 3 + 2]);
            rows[r] += "\n";
        } 
        return String.join("-+-+-\n", rows);
    }

    public int addMark(String mark, int idx) { //place mark
        if (board[idx].equals(" ")) {
            board[idx] = mark;
            empty.remove(Integer.valueOf(idx)); // remove index from list of empty spots
            return 1;
        }
        return -1; //spot was not empty
    }

    public void remMark(int idx) { //remove mark
        board[idx] = " ";
        empty.add(idx);
    }

    public int boardValue() {
        String winner = " ";
        //checking all rows
        for (int r = 0; r < BOARD_SIZE; r++) {
            if (board[r * 3 + 0].equals(board[r * 3 + 1]) && board[r * 3 + 1].equals(board[r * 3 + 2])) {
                winner = board[r * 3 + 0];
            }
        }

        //checking all cols
        if (winner.equals(" ")) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (board[0 * 3 + c].equals(board[1 * 3 + c]) && board[1 * 3 + c].equals(board[2 * 3 + c])) {
                    winner = board[0 * 3 + c];
                }
            }
        }
        
        //checks \ diagonal
        if (winner.equals(" ")) {
            if (board[0].equals(board[4]) && board[4].equals(board[8])) {
                winner = board[4];
            }
        }

        //checks / diagonal
        if (winner.equals(" ")) {
            if (board[2].equals(board[4]) && board[4].equals(board[6])) {
                winner = board[4];
            }
        }

        if (winner.equals(X)) {return 10;}
        if (winner.equals(O)) {return -10;}
        return 0;
    }
}