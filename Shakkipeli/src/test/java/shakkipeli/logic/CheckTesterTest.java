
package shakkipeli.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shakkipeli.domain.Board;

public class CheckTesterTest {
    private CheckTester tester;
    private Board board;
    
    @Before
    public void setUp() {
        Board board = new Board();
        board.setPieces();
        this.tester = new CheckTester(board);
        this.board =  board;
    }
    
    @Test 
    public void setUpWorks() {
        this.tester.setSpecificPieces();
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
    public void testForCheckingOpponentWorks() {
        this.board.setPieces();
        ChessPiece piece2 = this.board.getPiece(2, 1);
        assertFalse(this.tester.testForCheckingYourself(piece2, this.board.getSpot(2, 1)));
    }
    
    @Test
    public void testForCheckingYourselfWorks2() {
        Board board2 = new Board();
        board2.setWhiteKing(4, 4);
        ChessPiece piece = new Queen(4, 6, "Black");
        board2.setPiece(piece);
        this.tester = new CheckTester(board2);
        assertFalse(this.tester.testForCheckingYourself(piece, this.board.getSpot(4, 4)));
    }
    
    @Test 
    public void testCheckWorks() {
        ChessPiece piece = this.board.getPiece(2, 1);
        
        assertFalse(this.tester.testCheck(piece));
    } 
}
