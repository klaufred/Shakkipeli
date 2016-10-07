package shakkipeli.domain;

import shakkipeli.logic.ChessPiece;
 /**
 * Class works as an Spot on the board. 
 * It has x and y coordinates and can contain a single chesspiece. 
 */

public class Spot {

    private int x;
    private int y;
    private ChessPiece piece;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int  getY() {
        return this.y;
    }
    
    public ChessPiece getPiece() {
        return this.piece;
    }
    
    public void occupySpot(ChessPiece piece) {
        this.piece = piece;
    }
    
    public boolean checkSpot() {
        return this.piece == null;
    }

}
