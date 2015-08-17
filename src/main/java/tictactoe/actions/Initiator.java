package tictactoe.actions;

import tictactoe.Thread.Timer;
import tictactoe.TicTacToeGUI.TicTacToeGUI;
import tictactoe.logic.Logic;
import tictactoe.main.Board;
import tictactoe.main.Player;

/**
 * @author Khoi Nguyen
 */
public class Initiator {
    public static Board board = new Board();
    public static Logic logic = new Logic();
    public static Player player = new Player(Player.Symbol.O);
    public static Thread thread = new Thread(new Timer());
    public static TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();

}
