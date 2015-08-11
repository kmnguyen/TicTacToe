package tictactoe.logic;

import tictactoe.main.Player;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Khoi on 8/9/2015.
 */
public class Logic {
    int[] X = {1, 145, 289};
    int[] Y = {0,137, 274};

    public void intializeMap(){
        Map<Integer, Integer> xMap = new HashMap<>();
        xMap.put(1,0);
    }




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

                if(rowSymbol == playerSymbol){ // Check if row has player's symbol
                    rowCount++;
                } else if (colSymbol == playerSymbol){ // Check if col has player's symbol
                    colCount++;
                } else if (i == j || Math.abs(i - j) == 2){ // Check 2 diagonals
                    if(i == 1 && j == 1){
                        diagonal_1++;
                        diagonal_2++;
                    } else if(i == j && boardState[i][j].toUpperCase() == player.getSymbol().toString()){
                        diagonal_1++;
                    } else if(boardState[i][j].toUpperCase() == player.getSymbol().toString()){
                        diagonal_2++;
                    }
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
