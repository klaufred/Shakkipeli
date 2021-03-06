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
    
    /**
    * This method creates the Queen.
    * @param x the pieces given x coordinate.
    * @param y the pieces given y coordinate.
    * @param color the given colour of the Piece(white or black).
    */
    public Queen(int x, int y, String color) {
        super(x, y, color);
        this.validMoves = new ArrayList<>();
    }
    
    @Override
    public ArrayList<Spot> getValidMoves() {
        return this.validMoves;
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
    * @return boolean true if the move is valid, false if it is not.
    */
    @Override
    public boolean checkMove(Spot spot, Board board) {
        this.update(board);
        return this.validMoves.contains(spot);
    }
    
    /**
    * This method updates the validMoves -list,  with all the moves that the 
    * piece can make in that turn. It also calls the queensMoves-method that is 
    * given the colour of the piece.
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
    * This method calls the methods that add the possible sideways and diagonal moves of the Queen into the validMoves -list.
    * The Queen has the moves of the rook and the bishop.
    * @param board of the game need to check the moves.
    * @param color of the piece to identify the enemies.
    */
    public void queensMoves(Board board, String color) {
        this.queensMovesRight(board, color);
        this.queensMovesLeft(board, color);
        this.queensMovesForward(board, color);
        this.queensMovesBackward(board, color);
        this.queensMovesLeftAndBackward(board, color);
        this.queensMovesLeftAndForward(board, color);
        this.queensMovesRightAndBackward(board, color);
        this.queensMovesRightAndForward(board, color);
    }
    /**
     * This method add all possible moves for the queen on the forward side of the board.
     * @param board used by the method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesForward(Board board, String color) {
        for (int y = this.getY() - 1; y >= 0; y--) {
            if (addToListIfNotOccupied(board, this.getX(), y) == false) { 
                addToListIfOccupied(board, color, this.getX(), y);
                break;
            }
        }
    }
    /**
     * This method add all possible moves for the queen on the backward side of the board.
     * @param board used by the method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesBackward(Board board, String color) {
        for (int y = this.getY() + 1; y <= 7; y++) {
            if (addToListIfNotOccupied(board, this.getX(), y) == false) { 
                addToListIfOccupied(board, color, this.getX(), y);
                break;
            }
        }
    }
    
    /**
     * This method add all possible moves for the queen on the right side of the board.
     * @param board used by the method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesRight(Board board, String color) {
        for (int x = this.getX() + 1; x <= 7; x++) {
            if (addToListIfNotOccupied(board, x, this.getY()) == false) { 
                addToListIfOccupied(board, color, x, this.getY());
                break;
            }
        }
    }
    /**
     * This method add all possible moves for the queen on the left side of the board.
     * @param board used by the method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesLeft(Board board, String color) {
        for (int x = this.getX() - 1; x >= 0; x--) {
            if (addToListIfNotOccupied(board, x, this.getY()) == false) { 
                addToListIfOccupied(board, color, x, this.getY());
                break;
            }
        }
    }
    
    /**
     * This method add all possible moves for the queen diagonally in the right and forward direction.
     * @param board used by the listing method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesRightAndForward(Board board, String color) {
        int toX = this.getX() + 1;
        int toY = this.getY() - 1;
        while (toX <= 7 && toY >= 0) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX++;
            toY--;
        }
    }
    /**
     * This method add all possible moves for the queen diagonally in the right and backward direction.
     * @param board used by the listing method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesRightAndBackward(Board board, String color) {
        int toX = this.getX() + 1;
        int toY = this.getY() + 1;
        while (toX <= 7 && toY <= 7) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX++;
            toY++;
        }
    }
    /**
     * This method add all possible moves for the queen diagonally in the left and backward direction.
     * @param board used by the listing method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesLeftAndBackward(Board board, String color) {
        int toX = this.getX() - 1;
        int toY = this.getY() + 1;
        while (toX >= 0 && toY <= 7) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX--;
            toY++;
        }
    }
    /**
     * This method add all possible moves for the queen diagonally in the left and forward direction.
     * @param board used by the listing method that this method calls.
     * @param color the color of the piece to identify the enemies.
     */
    public void queensMovesLeftAndForward(Board board, String color) {
        int toX = this.getX() - 1;
        int toY = this.getY() - 1;
        while (toX >= 0 && toY >= 0) {
            if (addToListIfNotOccupied(board, toX, toY) == false) { 
                addToListIfOccupied(board, color, toX, toY);
                break;
            }
            
            toX--;
            toY--;
        }
    }
    /**
    * This method checks that the wanted coordinates are on the spot and the spot is empty
    * and add the spot to the list of valid moves.
    * @param board of the game to find the Spot.
    * @param x the x-coordinates of the Spot.
    * @param y the y-coordinates of the Spot.
    * @return boolean true if the Spot is on the board and not occupied.
    */
    public boolean addToListIfNotOccupied(Board board, int x, int y) {
        if (super.checkTheEdges(x, y)) {
            if (board.getSpot(x, y).checkSpot()) {
                this.validMoves.add(board.getSpot(x, y));
                return true;
            }
        }
        return false;
    }
    /**
    * This method checks if the there is a similar colour piece on the spot and
    * adds the spot to the list if there is not.
    * @param board of the game to find the Spot
    * @param color of the piece to identify the enemies.
    * @param x the x-coordinates of the Spot.
    * @param y the y-coordinates of the Spot.
    */
    public void addToListIfOccupied(Board board, String color, int x, int y) {
        if (super.checkTheEdges(x, y)) {
            if (board.getSpot(x, y).getPiece().getColor().equals(color)) {
                this.validMoves.add(board.getSpot(x, y));
            }
        }
    }
}
