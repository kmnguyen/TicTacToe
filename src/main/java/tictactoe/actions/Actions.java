package tictactoe.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Khoi Nguyen
 */
public class Actions  implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)(e.getSource());

        System.out.println(pressed.getX());
        System.out.println(pressed.getY());

        if(pressed.getText() == ""){
            pressed.setText("Empty");
        }
    }
}
