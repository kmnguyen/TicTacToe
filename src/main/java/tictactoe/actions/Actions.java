package tictactoe.actions;

import tictactoe.logic.Logic;
import tictactoe.main.Player;

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
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)(e.getSource());

        this.X = pressed.getX();
        this.Y = pressed.getY();



        if(pressed.getText() == ""){
            pressed.setText(Initiator.player.getSymbol().toString());
        }

        Initiator.logic.updateBoard(Initiator.board, pressed.getX(), pressed.getY(), Initiator.player);
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }
}
