package tictactoe.TicTacToeGUI;

import tictactoe.actions.Actions;

import javax.swing.*;
import java.awt.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeGUI extends JFrame{
    private static final int WIDTH=450;
    private static final int HEIGHT=450;

    private Container container;

    public TicTacToeGUI(){
        // Initialize container
        container = getContentPane();

        // Set size
        setSize(WIDTH, HEIGHT);
    }


    public void setBoard(){

        setGrid();

        setVisible(true);
    }

    private void setGrid(){
        container.setLayout(new GridLayout(3, 3));
        JButton[] buttons = new JButton[9];

        for(JButton button : buttons){
            button = new JButton();
            button.addActionListener(new Actions());
            container.add(button);
        }
    }
}
