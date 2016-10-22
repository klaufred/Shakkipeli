
package shakkipeli.logic;

import java.util.ArrayList;
import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;

/**
 * This class tests the games moves for checks.
 * It has the games old board and makes a list of the current pieces of the game.
 */

public class CheckTester {
    private Board board;
    private ArrayList<ChessPiece> list;
    
    /**
    * This method copies the old board and creates a replica of it.
    * It also makes a list of the current pieces and calls the method that sets them.
     * @param oldBoard the current board to be copied.
    */
    public CheckTester(Board oldBoard) {
        this.board = new Board();
        this.list = oldBoard.getPieceList();
        this.setSpecificPieces();
    }
    
    /**
    * This method sets the pieces on the list to the new board on the old spots.
    */
    public void setSpecificPieces() {
        for (ChessPiece piece : this.list) {
            if (piece.getId().equals("Pawn")) {
                this.board.setPiece(new Pawn(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Bishop")) {
                this.board.setPiece(new Bishop(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Queen")) {
                this.board.setPiece(new Queen(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("King")) {
                if (piece.getColor().equals("Black")) {
                    this.board.setBlackKing(piece.getX(), piece.getY());
                } else {
                    this.board.setWhiteKing(piece.getX(), piece.getY());
                }
            } else if (piece.getId().equals("Rook")) {
                this.board.setPiece(new Rook(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Knight")) {
                this.board.setPiece(new Knight(piece.getX(), piece.getY(), piece.getColor()));
            }
        }
    }
    /**
    * This method checks that the player doesn't put it's king in danger.
     * @param movedPiece the piece who's move is tested.
     * @param spot the place were the potential move is made to.
     * @return true if the piece is checking the king, false if not.
    */
    public boolean testForCheckingYourself(ChessPiece movedPiece, Spot spot) {
        ChessPiece copyPiece = this.board.getPiece(movedPiece.getX(), movedPiece.getY());
        Spot copySpot = this.board.getSpot(spot.getX(), spot.getY());
        
        if (copyPiece.checkMove(copySpot, this.board)) {
            copyPiece.move(copySpot, this.board);
            this.list = this.board.getPieceList();
        }
        
        for (ChessPiece piece : this.list) {
            piece.update(board);
            if (!piece.getColor().equals(movedPiece.getColor()) && testCheck(piece) == true) {
                return true;
            }
        }
        return false;
    }
    /**
    * This method checks if the opponent is on check.
     * @param movedPiece the piece who's move is tested.
    */
    public void testForCheckingOpponent(ChessPiece movedPiece) {
        for (ChessPiece piece : this.list) {
            piece.update(board);
            if (movedPiece.getColor().equals(piece.getColor()) && testCheck(piece) == true) {
                System.out.println(piece.getColor() + " " + piece.getId() + " checks King");
                System.out.println("");
            }
        }
    }

    /**
    * This method checks whether the piece puts the king in danger.
     * @param piece the piece that is checked for harming the king.
     * @return true if the piece is checking the king, false if not.
    */
    public boolean testCheck(ChessPiece piece) {
        King king = null;
        if (piece.getColor().equals("White")) {
            king = this.board.getBlackKing();
        } else {
            king = this.board.getWhiteKing();
        }
        
        if (piece.getValidMoves().contains(this.board.getSpot(king.getX(), king.getY()))) {
            return true;
        }
        
        return false;
    }

}
