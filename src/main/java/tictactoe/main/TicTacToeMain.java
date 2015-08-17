package tictactoe.main;

import tictactoe.actions.Initiator;

import javax.swing.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeMain extends JFrame{
    public static void main(String[] args)
    {
        String[][] emptyBoard = {{"","",""},{"","",""},{"","",""}};
        Initiator.board.setBoard(emptyBoard);
        Initiator.ticTacToeGUI.setUpGameGUI();
        Initiator.thread.start();
    }
}
