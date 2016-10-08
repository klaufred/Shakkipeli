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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void update(Board board) {
    }
    
    public String getId() {
        return null;
    }
    
    public String getColor() {
        return this.color;
    }

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
        this.setX(spot.getX());
        this.setY(spot.getY());
        spot.occupySpot(this);
    }
}
