package domain;

import logics.ChessPiece;
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
    
    public void emptySpot() {
        if (this.piece != null) {
            this.piece.removePiece();
        }
        this.piece = null;
    }
    
    public void occupySpot(ChessPiece piece) {
        if (this.piece == null) {
            this.piece = piece;
        }
    }
    
    public boolean checkSpot() {
        return this.piece == null;
    }

}
