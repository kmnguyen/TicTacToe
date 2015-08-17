package tictactoe.main;

import tictactoe.actions.Initiator;

import javax.swing.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeMain extends JFrame{
    public static void main(String[] args)
    {
        Initiator.board.setEmptyBoard();
        Initiator.ticTacToeGUI.setUpGameGUI();
        Initiator.thread.start();
    }
}
