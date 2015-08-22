package tictactoe.components;

import tictactoe.timer.Timer;
import tictactoe.gui.GUI;
import tictactoe.logic.Logic;

/**
 * @author Khoi Nguyen
 */
public class Initiator {
    public static Board board = new Board();
    public static Logic logic = new Logic();
    public static Player player = new Player(Player.Symbol.O);
    public static Thread thread = new Thread(new Timer());
    public static GUI GUI = new GUI();

}
