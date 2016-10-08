package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. It is the most important piece as the game will end if it falls.
 * Kings can only move one spot to any direction.It also has the validMoves list
 * , which contains all the valid moves that the piece can make.
 */

public class King extends ChessPiece {
    private String id = "King";
    private ArrayList<Spot> validMoves;

    public King(int x, int y, String color) {
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
    * piece can make in that turn. It also calls the kingsMoves-method that is 
    * given the colour of the piece.
    * 
     * @param board is the games board needed for the other methods that are 
     * called. 
    */
    
    @Override
    public void update(Board board) { 
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            kingsMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            kingsMoves(board, "White");
        }
    }
    
    /**
    * This method adds the possible moves of the King into the validMoves -list
    * The King can only move one spot to any direction.
    * 
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    
    public void kingsMoves(Board board, String color) {
        if (board.getSpot(this.getX() - 1, this.getY() - 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() - 1));
        } else {
            if (board.getSpot(this.getX() - 1, this.getY() - 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() - 1));
            }
        }
        
        if (board.getSpot(this.getX() - 1, this.getY() + 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() + 1));
        } else {
            if (board.getSpot(this.getX() - 1, this.getY() + 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() + 1));
            }
        }
        
        if (board.getSpot(this.getX() + 1, this.getY() + 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() + 1));
        } else {
            if (board.getSpot(this.getX() + 1, this.getY() + 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() + 1));
            }
        }
        
        if (board.getSpot(this.getX() + 1, this.getY() - 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() - 1));
        } else {
            if (board.getSpot(this.getX() + 1, this.getY() - 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() - 1));
            }
        }
        
        if (board.getSpot(this.getX(), this.getY() - 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX(), this.getY() - 1));
        } else {
            if (board.getSpot(this.getX(), this.getY() - 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX(), this.getY() - 1));
            }
        }
        
        if (board.getSpot(this.getX() - 1, this.getY()).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 1, this.getY()));
        } else {
            if (board.getSpot(this.getX() - 1, this.getY()).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 1, this.getY()));
            }
        }
        
        if (board.getSpot(this.getX(), this.getY() + 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX(), this.getY() + 1));
        } else {
            if (board.getSpot(this.getX(), this.getY() + 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX(), this.getY() + 1));
            }
        }
        
        if (board.getSpot(this.getX() + 1, this.getY()).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 1, this.getY()));
        } else {
            if (board.getSpot(this.getX() + 1, this.getY()).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 1, this.getY()));
            }
        }
    }
}
