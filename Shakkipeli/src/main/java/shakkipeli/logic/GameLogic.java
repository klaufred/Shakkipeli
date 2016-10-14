
package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This will be the logics class. It will control the moves on the board.
 */

public class GameLogic {
    private Board board;
    private String currentTurnsColor;

    /**
    * This method gives the logic the board and sets the pieces on it.
    * @param board where the game is to be played.
    */
    public GameLogic(Board board) {
        this.board = board;
        this.board.setPieces();
        this.currentTurnsColor = "White";
    }
    
    /**
    * This method return a list of all the pieces in the game.
    * 
    * @return  ArrayList of ChessPieces that exist in the game.
    */
    public ArrayList<ChessPiece> getList() {
        return this.board.getPieceList();
    }
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
    /**
    * This method commands the pieces to move to a new spot.
     * @param piece the piece chosen to move.
     * @param spot the Spot were the piece will move.
    */
    public void movePiece(ChessPiece piece, Spot spot) {
        if (piece.checkMove(spot, this.board))  {
            piece.move(spot, this.board);
            piece.choose(false);
            changeTurn();
        }
    }

    /**
    * This method returns the current players colour.
     * @return String colour of the current player.
    */
    public String turnColor() {
        return this.currentTurnsColor;
    }
    /**
    * This method changes the turn for the next player.
    */
    public void changeTurn() {
        if (this.currentTurnsColor.equals("White")) {
            this.currentTurnsColor = "Black";
        } else if (this.currentTurnsColor.equals("Black")) {
            this.currentTurnsColor = "White";
        }
    }
}
