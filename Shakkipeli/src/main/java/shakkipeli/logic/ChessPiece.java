package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class works as an abstract class for the pieces. 
 * It has x and y coordinates and is placed the board in a spot.
 * It moves itself on the board.
 * 
 */
public abstract class ChessPiece {

    private int x;
    private int y;
    private String color;

    /**
    * This method creates the ChessPiece.
    * @param x the pieces given x coordinate.
    * @param y the pieces given y coordinate.
    * @param color the given colour of the Piece(white or black).
    */
    public ChessPiece(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
/**
    * This method sets the pieces x coordinate.
    * @param x the x coordinate that should be set.
    */
    public void setX(int x) {
        this.x = x;
    }

    /**
    * This method sets the y coordinate.
    * @param y the y coordinate to be set.
    */
    public void setY(int y) {
        this.y = y;
    }
    /**
    * This method updates the listed moves for the pieces. Does nothing for the 
    * abstract class.
    * 
    * @param board is the games board needed for the other methods that are 
    * called. 
    */
    public void update(Board board) {
    }
    
    public String getId() {
        return null;
    }
    
    public String getColor() {
        return this.color;
    }

    /**
    * This method checks if the move is allowed on the board.
     * @param spot where the move is to be made.
     * @param board used to determine the validity.
     * @return boolean true if it is.
    */
    public boolean checkMove(Spot spot, Board board) {
        return false;
    }

    /**
    * This method moves the piece on the board to occupy a spot.
    * 
    * @param spot were the piece is going to move.
    * @param board of the game need to check the moves.
    */
    
    public void move(Spot spot, Board board) {
        board.getSpot(this.getX(), this.getY()).emptySpot();
        this.setX(spot.getX());
        this.setY(spot.getY());
        spot.occupySpot(this);
    }
}
