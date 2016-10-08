
package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This will be the logics class. It will control the moves on the board.
 */

public class GameLogic {
    private Board board;

    public GameLogic(Board board) {
        this.board = board;
        this.board.setPieces();
    }
    
    public ArrayList<ChessPiece> getList() {
        return this.board.getPieceList();
    }
    
    /* Former method used for the text UI.
    public boolean validMove(String from, String to) {
        ChessPiece piece = findPiece(from);
        return piece.checkMove(findSpot(to), this.board) == true;
    }
    
    */

    /* Former method used for the text UI.
    public void move(String from, String to) {
        ChessPiece piece = findPiece(from);
        piece.move(findSpot(to), this.board);
    }
    */
    
    
    /**
    * This method commands the pieces to move to a new spot.
    * 
     * @param fromX the old x coordinate.
     * @param fromY the old y coordinate.
     * @param toY the new x coordinate.
     * @param toX the new y coordinate.
    */
    public void move(int fromX, int fromY, int toY, int toX) {
        ChessPiece piece = findPiece(fromX, fromY);
        piece.move(findSpot(toX, toY), this.board);
    }
    
    /* Former method used for the text UI.
    public ChessPiece findPiece(String yx) {
        int fromY = translateY(yx.charAt(0));
        int fromX = (yx.charAt(1)) - 1;
        ChessPiece piece = this.board.getPiece(fromX, fromY);
        return piece;
    }    
    */
    
    /**
    * This method find a ChessPiece piece that has the wanted coordinates.
    * 
    * @param x the x coordinate for the piece
    * @param y the y coordinate for the piece
    * 
    * @return the ChessPiece piece in the coordinates
    */
    
    public ChessPiece findPiece(int x, int y) {
        ChessPiece piece = this.board.getPiece(x, y);
        return piece;
    } 
    
    /* Former method used for the text UI.
    public Spot findSpot(String yx) {
        int toX = (yx.charAt(1)) - 1;
        int toY = translateY(yx.charAt(0));
        Spot spot = this.board.getSpot(toX, toY);
        return spot;
    }
    */
    
    /**
    * This method find a spot that has the wanted coordinates.
    * 
    * @param x the x coordinate for the spot
    * @param y the y coordinate for the spot
    * 
    * @return the spot in the coordinates
    */
    public Spot findSpot(int x, int y) {
        Spot spot = this.board.getSpot(x, y);
        return spot;
    }
    
    public Board getBoard() {
        return this.board;
    }
    /* Former text translater for the text UI.
     public int translateY(char y) {
        if (y == 'a') {
            return 0;
        } else if (y == 'b') {
            return 1;
        } else if (y == 'c') {
            return 2;
        } else if (y == 'd') {
            return 3;
        } else if (y == 'e') {
            return 4;
        } else if (y == 'f') {
            return 5;
        } else if (y == 'g') {
            return 6;
        } else  {
            return 7;
        }
        
    }
    */
    
}
