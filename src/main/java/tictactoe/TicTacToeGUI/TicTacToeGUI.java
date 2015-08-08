package tictactoe.TicTacToeGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeGUI extends JFrame{
    private static final int WIDTH=450;
    private static final int HEIGHT=450;

    public void setBoard()
    {
        // Set size
        setSize(WIDTH, HEIGHT);

        // set background color
        getContentPane().setBackground(Color.green);

        setVisible(true);
    }
}
