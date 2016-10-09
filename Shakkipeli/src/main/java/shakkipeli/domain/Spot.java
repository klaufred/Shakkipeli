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
    
    /**
    * This method creates the Spot and gives it the x and y coordinates.
     * @param x the x coordinate of the Spot.
     * @param y the y coordinate of the Spot.
    */

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
    
    /**
    * This method empties the Spot from the ChessPiece.
    */
    public void emptySpot() {
        this.piece = null;
    }
    
    /**
    * This method adds an ChessPiece to the Spot, meaning that the piece is on the Spot.
    * @param piece the piece that is wanted on the Spot
    */
    public void occupySpot(ChessPiece piece) {
        this.piece = piece;
    }
    
    /**
    * This method checks if the Spot has an Piece on it.
    * 
    * @return boolean true if there is no piece on the Spot, false if there is.
    */
    public boolean checkSpot() {
        return this.piece == null;
    }

}
