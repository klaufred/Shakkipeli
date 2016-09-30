package logics;

import domain.Spot;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. It will also move to the spot if capable. It is the most 
 * important piece as the game will end if it falls.
 */

public class King extends ChessPiece {
    private String id = "King";

    public King(int x, int y) {
        super(x, y);
    }

    @Override
     public String getId() {
        return this.id;
    }
     
    @Override
    public boolean checkMove(Spot spot) {
        return false;
    }
}
