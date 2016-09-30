package logics;

import domain.Spot;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. It will also move to the spot if capable.
 */

public class Rook extends ChessPiece {
    private String id = "Rook";

    public Rook(int x, int y) {
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
