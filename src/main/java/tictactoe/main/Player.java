package tictactoe.main;

import java.util.List;
import java.util.Map;

/**
 * Created by Khoi on 8/10/2015.
 */
public class Player {

    public enum Symbol {
        X, O;
    }

    private Symbol symbol;
    private Boolean won = false;


    public Player(Symbol symbol){
        this.symbol = symbol;
    }

    public Player.Symbol getSymbol(){
        return symbol;
    }

    public void setWon(Boolean won){
        this.won = won;
    }

    public Boolean getWon(){
        return won;
    }
}
