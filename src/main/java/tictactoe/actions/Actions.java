package tictactoe.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */
public class Actions{

    public class gameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JButton pressed = (JButton)(actionEvent.getSource());

            int X = (Integer)(pressed.getClientProperty("X"));
            int Y = (Integer)(pressed.getClientProperty("Y"));

            if(pressed.getText() == ""){
                pressed.setText(Initiator.player.getSymbol().toString());
                if(!Initiator.logic.checkWinner(Initiator.board, X, Y, Initiator.player)){
                    Initiator.thread.interrupt();
                }
            }
        }
    }


}
