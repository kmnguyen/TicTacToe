package tictactoe.gui;

import tictactoe.components.Initiator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */

/**
 * Implement what to do when a button is pressed
 */
public class JButtonActions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JButton pressed = (JButton)(actionEvent.getSource()); // Determine which JButton is pressed

        // Get JButton's X and Y
        int X = (Integer)(pressed.getClientProperty("X"));
        int Y = (Integer)(pressed.getClientProperty("Y"));

        if(pressed.getText() == "" && !Initiator.logic.gameOver()){ // If game is not over and the JButton's text is blank
            // Display player's symbol
            pressed.setText(Initiator.player.getSymbol().toString());

            if(Initiator.logic.checkWinner(X, Y)){ // If there is a winner
                Initiator.logic.hasWinner();
            } else if(Initiator.logic.checkDraw(X, Y)){ // If there is a draw
                Initiator.logic.hasDraw();
            } else { // If there is no winner and no draw then restart timer
                Initiator.thread.interrupt();
            }
        }
    }
}
