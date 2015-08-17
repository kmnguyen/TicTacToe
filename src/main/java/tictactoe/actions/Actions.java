package tictactoe.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */
public class Actions  implements ActionListener{

    private int X;
    private int Y;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton pressed = (JButton)(actionEvent.getSource());

        this.X = (Integer)(pressed.getClientProperty("X"));
        this.Y = (Integer)(pressed.getClientProperty("Y"));

        if(pressed.getText() == ""){
            pressed.setText(Initiator.player.getSymbol().toString());
            if(!Initiator.logic.checkWinner(Initiator.board, this.X, this.Y, Initiator.player)){
                Initiator.player.switchPlayer();
            }
        }
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }
}
