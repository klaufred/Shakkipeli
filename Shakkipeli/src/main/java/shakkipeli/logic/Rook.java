package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. Rooks can move forward, backward or to the sides. It also has 
 * the validMoves list, which contains all the valid moves that the piece can 
 * make.
 */

public class Rook extends ChessPiece {
    private String id = "Rook";
    private ArrayList<Spot> validMoves;

    public Rook(int x, int y, String color) {
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
    * piece can make in that turn. It also calls the rooksMoves-method that is 
    * given the colour of the piece.
    * 
     * @param board is the games board needed for the other methods that are 
     * called. 
    */
    
    @Override
    public void update(Board board) { 
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            rooksMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            rooksMoves(board, "White");
        } 
    }
    
    /**
    * This method adds the possible moves of the Rook into the validMoves -list
    * The Rook can move forward, backward, and to the sides.
    * 
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    public void rooksMoves(Board board, String color) {
        for (int y = this.getY() - 1; y >= 0; y--) {
            if (board.getSpot(this.getX(), y).checkSpot()) { 
                this.validMoves.add(board.getSpot(this.getX(), y));
            } else if (board.getSpot(this.getX(), y).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX(), y));
                break;
            } else {
                break;
            }
        }
        
        for (int x = this.getX() + 1; x <= 7; x++) {
            if (board.getSpot(x, this.getY()).checkSpot()) { 
                this.validMoves.add(board.getSpot(x, this.getY()));
            } else if (board.getSpot(x, this.getY()).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(x, this.getY()));
                break;
            } else {
                break;
            }
        }
        
        for (int x = this.getX() - 1; x >= 0; x--) {
            if (board.getSpot(x, this.getY()).checkSpot()) { 
                this.validMoves.add(board.getSpot(x, this.getY()));
            } else if (board.getSpot(x, this.getY()).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(x, this.getY()));
                break;
            } else {
                break;
            }
        }
        
        for (int y = this.getY() + 1; y <= 7; y++) {
            if (board.getSpot(this.getX(), y).checkSpot()) { 
                this.validMoves.add(board.getSpot(this.getX(), y));
            } else if (board.getSpot(this.getX(), y).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX(), y));
                break;
            } else {
                break;
            }
        }
    }    
}
