
package domain;

import logics.Bishop;
import domain.Board;
import logics.King;
import logics.Knight;
import logics.Pawn;
import logics.Queen;
import logics.Rook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    private Board board;
    
    @Before
    public void setUp() {
        this.board = new Board();
    }
    
    @Test 
    public void endGameWorks() {
        this.board.theKingIsDead();
        assertTrue(this.board.gameOver() == false);
    }    
    
    @Test 
    public void piecesFound() {
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
    
    
}
