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

public class Pawn extends ChessPiece {
    
    private String id = "Pawn";
    private boolean firstMove;
    private ArrayList<Spot> validMoves;
    private ArrayList<Spot> firstValidMoves;

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
     
    @Override
    public boolean checkMove(Spot spot, Board board) {
        this.update(board);
        if (this.firstMove && this.firstValidMoves.contains(spot)) {
            return true;
        } else if (this.firstMove == false && this.validMoves.contains(spot)) {
            return true;
        }
        return false;
    }
    
    public void updateFirstMove(Board board) {
        if (this.getColor().equals("White")) { 
            if (board.getSpot(this.getX(), this.getY() + 1).checkSpot()) {
                this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() + 1));
            }
            
            if (board.getSpot(this.getX(), this.getY() + 2).checkSpot()) {
                this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() + 2));
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
            }
            
            if (board.getSpot(this.getX(), this.getY() - 2).checkSpot()) {
                this.firstValidMoves.add(board.getSpot(this.getX(), this.getY() - 2));
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
            if (board.getSpot(this.getX(), this.getY() + 1).checkSpot()) {
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
    
    
    @Override
    public void move(Spot spot, Board board) {
        this.setX(spot.getX());
        this.setY(spot.getY());
        spot.occupySpot(this);
        
        this.firstMove = false;
    }
}
