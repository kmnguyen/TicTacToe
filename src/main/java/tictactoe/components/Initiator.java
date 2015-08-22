package tictactoe.components;

import tictactoe.timer.Timer;
import tictactoe.gui.GUI;
import tictactoe.logic.Logic;

/**
 * @author Khoi Nguyen
 */

/**
 * This class initialize everything so they could be use once the game start. I apologize
 * for making everything global but due to time constraint, I just do it to make it work.
 */
public class Initiator {

    public static Board board = new Board(); // Initialize board
    public static Logic logic = new Logic(); // Initialize logic

    public static Player player = new Player(Player.Symbol.O); // Initialize new player to be O - could be randomed
    public static Thread thread = new Thread(new Timer()); // Initialize thread for timer

    public static GUI GUI = new GUI(); // Initialize GUI

}
