package tictactoe.gui;

import tictactoe.timer.Timer;
import tictactoe.components.Initiator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Khoi Nguyen
 */

/**
 * This class the the GUI of the whole tic tac toe game. I was planning to make a start screen
 * and game over screen but ran out of time.
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

    /**
     * Set up the tic tac toe board, clear button to clear board when finished,
     * player indicator panel and timer panel
     */
    public void setUpGameGUI(){
        // Set up timer panel
        timeRemaining = new JLabel("Time Remaining:", SwingConstants.CENTER);

        // Set up button to clear board
        clear = new JButton("CLEAR BOARD");
        clear.addActionListener(e -> {Initiator.thread.interrupt(); setClear();});

        // Set up player indicator panel
        player = new JLabel("Player: ", SwingConstants.CENTER);
        setPlayer();

        // Set up tic tac toe board
        setTicTacToeBoard();

        // Add everything to the frame created
        container.add(timeRemaining);
        container.add(clear);
        container.add(player);

        // Make everything visible
        setVisible(true);
    }

    /**
     * Set up tic tac toe board composed of 9 JButtons in a 3 x 3 grid
     */
    private void setTicTacToeBoard(){
        jButtons = new JButton[3][3];

        for(int i = 0; i < jButtons.length; i++){
            for(int j = 0; j < jButtons.length; j++){
                // Initialize JButtons and their respective action events
                JButton button = new JButton();
                button.addActionListener(new JButtonActions());

                // Give the JButtons X and Y location to update Board object
                button.putClientProperty("X", i);
                button.putClientProperty("Y", j);

                // Add JButtons to the frame
                jButtons[i][j] = button;
                container.add(jButtons[i][j]);
            }
        }
    }

    /**
     * Clear the board and re-initialize everything as new game starts
     */
    private void setClear(){

        // Clear tic tac toe board
        for(int i = 0; i < jButtons.length; i++){
            for(int j = 0; j < jButtons.length; j++){
                JButton button =jButtons[i][j];
                button.setText("");
                setPlayer();
            }
        }

        // Reset logic i.e set win = false and draw = false
        Initiator.logic.reset();

        // Start timer
        Initiator.thread = new Thread(new Timer());
        Initiator.thread.start();
    }

    /**
     * Display how much time remaining
     *
     * @param time time remaining
     */
    public void setTimeRemaining(int time){
        timeRemaining.setText("Time Remaining: " + time);
    }

    /**
     * Display which player is making a move
     */
    public void setPlayer(){
        player.setText("Player: " + Initiator.player.getSymbol().toString());
    }

    /**
     * Display the player that won
     */
    public void displayWinner(){
        player.setText("Player " + Initiator.player.getSymbol().toString() + " Won");
    }

    /**
     * Display if the game is draw
     */
    public void displayDraw(){
        player.setText("DRAW");
    }
}
