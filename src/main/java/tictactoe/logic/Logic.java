package tictactoe.logic;

import tictactoe.actions.Initiator;
import tictactoe.main.Board;
import tictactoe.main.Player;

/**
 * @author Khoi Nguyen
 */
public class Logic {

    public Boolean win(String[][] boardState, Player player){
        String playerSymbol = player.getSymbol().toString();
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

    public Boolean checkWinner(Board board, int X, int Y, Player player){
        String[][] currentBoard = board.getBoard();
        currentBoard[X][Y] = player.getSymbol().toString();
        Initiator.board.setBoard(currentBoard);

        if(win(currentBoard, player)){
            System.out.println("[" + X + "," + Y + "] win");
        } else {
            System.out.println("[" + X + "," + Y + "] lose");
        }

        return win(currentBoard, player);
    }
}
