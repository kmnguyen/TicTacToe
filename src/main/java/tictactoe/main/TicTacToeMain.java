package tictactoe.main;

import tictactoe.TicTacToeGUI.TicTacToeGUI;
import javax.swing.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeMain extends JFrame{
    public static void main(String[] args)
    {
        TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
        ticTacToeGUI.setBoard();
    }
}
