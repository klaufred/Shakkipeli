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

public class Bishop extends ChessPiece {
    private String id = "Bishop";
    private ArrayList<Spot> validMoves;

    public Bishop(int x, int y, String color) {
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
            bishopsMoves(board, "Black");
        }
        
        if (this.getColor().equals("Black")) {
            bishopsMoves(board, "White");
        } 
    }
    
    public ArrayList<Spot> getMoves() {
        return this.validMoves;
    }
    
    public void bishopsMoves(Board board, String color) {
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
    } 
}
