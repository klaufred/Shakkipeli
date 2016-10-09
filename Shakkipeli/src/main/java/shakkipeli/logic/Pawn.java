package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. Pawns can only move forward.It also has the validMoves list,
 * which contains all the valid moves that the piece can make.
 */

public class Pawn extends ChessPiece {
    
    private String id = "Pawn";
    private boolean firstMove;
    private ArrayList<Spot> validMoves;
    private ArrayList<Spot> firstValidMoves;
    
/**
    * This method creates the Pawn.
     * @param x the pieces given x coordinate.
     * @param y the pieces given y coordinate.
     * @param color the given colour of the Piece(white or black).
    */
    public Pawn(int x, int y, String color) {
        super(x, y, color);
        this.firstMove = true;
        this.firstValidMoves = new ArrayList<>();
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
    * The pawn also has the firstMoves-list to check.
    * @param spot The Spot that the piece is commanded to check.
    * @param board The Board of the game used for the checking.
    * 
    * @return boolean true if the move is valid, false if it is not.
    */
     
    @Override
    public boolean checkMove(Spot spot, Board board) {
        this.updateFirstMove(board);
        this.update(board);
        if (this.firstMove && this.firstValidMoves.contains(spot)) {
            this.firstMove = false;
            return true;
        } else if (this.firstMove == false && this.validMoves.contains(spot)) {
            return true;
        }
        return false;
    }
    
    /**
    * This method updates the firstValidMoves -list,  with all the moves that the 
    * piece can make in that turn. This specific to the Pawn that can only move
    * twice at the beginning.
    * 
    * @param board is the games board needed for the other methods that are 
    * called. 
    */
    
    public void updateFirstMove(Board board) {
        if (this.getColor().equals("White")) { 
            if (board.getSpot(this.getX(), this.getY() + 1).checkSpot()) {
                this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() + 1));
                if (board.getSpot(this.getX(), this.getY() + 2).checkSpot()) {
                    this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() + 2));
                }
            }

            if (board.getSpot(this.getX() + 1, this.getY() + 1).checkSpot() == false) {
                if (board.getSpot(this.getX() + 1, this.getY() + 1).getPiece().getColor().equals("Black")) {
                    this.firstValidMoves.add(board.getSpot(this.getX() + 1, this.getY() + 1));
                    
                }
            }
            
            if (board.getSpot(this.getX() - 1, this.getY() + 1).checkSpot() == false) {
                if (board.getSpot(this.getX() - 1, this.getY() + 1).getPiece().getColor().equals("Black")) {
                    this.firstValidMoves.add(board.getSpot(this.getX() - 1, this.getY() + 1));
                }
            }
        }
        
        if (this.getColor().equals("Black")) {
            if (board.getSpot(this.getX(), this.getY() - 1).checkSpot()) {
                this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() - 1));
                if (board.getSpot(this.getX(), this.getY() - 2).checkSpot()) {
                    this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() - 2));
                }
            }
            
            
            
            if (board.getSpot(this.getX() + 1, this.getY() - 1).checkSpot() == false) {
                if (board.getSpot(this.getX() + 1, this.getY() - 1).getPiece().getColor().equals("White")) {
                    this.firstValidMoves.add(board.getSpot(this.getX() + 1, this.getY() - 1));
                }
            }
            
            if (board.getSpot(this.getX() - 1, this.getY() - 1).checkSpot() == false) {
                if (board.getSpot(this.getX() - 1, this.getY() - 1).getPiece().getColor().equals("White")) {
                    this.firstValidMoves.add(board.getSpot(this.getX() - 1, this.getY() - 1));
                }
            }
        }
    }
    
    /**
    * This method updates the validMoves -list,  with all the moves that the 
    * piece can make in that turn. 
    * 
    * @param board is the games board needed for the other methods that are 
    * called. 
    */
    
    @Override
    public void update(Board board) {
        if (this.firstMove) {
            this.updateFirstMove(board);
        }
        
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            if (board.getSpot(this.getX(), this.getY() + 1).checkSpot()) {
                this.validMoves.add(board.getSpot(this.getX(), this.getY() + 1));
            }
            
            if (board.getSpot(this.getX() + 1, this.getY() + 1).checkSpot() == false) {
                if (board.getSpot(this.getX() + 1, this.getY() + 1).getPiece().getColor().equals("Black")) {
                    this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() + 1));
                }
            }
            
            if (board.getSpot(this.getX() - 1, this.getY() + 1).checkSpot() == false) {
                if (board.getSpot(this.getX() - 1, this.getY() + 1).getPiece().getColor().equals("Black")) {
                    this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() + 1));
                }
            }
        }
        
        if (this.getColor().equals("Black")) {
            if (board.getSpot(this.getX(), this.getY() - 1).checkSpot()) {
                this.validMoves.add(board.getSpot(this.getX(), this.getY() - 1));
            }
            
            if (board.getSpot(this.getX() + 1, this.getY() - 1).checkSpot() == false) {
                if (board.getSpot(this.getX() + 1, this.getY() - 1).getPiece().getColor().equals("White")) {
                    this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() - 1));
                }
            }
            
            if (board.getSpot(this.getX() - 1, this.getY() - 1).checkSpot() == false) {
                if (board.getSpot(this.getX() - 1, this.getY() - 1).getPiece().getColor().equals("White")) {
                    this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() - 1));
                }
            }
        } 
    }
}
