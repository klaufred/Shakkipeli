package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This class extends the class ChessPiece class. 
 * It has x and y coordinates and is placed the board in a spot.
 * It in addition it also has an id and will check if it can move to the 
 * wanted spot. It will also move to the spot if capable. It is the most 
 * important piece as the game will end if it falls.
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
            kingsMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            kingsMoves(board, "White");
        }
    }
    
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
