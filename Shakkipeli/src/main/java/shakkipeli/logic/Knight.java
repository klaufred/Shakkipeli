package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot.Knights can move by hopping over other pieces in an L-formation.
 * It also has the validMoves list,which contains all the valid moves that the 
 * piece can make.
 */

public class Knight extends ChessPiece {
    private String id = "Knight";
    private ArrayList<Spot> validMoves;

    /**
    * This method creates the Knight.
     * @param x the pieces given x coordinate.
     * @param y the pieces given y coordinate.
     * @param color the given colour of the Piece(white or black).
    */
    public Knight(int x, int y, String color) {
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
    * piece can make in that turn. It also calls the knightsMoves-method that is 
    * given the colour of the piece.
    * 
     * @param board is the games board needed for the other methods that are 
     * called. 
    */
    
    @Override
    public void update(Board board) { 
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            knightsMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            knightsMoves(board, "White");
        } 
    }
    
    /**
    * This method adds the possible moves of the Knight into the validMoves -list
    * The Knight move by hopping from one spot to another in an L-formation.
    * 
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    
    public void knightsMoves(Board board, String color) {
        addToListIfCorrect(board, this.getX() - 2, this.getY() + 1, color);
        addToListIfCorrect(board, this.getX() - 2, this.getY() - 1, color);
        addToListIfCorrect(board, this.getX() + 2, this.getY() + 1, color);
        addToListIfCorrect(board, this.getX() + 2, this.getY() - 1, color);
        addToListIfCorrect(board, this.getX() - 1, this.getY() - 2, color);
        addToListIfCorrect(board, this.getX() - 1, this.getY() + 2, color);
        addToListIfCorrect(board, this.getX() + 1, this.getY() - 2, color);
        addToListIfCorrect(board, this.getX() + 1, this.getY() + 2, color);
    }
    /**
    * This method checks that the wanted coordinates are on the spot and the spot is empty
    * and adds the spot to the list of valid moves if it is empty of occupied by
    * an enemy.
    * @param board of the game to find the Spot.
    * @param x the x-coordinates of the Spot.
    * @param y the y-coordinates of the Spot.
    * @param color of the enemy.
    */
    public void addToListIfCorrect(Board board, int x, int y, String color) {
        if (super.checkTheEdges(x, y)) {
            if (board.getSpot(x, y).checkSpot()) {
                this.validMoves.add(board.getSpot(x, y));
            } else {
                if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                    this.validMoves.add(board.getSpot(x, y));
                }
            }
        }
    }
}
