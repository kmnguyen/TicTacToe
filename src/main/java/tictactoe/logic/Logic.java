package tictactoe.logic;

import tictactoe.components.Initiator;

/**
 * @author Khoi Nguyen
 */
public class Logic {
    private boolean win = false;
    private boolean draw = false;

    public Boolean checkWinner(int X, int Y){
        Initiator.board.updateBoard(X, Y);

        return win();
    }

    public Boolean checkDraw(int X, int Y){
        Initiator.board.updateBoard(X, Y);
        String[][] currentBoard = Initiator.board.getBoard();
        int numberOfBlanks = 9;

        for(int i = 0; i < currentBoard.length; i++){
            for(int j = 0; j < currentBoard.length; j++){
                if(currentBoard[i][j] != ""){
                    numberOfBlanks--;
                }
            }
        }

        if(numberOfBlanks == 0){
            return true;
        } else {
            return false;
        }
    }

    public void hasWinner(){
        Initiator.board.setEmptyBoard();
        Initiator.thread.stop();
        Initiator.GUI.displayWinner();
        this.draw = true;
    }

    public void hasDraw(){
        Initiator.board.setEmptyBoard();
        Initiator.thread.stop();
        Initiator.GUI.displayDraw();
        this.win = true;
    }

    public Boolean gameOver(){
        if(this.draw || this.win){
            return true;
        } else {
            return false;
        }
    }

    public void reset(){
        this.draw = false;
        this.win = false;
    }

    public Boolean win(){
        String playerSymbol = Initiator.player.getSymbol().toString();
        String[][] boardState = Initiator.board.getBoard();
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
