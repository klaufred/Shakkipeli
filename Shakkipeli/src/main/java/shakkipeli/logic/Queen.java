package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. The Queen can has the bishop's and the rook's moves. It also has
 * validMoves-list, which contains the valid moves of the time.
 */

public class Queen extends ChessPiece {
    
    private String id = "Queen";
    private ArrayList<Spot> validMoves;

    public Queen(int x, int y, String color) {
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
    * piece can make in that turn. It also calls the queensMoves-method that is 
    * given the colour of the piece.
    * 
    * @param board is the games board needed for the other methods that are 
    * called. 
    */
    
    @Override
    public void update(Board board) { 
        this.validMoves.clear();
        
        if (this.getColor().equals("White")) {
            queensMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            queensMoves(board, "White");
        } 
    }
    
    public ArrayList<Spot> getMoves() {
        return this.validMoves;
    }
    /**
    * This method adds the possible moves of the Queen into the validMoves -list.
    * The Queen has the moves of the rook and the bishop.
    * 
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    public void queensMoves(Board board, String color) {
        for (int x = this.getX() + 1; x <= 7; x++) {
            boolean toBreak = true;
            for (int y = this.getY() + 1; y <= 7; y++) {
                if (board.getSpot(x, y).checkSpot()) { 
                    this.validMoves.add(board.getSpot(x, y));
                } else if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                    this.validMoves.add(board.getSpot(x, y));
                    toBreak = false;
                    break;
                } else {
                    toBreak = false;
                    break;
                } 
            }
            if (toBreak == false) {
                break;
            }
        }
        
        for (int x = this.getX() + 1; x <= 7; x++) {
            boolean toBreak = true;
            for (int y = this.getY() - 1; y >= 0; y--) {
                if (board.getSpot(x, y).checkSpot()) { 
                    this.validMoves.add(board.getSpot(x, y));
                } else if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                    this.validMoves.add(board.getSpot(x, y));
                    toBreak = false;
                    break;
                } else {
                    toBreak = false;
                    break;
                }
            }
            if (toBreak == false) {
                break;
            }
        }
        
        for (int x = this.getX() - 1; x >= 0; x--) {
            boolean toBreak = true;
            for (int y = this.getY() + 1; y <= 7; y++) {
                if (board.getSpot(x, y).checkSpot()) { 
                    this.validMoves.add(board.getSpot(x, y));
                } else if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                    this.validMoves.add(board.getSpot(x, y));
                    toBreak = false;
                    break;
                } else {
                    toBreak = false;
                    break;
                }
            }
            if (toBreak == false) {
                break;
            }
        }
        
        for (int x = this.getX() - 1; x >= 0; x--) {
            boolean toBreak = true;
            for (int y = this.getY() - 1; y >= 0; y--) {
                if (board.getSpot(x, y).checkSpot()) { 
                    this.validMoves.add(board.getSpot(x, y));
                } else if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                    this.validMoves.add(board.getSpot(x, y));
                    toBreak = false;
                    break;
                } else {
                    toBreak = false;
                    break;
                }
            }
            if (toBreak == false) {
                break;
            }
        }
        
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
