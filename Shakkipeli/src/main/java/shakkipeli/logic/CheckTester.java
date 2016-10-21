
package shakkipeli.logic;

import java.util.ArrayList;
import shakkipeli.domain.Board;
import shakkipeli.domain.Spot;

public class CheckTester {
    private Board board;
    private ArrayList<ChessPiece> list;
    private ArrayList<Spot> oppositeList;
    
    public CheckTester(Board oldBoard) {
        this.board = new Board();
        this.list = oldBoard.getPieceList();
        this.oppositeList = new ArrayList<>();
        setPieces();
    }
    
    public void setPieces() {
        for (ChessPiece piece : this.list) {
            if (piece.getId().equals("Pawn")) {
                this.board.setPiece(new Pawn(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Bishop")) {
                this.board.setPiece(new Bishop(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Queen")) {
                this.board.setPiece(new Queen(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("King")) {
                this.board.setPiece(new King(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Rook")) {
                this.board.setPiece(new Rook(piece.getX(), piece.getY(), piece.getColor()));
            } else if (piece.getId().equals("Knight")) {
                this.board.setPiece(new Knight(piece.getX(), piece.getY(), piece.getColor()));
            }
        }
    }
    
    public boolean testForCheckingYourself(ChessPiece movedPiece, Spot spot) {
        ChessPiece dangeredPiece = null;
        if (spot.checkSpot() == false) {
            dangeredPiece = spot.getPiece();
        }
        
        if (movedPiece.checkMove(spot, board)) {
            movedPiece.move(spot, board);
        }
        
        for (ChessPiece piece : this.list) {
            piece.update(board);
            if (!piece.equals(dangeredPiece) && !piece.getColor().equals(movedPiece.getColor()) && testCheck(piece) == true) {
                return true;
            }
        }
        return false;
    }
    
    public boolean testForCheckingOpponent(ChessPiece movedPiece, Spot spot) {
        for (ChessPiece piece : this.list) {
            piece.update(board);
            if (movedPiece.getColor().equals(piece.getColor()) && testCheck(piece) == true) {
                System.out.println(piece.getColor() + " " + piece.getId() + " checks");
                return true;
            }
        }
        
        return false;
    }
    
    public King getKing(String color) {
        for (ChessPiece piece : this.list) {
            if (piece.getColor().equals(color) && piece.getId().equals("King")) {
                return (King) piece;
            }
        }
        return null;
    }

    public boolean testCheck(ChessPiece piece) {
        King king = null;
        if (piece.getColor().equals("White")) {
            king = getKing("Black"); 
        } else if (piece.getColor().equals("Black")) {
            king = getKing("White");
        }
        
        if (piece.getValidMoves().contains(this.board.getSpot(king.getX(), king.getY()))) {
            return true;
        }
        
        return false;
    }
}
