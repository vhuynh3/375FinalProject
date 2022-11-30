import java.util.*;
import java.io.*;

public class MinimaxPlayer extends Player {
    public MinimaxPlayer(String mark, int type) {
        super(mark, type);
    }

    public int play(Board board) {
        int bestMove = 0;
        int bestVal;
        if (type == MIN_PLAY) {
            bestVal = 100000; //arbitrary large number
        } else {
            bestVal = -100000; //arbitrary small number
        }
        
        int curIdx;
        int curVal;
        ArrayList<Integer> emptyCopy = new ArrayList<>(board.empty);

        //find best move by going through all empty spaces
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
            if (board.board[i].equals(" ")){
                board.addMark(mark, i);
                curVal = minimax(board, 10);
                
                if ((type == MIN_PLAY && curVal < bestVal) || (type == MAX_PLAY && curVal > bestVal)) {
                    bestVal = curVal;
                    bestMove = i;
                }
                board.remMark(i);
            }
        }

        board.addMark(mark, bestMove);
        return bestMove;
    }

    public int minimax(Board board, int depth) {
        int value = board.boardValue();
        if (depth == 0 || value != 0) {
            return value;
        }
        if (board.empty.size() == 0) {
            return 0;
        }

        int bestVal;
        if (type == MAX_PLAY) { //maximizing player
            bestVal = -100000; //arbitrary small number
            for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
                if (board.board[i].equals(" ")) {
                    board.addMark(mark, i);

                    bestVal = Math.max(bestVal, minimax(board, depth - 1));

                    board.remMark(i);
                }
            }
            return bestVal;
        } 
        else { //minimizing player
            bestVal = 100000;
            for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
                if (board.board[i].equals(" ")) {
                    board.addMark(mark, i);

                    bestVal = Math.min(bestVal, minimax(board, depth - 1));

                    board.remMark(i);
                }
            }
        }
        return 0;
    }
}