package tictactoe.components;

/**
 * @author Khoi Nguyen
 */
public class Player {

    public enum Symbol {
        X, O
    }

    private Symbol symbol;

    public Player(Symbol symbol){
        this.symbol = symbol;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public Player.Symbol getSymbol(){
        return symbol;
    }

    public void switchPlayer(){
        if(this.symbol == Symbol.X){
            setSymbol(Symbol.O);
        } else {
            setSymbol(Symbol.X);
        }
        Initiator.GUI.setPlayer();
    }
}
