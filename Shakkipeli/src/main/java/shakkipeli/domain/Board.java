package shakkipeli.domain;

import java.util.ArrayList;
import shakkipeli.logic.Bishop;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.Knight;
import shakkipeli.logic.Queen;
import shakkipeli.logic.Rook;
import shakkipeli.logic.King;
import shakkipeli.logic.Pawn;

/**
 * This is the board. It has 36 spots which contain the pieces. Every move is
 * made on it and it sets the pieces on their starting spots. it also informs to
 * Gamelogic-class when one of the Kings has fallen.
 *
 */
public class Board {

    private Spot[][] spots;
    private boolean gameStatus;

 /**
 * This method creates the board out of Spots. The Board is essentially Spot[][]
 * this.spots- attribute.
 */
    public Board() {
        this.gameStatus = true;
        this.spots = new Spot[8][8];

        for (int x = 0; x < this.spots.length; x++) {
            for (int y = 0; y < this.spots.length; y++) {
                this.spots[x][y] = new Spot(x, y);
            }
        }
    }

    /**
    * This method returns the Spot that correlates with the given coordinates.
     * @param x the x coordinates of the wanted spot.
     * @param y the y coordinates for the wanted spot.
     * @return Spot that is in the wanted coordinates
    */
    
    public Spot getSpot(int x, int y) {
        return this.spots[x][y];
    }

    /**
    * This method creates and puts the ChessPiece- class pieces on the Spot[][]
    * -formed board. 
    */
    
    public void setPieces() {
        for (int x = 0; x < 8; x++) {
            this.spots[x][1].occupySpot(new Pawn(x, 1, "White"));
        }

        this.spots[4][0].occupySpot(new King(4, 0, "White"));
        this.spots[3][0].occupySpot(new Queen(3, 0, "White"));
        this.spots[0][0].occupySpot(new Rook(0, 0, "White"));
        this.spots[7][0].occupySpot(new Rook(7, 0, "White"));
        this.spots[2][0].occupySpot(new Bishop(2, 0, "White"));
        this.spots[5][0].occupySpot(new Bishop(5, 0, "White"));
        this.spots[1][0].occupySpot(new Knight(1, 0, "White"));
        this.spots[6][0].occupySpot(new Knight(6, 0, "White"));

        for (int x = 0; x < 8; x++) {
            this.spots[x][6].occupySpot(new Pawn(x, 6, "Black"));
        }

        this.spots[4][7].occupySpot(new King(4, 7, "Black"));
        this.spots[3][7].occupySpot(new Queen(3, 7, "Black"));
        this.spots[0][7].occupySpot(new Rook(0, 7, "Black"));
        this.spots[7][7].occupySpot(new Rook(7, 7, "Black"));
        this.spots[2][7].occupySpot(new Bishop(2, 7, "Black"));
        this.spots[5][7].occupySpot(new Bishop(5, 7, "Black"));
        this.spots[1][7].occupySpot(new Knight(1, 7, "Black"));
        this.spots[6][7].occupySpot(new Knight(6, 7, "Black"));
    }

    /**
    * This method checks if the game is over.
    * 
    * @return  a boolean true if the game is still going false if it is over.
    */
    public boolean gameOver() {
        return this.gameStatus;
    }

    /**
    * This method will change the gameStatus, meaning that the game is over.
    * 
    */
    public void checkMate() {
        this.gameStatus = false;
    }

    /**
    * This method returns the piece in the coordinates.
    * @param x the pieces given x coordinate.
    * @param y the pieces given y coordinate.
    * @return ChessPiece assigned to the coordinates.
    */
    public ChessPiece getPiece(int x, int y) {
        return this.spots[x][y].getPiece();
    }
    /**
    * This method creates an ArrayList of the pieces and returns it.
    * @return the said ArrayList of 'ChessPieces.
    */
    public ArrayList<ChessPiece> getPieceList() {
        ArrayList<ChessPiece> pieceList = new ArrayList<>();
        for (int x = 0; x < this.spots.length; x++) {
            for (int y = 0; y < this.spots.length; y++) {
                if (this.spots[x][y].getPiece() != null) {
                    pieceList.add(this.spots[x][y].getPiece());
                }
            }
        }
        return pieceList;
    }
}
