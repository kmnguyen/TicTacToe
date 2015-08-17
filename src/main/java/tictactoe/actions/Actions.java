package tictactoe.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */
public class Actions{

    private boolean active = true;

    public class gameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(active){
                JButton pressed = (JButton)(actionEvent.getSource());

                int X = (Integer)(pressed.getClientProperty("X"));
                int Y = (Integer)(pressed.getClientProperty("Y"));

                if(pressed.getText() == ""){
                    pressed.setText(Initiator.player.getSymbol().toString());
                    if(Initiator.logic.checkDraw(X, Y)){
                        Initiator.logic.hasDraw();
                    } else {
                        if(!Initiator.logic.checkWinner(X, Y)){
                            Initiator.thread.interrupt();
                        } else {
                            Initiator.logic.hasWinner();
                        }
                    }
                }
            }
        }
    }

    public void setActive(boolean active){
        this.active = active;
    }


}
