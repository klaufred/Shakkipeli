
package shakkipeli.logic;

import java.util.ArrayList;
import shakkipeli.logic.GameLogic;
import shakkipeli.domain.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {
    private Board board;
    private GameLogic logic;
    
    @Before
    public void setUp() {
        this.board = new Board();
        this.logic = new GameLogic(this.board);
    }
    
    @Test 
    public void setUpWorks() {
        this.board.setPieces();
        for (int x = 0; x < 8; x++) {
            assertEquals(this.board.getPiece(x, 1).getId(), "Pawn");
        }
        
        for (int x = 0; x < 8; x++) {
            assertEquals(this.board.getPiece(x, 6).getId(), "Pawn");
        }
        assertEquals(this.board.getPiece(0, 0).getId(), "Rook");
        assertEquals(this.board.getPiece(7, 0).getId(), "Rook");
        assertEquals(this.board.getPiece(7, 7).getId(), "Rook");
        assertEquals(this.board.getPiece(0, 7).getId(), "Rook");
        assertEquals(this.board.getPiece(2, 0).getId(), "Bishop");
        assertEquals(this.board.getPiece(5, 0).getId(), "Bishop");
        assertEquals(this.board.getPiece(2, 7).getId(), "Bishop");
        assertEquals(this.board.getPiece(5, 7).getId(), "Bishop");
        assertEquals(this.board.getPiece(3, 7).getId(), "Queen");
        assertEquals(this.board.getPiece(3, 0).getId(), "Queen");
        assertEquals(this.board.getPiece(4, 0).getId(), "King");
        assertEquals(this.board.getPiece(4, 7).getId(), "King");
        assertEquals(this.board.getPiece(1, 0).getId(), "Knight");
        assertEquals(this.board.getPiece(6, 0).getId(), "Knight");
        assertEquals(this.board.getPiece(1, 7).getId(), "Knight");
        assertEquals(this.board.getPiece(6, 7).getId(), "Knight");
    }   
    
    @Test 
    public void pieceListFound() {
        
        ArrayList<ChessPiece> lista = this.logic.getList();
        
            assertEquals(lista.get(0).getId(), "Rook");
            assertEquals(lista.get(1).getId(), "Pawn");
            assertEquals(lista.get(2).getId(), "Pawn");
            assertEquals(lista.get(3).getId(), "Rook");
            assertEquals(lista.get(4).getId(), "Knight");
            assertEquals(lista.get(5).getId(), "Pawn");
            assertEquals(lista.get(6).getId(), "Pawn");
            assertEquals(lista.get(7).getId(), "Knight");
            assertEquals(lista.get(8).getId(), "Bishop");
            assertEquals(lista.get(9).getId(), "Pawn");
            assertEquals(lista.get(10).getId(), "Pawn");
            assertEquals(lista.get(11).getId(), "Bishop");
            assertEquals(lista.get(12).getId(), "Queen");
            assertEquals(lista.get(13).getId(), "Pawn");
            assertEquals(lista.get(14).getId(), "Pawn");
            assertEquals(lista.get(15).getId(), "Queen");
            assertEquals(lista.get(16).getId(), "King");
            assertEquals(lista.get(17).getId(), "Pawn");
            assertEquals(lista.get(18).getId(), "Pawn");
            assertEquals(lista.get(19).getId(), "King");
            assertEquals(lista.get(20).getId(), "Bishop");
            assertEquals(lista.get(21).getId(), "Pawn");
            assertEquals(lista.get(22).getId(), "Pawn");
            assertEquals(lista.get(23).getId(), "Bishop");
            assertEquals(lista.get(24).getId(), "Knight");
            assertEquals(lista.get(25).getId(), "Pawn");
            assertEquals(lista.get(26).getId(), "Pawn");
            assertEquals(lista.get(27).getId(), "Knight");
            assertEquals(lista.get(28).getId(), "Rook");
            assertEquals(lista.get(29).getId(), "Pawn");
            assertEquals(lista.get(30).getId(), "Pawn");
            assertEquals(lista.get(31).getId(), "Rook");
    }
    
    @Test 
    public void findPieceWorks() { 
        assertEquals(this.logic.findPiece(0, 0).getId(), "Rook");
    }
    
    @Test 
    public void findSpotWorks() { 
        assertEquals(this.logic.findSpot(0, 0).getPiece().getId(), "Rook");
    }
    
    @Test 
    public void movePieceWorks() { 
        ChessPiece piece = new Rook(3, 3, "White");
        this.board.getSpot(3, 3).occupySpot(piece);
        this.logic.movePiece(piece, this.board.getSpot(4, 3));
        assertEquals(this.board.getPiece(4, 3).getId(), piece.getId());
        assertEquals(this.logic.turnColor(), "Black");
        assertFalse(piece.getChosen());
    }
    
    @Test 
    public void turnColorWorks() { 
        assertEquals(this.logic.turnColor(),"White");
    }
    
    @Test 
    public void changeTurnWorks1() { 
        this.logic.changeTurn();
        assertEquals(this.logic.turnColor(),"Black");
    }
    
    @Test 
    public void changeTurnWorks2() { 
        this.logic.changeTurn();
        this.logic.changeTurn();
        assertEquals(this.logic.turnColor(),"White");
    }
}
