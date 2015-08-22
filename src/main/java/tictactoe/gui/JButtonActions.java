package tictactoe.gui;

import tictactoe.components.Initiator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */
public class JButtonActions {

    private boolean active = true;

    public class gameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(active){
                JButton pressed = (JButton)(actionEvent.getSource());

                int X = (Integer)(pressed.getClientProperty("X"));
                int Y = (Integer)(pressed.getClientProperty("Y"));

                if(pressed.getText() == "" && !Initiator.logic.gameOver()){
                    pressed.setText(Initiator.player.getSymbol().toString());
                    if(Initiator.logic.checkDraw(X, Y)){
                        Initiator.logic.hasDraw();
                        //setDraw(true);
                    } else {
                        if(!Initiator.logic.checkWinner(X, Y)){

                            Initiator.thread.interrupt();
                        } else {
                            Initiator.logic.hasWinner();
                            //setWin(true);
                        }
                    }
                }
            }
        }
    }

//    public void setActive(boolean active){
//        this.active = active;
//    }
}
