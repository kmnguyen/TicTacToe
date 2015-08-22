package tictactoe.logic;

import tictactoe.components.Initiator;

/**
 * @author Khoi Nguyen
 */
public class Logic {
    private boolean win = false;
    private boolean draw = false;

    /**
     * Check if any player wins
     *
     * @param X X location of the JButton that was pressed
     * @param Y Y location of the JButton that was pressed
     * @return boolean of whether there is a winner
     */
    public Boolean checkWinner(int X, int Y){
        Initiator.board.updateBoard(X, Y); // Update Board with JButton's X and Y location

        return win();
    }

    /**
     * Check the game is draw
     *
     * @param X X location of the JButton that was pressed
     * @param Y Y location of the JButton that was pressed
     * @return boolean of whether the game is draw
     */
    public Boolean checkDraw(int X, int Y){
        Initiator.board.updateBoard(X, Y); // Update Board with JButton's X and Y location
        String[][] currentBoard = Initiator.board.getBoard(); // Get current Board

        int numberOfBlanks = 9;

        // Check all JButtons to see if there is a draw
        for(int i = 0; i < currentBoard.length; i++){
            for(int j = 0; j < currentBoard.length; j++){
                if(currentBoard[i][j] != ""){ // If JButton's text is not blank then reduce that number from 9
                    numberOfBlanks--;
                }
            }
        }

        // If all JButtons are clicked and there is no winner then it's a draw
        if(numberOfBlanks == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * If there is a winner then reset Board and display winner
     */
    public void hasWinner(){
        Initiator.board.setEmptyBoard();
        Initiator.thread.stop();
        Initiator.GUI.displayWinner();
        this.win = true;
    }

    /**
     * If there is a draw then reset Board and display draw
     */
    public void hasDraw(){
        Initiator.board.setEmptyBoard();
        Initiator.thread.stop();
        Initiator.GUI.displayDraw();
        this.draw = true;
    }

    /**
     * Check if game is over
     *
     * @return whether or not game is over
     */
    public Boolean gameOver(){
        if(this.draw || this.win){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Reset draw and win to false like in the beginning
     */
    public void reset(){
        this.draw = false;
        this.win = false;
    }

    /**
     * Check if there is a winner aka the main logic of tic tac toe
     *
     * @return boolean if anyone wins or not
     */
    public Boolean win(){
        String playerSymbol = Initiator.player.getSymbol().toString();
        String[][] boardState = Initiator.board.getBoard();

        // Counter if there are 3 in a row for the 2 diagonals
        int diagonal_1 = 0;
        int diagonal_2 = 0;

        // Check rows and columns
        for(int i = 0; i < boardState.length; i++){
            int rowCount = 0;
            int colCount = 0;

            // Loop through the whole board
            for(int j = 0; j < boardState.length; j++){

                String rowSymbol = boardState[i][j].toUpperCase(); // Check if symbol is there looping through rows
                String colSymbol = boardState[j][i].toUpperCase(); // Check if symbol is there looping through col

                if(rowSymbol.equals(playerSymbol)){ // Check if row has player's symbol
                    rowCount++;

                    if (i == j || Math.abs(i - j) == 2){ // Check 2 diagonals
                        if(i == 1 && j == 1){
                            diagonal_1++;
                            diagonal_2++;
                        } else if(i == j){
                            diagonal_1++;
                        } else {
                            diagonal_2++;
                        }
                    }
                }


                if (colSymbol.equals(playerSymbol)){ // Check if col has player's symbol
                    colCount++;
                }
            }

            if(rowCount == 3 || colCount == 3){ //If there are 3 in rows or 3 in columns
                return true;
            }
        }

        if(diagonal_1 == 3 || diagonal_2 == 3){ // If there are 3 in either diagonal
            return true;
        }

        return false;
    }
}
