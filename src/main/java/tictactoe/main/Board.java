package tictactoe.main;

import tictactoe.actions.Initiator;

/**
 * @author Khoi Nguyen
 */
public class Board {
    private String[][] board;

    public void setBoard(String[][] board){
        this.board = board;
    }

    public String[][] getBoard(){
        return this.board;
    }

    public void setEmptyBoard(){
        String[][] emptyBoard = {{"","",""},{"","",""},{"","",""}};
        board = emptyBoard;
    }

    public void updateBoard(int X, int Y){
        board[X][Y] = Initiator.player.getSymbol().toString();
    }
}
