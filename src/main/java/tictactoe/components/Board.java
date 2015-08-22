package tictactoe.components;

/**
 * @author Khoi Nguyen
 */

/**
 * This class represents the tictactoe board. It's a 2-D arrays that will be manipulated
 * to check for draw and win conditions.
 */
public class Board {
    private String[][] board;

    /**
     * Get current state of the board (in 2-D array)
     *
     * @return 2-D array representation of the board
     */
    public String[][] getBoard(){
        return this.board;
    }

    /**
     * Initialize the board when starting a new game
     */
    public void setEmptyBoard(){
        String[][] emptyBoard = {{"","",""},{"","",""},{"","",""}};
        board = emptyBoard;
    }

    /**
     * Update a board after every move
     *
     * @param X row location of which a player clicked
     * @param Y col location of which a player clicked
     */
    public void updateBoard(int X, int Y){
        board[X][Y] = Initiator.player.getSymbol().toString();
    }
}
