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
            rooksMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            rooksMoves(board, "White");
        } 
    }
    
    public ArrayList<Spot> getMoves() {
        return this.validMoves;
    }
    
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
