package tictactoe.components;

/**
 * @author Khoi Nguyen
 */

/**
 * This class represent the player. It will keep track of every move of each player.
 */
public class Player {

    // X and O to represents each player
    public enum Symbol {
        X, O
    }

    private Symbol symbol;

    /**
     * Initialize the player with a respective symbol
     *
     * @param symbol enum symbol
     */
    public Player(Symbol symbol){
        this.symbol = symbol;
    }

    /**
     * Set symbol for a player
     *
     * @param symbol enum symbol
     */
    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    /**
     * Retrieve a symbol for a player
     *
     * @return a symbol for a player
     */
    public Player.Symbol getSymbol(){
        return symbol;
    }

    /**
     * Switch player's symbol after a move is made
     */
    public void switchPlayer(){
        if(this.symbol == Symbol.X){
            setSymbol(Symbol.O);
        } else {
            setSymbol(Symbol.X);
        }
        Initiator.GUI.setPlayer();
    }
}
