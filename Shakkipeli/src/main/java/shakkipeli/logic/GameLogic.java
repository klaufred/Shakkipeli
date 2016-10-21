
package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;
import java.util.ArrayList;

/**
 * This will be the logics class. It will control the moves on the board.
 */

public class GameLogic {
    private Board board;
    private String currentTurnsColor;
    private boolean gameStatus;

    /**
    * This method gives the logic the board and sets the pieces on it.
    */
    public GameLogic() {
        this.board = new Board();
        this.board.setPieces();
        this.currentTurnsColor = "White";
        this.gameStatus = true;
    }
    
    /**
    * This method return a list of all the pieces in the game.
    * 
    * @return  ArrayList of ChessPieces that exist in the game.
    */
    public ArrayList<ChessPiece> getList() {
        return this.board.getPieceList();
    }
    /**
    * This method find a ChessPiece piece that has the wanted coordinates.
    * 
    * @param x the x coordinate for the piece
    * @param y the y coordinate for the piece
    * 
    * @return the ChessPiece piece in the coordinates
    */
    
    public ChessPiece findPiece(int x, int y) {
        ChessPiece piece = this.board.getPiece(x, y);
        return piece;
    } 
    /**
    * This method find a spot that has the wanted coordinates.
    * 
    * @param x the x coordinate for the spot
    * @param y the y coordinate for the spot
    * 
    * @return the spot in the coordinates
    */
    public Spot findSpot(int x, int y) {
        Spot spot = this.board.getSpot(x, y);
        return spot;
    }
    /**
    * This method commands the pieces to move to a new spot. And checks if the game is over.
     * @param piece the piece chosen to move.
     * @param spot the Spot were the piece will move.
     * @return boolean false if the game is still going, true if it is over.
    */
    public boolean movePiece(ChessPiece piece, Spot spot) {
        CheckTester tester = new CheckTester(this.board);
        
        if (piece.checkMove(spot, this.board) && kingChecked(piece) == false) {
            if (tester.testForCheckingYourself(piece, spot) == false) {
                piece.move(spot, this.board);
                changeIfPawnAtEdge(piece, "Queen");
                if (tester.testForCheckingOpponent(piece, spot) == true) {
                    piece.choose(false);
                    changeTurn();
                    return true;
                }
                piece.choose(false);
                changeTurn();
            }
        }
        return false;
    }

    /**
    * This method returns the current players colour.
     * @return String colour of the current player.
    */
    public String turnColor() {
        return this.currentTurnsColor;
    }
    /**
    * This method changes the turn for the next player.
    */
    public void changeTurn() {
        if (this.currentTurnsColor.equals("White")) {
            this.currentTurnsColor = "Black";
        } else if (this.currentTurnsColor.equals("Black")) {
            this.currentTurnsColor = "White";
        }
    }
    /**
    * This method changes the pawn at edge in to an other piece.
     * @param piece the pawn to be changed.
     * @param id the id of the new piece.
    */
    public void changeIfPawnAtEdge(ChessPiece piece, String id) {
        if (piece.getId().equals("Pawn") && (piece.getY() == 7 || piece.getY() == 0)) {
            int intX = piece.getX();
            int intY = piece.getY();
            String color = piece.getColor();
            this.board.getSpot(intX, intY).emptySpot();
            if (id.equals("Queen")) {
                this.board.getSpot(intX, intY).occupySpot(new Queen(intX, intY, color));
            } else if (id.equals("Bishop")) {
                this.board.getSpot(intX, intY).occupySpot(new Bishop(intX, intY, color));
            } else if (id.equals("Rook")) {
                this.board.getSpot(intX, intY).occupySpot(new Rook(intX, intY, color));
            } else if (id.equals("Knight")) {
                this.board.getSpot(intX, intY).occupySpot(new Knight(intX, intY, color));
            }
            
        }
    }

    public Board getBoard() {
        return this.board;
    }

    /**
    * This method checks the games status and sends it along.
     * @return true if the game is going on, false if it is over.
    */
    public boolean getGameStatus() {
        return gameStatus;
    }

    /**
    * This method changes the games status to be false.
    */
    public void checkGameOver() {
        this.gameStatus = false;  
    }

    /**
    * This method checks if the pieces king is checked.
     * @param piece that is on the kings side.
     * @return true if the king is checked.
    */
    public boolean kingChecked(ChessPiece piece) {
        King king = null;
        if (piece.getColor().equals("White")) {
            king = this.board.getWhiteKing();
        } else {
            king = this.board.getBlackKing();
        }
        
        return king.isChecked();
    }
}
