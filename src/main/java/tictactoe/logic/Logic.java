package tictactoe.logic;

import org.omg.CORBA.INITIALIZE;
import tictactoe.actions.Initiator;
import tictactoe.main.Board;
import tictactoe.main.Player;

import javax.swing.*;

/**
 * @author Khoi Nguyen
 */
public class Logic {

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

        Initiator.ticTacToeGUI.displayWinner();

    }

    public void hasDraw(){
        Initiator.board.setEmptyBoard();
        Initiator.thread.stop();
        Initiator.ticTacToeGUI.displayDraw();
    }

    private void gameOver(){
        JButton[][] jButtons = Initiator.ticTacToeGUI.getBoardUI();
        for(int i = 0; i < jButtons.length; i++){
            for(int j = 0; j < jButtons.length; j++){
                JButton button =jButtons[i][j];
                button.setText("");
                setPlayer();
            }
        }
    }
}
