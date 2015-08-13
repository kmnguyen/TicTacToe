package tictactoe.actions;

import tictactoe.logic.Logic;
import tictactoe.main.Board;
import tictactoe.main.Player;

/**
 * Created by Khoi on 8/12/2015.
 */
public class Initiator {
    public static Board board = new Board();
    public static Logic logic = new Logic();
    public static Player player = new Player(Player.Symbol.O);
}
