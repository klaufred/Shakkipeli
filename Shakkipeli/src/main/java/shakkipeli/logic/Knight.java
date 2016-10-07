package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. It will also move to the spot if capable.
 */

public class Knight extends ChessPiece {
    private String id = "Knight";
    private ArrayList<Spot> validMoves;

    public Knight(int x, int y, String color) {
        super(x, y, color);
        this.validMoves = new ArrayList<>();
    }
    
    @Override
     public String getId() {
        return this.id;
    }
     
    @Override
    public boolean checkMove(Spot spot, Board board) {
        this.update(board);
        if (this.validMoves.contains(spot)) {
            return true;
        }
        return false;
    }
    
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
    
    public void knightsMoves(Board board, String color) {
        if (board.getSpot(this.getX() - 2, this.getY() + 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 2, this.getY() + 1));
        } else {
            if (board.getSpot(this.getX() - 2, this.getY() + 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 2, this.getY() + 1));
            }
        }
            
        if (board.getSpot(this.getX() - 2, this.getY() - 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 2, this.getY() - 1));
        } else {
            if (board.getSpot(this.getX() - 2, this.getY() - 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 2, this.getY() - 1));
            }
        }
            
        if (board.getSpot(this.getX() + 2, this.getY() + 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 2, this.getY() + 1));
        } else {
            if (board.getSpot(this.getX() + 2, this.getY() + 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 2, this.getY() + 1));
            }
        }
            
        if (board.getSpot(this.getX() + 2, this.getY() - 1).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 2, this.getY() - 1));
        } else {
            if (board.getSpot(this.getX() + 2, this.getY() - 1).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 2, this.getY() - 1));
            }
        }
            
        if (board.getSpot(this.getX() - 1, this.getY() - 2).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() - 2));
        } else {
            if (board.getSpot(this.getX() - 1, this.getY() - 2).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() - 2));
            }
        }
            
        if (board.getSpot(this.getX() - 1, this.getY() + 2).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() + 2));
        } else {
            if (board.getSpot(this.getX() - 1, this.getY() + 2).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() - 1, this.getY() + 2));
            }
        }
            
        if (board.getSpot(this.getX() + 1, this.getY() + 2).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() + 2));
        } else {
            if (board.getSpot(this.getX() + 1, this.getY() + 2).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() + 2));
            }
        }
            
        if (board.getSpot(this.getX() + 1, this.getY() - 2).checkSpot()) {
            this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() - 2));
        } else {
            if (board.getSpot(this.getX() + 1, this.getY() - 2).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(this.getX() + 1, this.getY() - 2));
            }
        }
    }
}
