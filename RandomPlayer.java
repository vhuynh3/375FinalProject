import java.util.*;
import java.io.*;

public class RandomPlayer extends Player {
    public RandomPlayer(String mark, int type) {
        super(mark, type);
    }

    public int play(Board board){ //choose random place to play
        int rand = (int)(Math.random()) * board.empty.size();
        return board.empty.get(rand);
    }
}