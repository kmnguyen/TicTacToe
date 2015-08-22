package tictactoe.gui;

import tictactoe.timer.Timer;
import tictactoe.components.Initiator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Khoi Nguyen
 */

public class GUI extends JFrame{
    private static final int WIDTH=450;
    private static final int HEIGHT=600;
    private JLabel timeRemaining;
    private JLabel player;
    private JButton clear;
    private JButton[][] jButtons;

    private Container container;

    public GUI(){
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
        clear.addActionListener(e -> {Initiator.thread.interrupt(); setClear();});

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
                button.addActionListener((new JButtonActions()).new gameAction());

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
                JButton button =jButtons[i][j];
                button.setText("");
                setPlayer();
            }
        }
        Initiator.logic.reset();

        Initiator.thread = new Thread(new Timer());
        Initiator.thread.start();
    }

    public void setTimeRemaining(int time){
        timeRemaining.setText("Time Remaining: " + time);
    }

    public void setPlayer(){
        player.setText("Player: " + Initiator.player.getSymbol().toString());
    }

    public void displayWinner(){
        player.setText("Player " + Initiator.player.getSymbol().toString() + " Won");
    }

    public void displayDraw(){
        player.setText("DRAW");
    }

    public JButton[][] getBoardUI(){
        return jButtons;
    }
}
