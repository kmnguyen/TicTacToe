package tictactoe.main;

import tictactoe.components.Initiator;

import javax.swing.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeMain extends JFrame{
    public static void main(String[] args)
    {
        Initiator.board.setEmptyBoard();
        Initiator.GUI.setUpGameGUI();
        Initiator.thread.start();
    }
}
