package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id, and an colour and will check if it can move to the 
 * wanted spot.Bishops can only move diagonally.It also has the validMoves list,
 * which contains all the valid moves that the piece can make.
 */

public class Bishop extends ChessPiece {
    private String id = "Bishop";
    private ArrayList<Spot> validMoves;
    
    /**
    * This method creates the Bishop.
     * @param x the pieces given x coordinate.
     * @param y the pieces given y coordinate.
     * @param color the given colour of the Piece(white or black).
    */
    public Bishop(int x, int y, String color) {
        super(x, y, color);
        this.validMoves = new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }
    
    /**
    * This method checks if the piece is capable of making the wanted move. It 
    * calls the update-method at the beginning to update the validMoves list.
    * It then checks the given Spot to see if it is in the list of valid moves.
     * @param spot The Spot that the piece is commanded to check.
     * @param board The Board of the game used for the checking.
     * 
     * @return boolean true if the move is valid, false if it is not.
    */
    
    @Override
    public boolean checkMove(Spot spot, Board board) {
        this.update(board);
        if (this.validMoves.contains(spot)) {
            return true;
        }
        return false;
    }
    
    /**
    * This method updates the validMoves -list,  with all the moves that the 
    * piece can make in that turn. It also calls the bishopsMoves-method that is 
    * given the colour of the piece.
    * 
    * @param board is the games board needed for the other methods that are 
    * called. 
    */
    
    @Override
    public void update(Board board) { 
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            bishopsMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            bishopsMoves(board, "White");
        } 
    }
    
    /**
    * This method adds the possible moves of the Bishop into the validMoves -list
    * The Bishop's moves are diagonal.
    * 
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    
    public void bishopsMoves(Board board, String color) {
        int toX = this.getX() + 1;
        int toY = this.getY() + 1;
        while (toX <= 7 && toY <= 7) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX++;
            toY++;
        }
        
        toX = this.getX() - 1;
        toY = this.getY() + 1;
        while (toX >= 0 && toY <= 7) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX--;
            toY++;
        }
        
        toX = this.getX() + 1;
        toY = this.getY() - 1;
        while (toX <= 7 && toY >= 0) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX++;
            toY--;
        }
        
        toX = this.getX() - 1;
        toY = this.getY() - 1;
        while (toX >= 0 && toY >= 0) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX--;
            toY--;
        }
    }
    /**
    * This method checks that the wanted coordinates are on the spot and the spot is empty
    * and add the spot to the list of valid moves.
    * @param board of the game to find the Spot.
    * @param x the x-coordinates of the Spot.
    * @param y the y-coordinates of the Spot.
    * @return boolean true if the Spot is on the board and not occupied.
    */
    public boolean addToListIfNotOccupied(Board board, int x, int y) {
        if (super.checkTheEdges(x, y)) {
            if (board.getSpot(x, y).checkSpot()) {
                this.validMoves.add(board.getSpot(x, y));
                return true;
            }
        }
        return false;
    }
    
    /**
    * This method checks if the there is a similar colour piece on the spot and
    * adds the spot to the list if there is not.
    * @param board of the game to find the Spot
    * @param color of the piece to identify the enemies.
    * @param x the x-coordinates of the Spot.
    * @param y the y-coordinates of the Spot.
    */
    public void addToListIfOccupied(Board board, String color, int x, int y) {
        if (super.checkTheEdges(x, y)) {
            if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(x, y));
            }
        }
    }
}
