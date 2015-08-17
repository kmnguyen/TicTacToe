package tictactoe.TicTacToeGUI;

import tictactoe.actions.Actions;
import tictactoe.actions.Initiator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Khoi Nguyen
 */

public class TicTacToeGUI extends JFrame{
    private static final int WIDTH=450;
    private static final int HEIGHT=600;
    private JLabel timeRemaining;
    private JLabel player;
    private JButton clear;
    private JButton[][] jButtons;

    private Container container;

    public TicTacToeGUI(){
        // Initialize container
        container = getContentPane();

        // Set size
        setSize(WIDTH, HEIGHT);

        // Set grid layout
        container.setLayout(new GridLayout(4, 3));
    }


    public void setUpGameGUI(){


        timeRemaining = new JLabel("Time Remaining:", SwingConstants.CENTER);

        clear = new JButton("CLEAR BOARD");
        clear.addActionListener(e -> Initiator.thread.interrupt());

        player = new JLabel("Player: ", SwingConstants.CENTER);
        setPlayer();

        setTicTacToeBoard();

        container.add(timeRemaining);
        container.add(clear);
        container.add(player);


        setVisible(true);
    }

    private void setTicTacToeBoard(){
        jButtons = new JButton[3][3];

        for(int i = 0; i < jButtons.length; i++){
            for(int j = 0; j < jButtons.length; j++){
                JButton button = new JButton();
                button.addActionListener((new Actions()).new gameAction());

                button.putClientProperty("X", i);
                button.putClientProperty("Y", j);

                jButtons[i][j] = button;
                container.add(jButtons[i][j]);
            }
        }
    }

    private void setClear(){
        for(int i = 0; i < jButtons.length; i++){
            for(int j = 0; j < jButtons.length; j++){
                JButton button = new JButton();
                button.setText("");
                setPlayer();
            }
        }
    }

    public void setTimeRemaining(int time){
        timeRemaining.setText("Time Remaining: " + time);
    }

    public void setPlayer(){
        player.setText("Player: " + Initiator.player.getSymbol().toString());
    }
}
