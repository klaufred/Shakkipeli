
package shakkipeli.logic;

import shakkipeli.logic.Pawn;
import shakkipeli.domain.Board;
import shakkipeli.logic.Bishop;
import shakkipeli.logic.ChessPiece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BishopTest {
    private ChessPiece bishop;
    private Board board;
    
    @Before
    public void setUp() {
        this.bishop = new Bishop(4, 4, "White");
        this.board = new Board();
    }
    
    @Test 
    public void BishopCreatedRight() {
        assertEquals(this.bishop.getX(), 4);
        assertEquals(this.bishop.getY(), 4);
        assertEquals(this.bishop.getId(), "Bishop");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks1() {
        this.board.setPieces();
        this.bishop.update(this.board);
        assertTrue(this.bishop.checkMove(this.board.getSpot(3, 5), board));
        assertTrue(this.bishop.checkMove(this.board.getSpot(3, 3), board));
        assertTrue(this.bishop.checkMove(this.board.getSpot(5, 5), board));
        assertTrue(this.bishop.checkMove(this.board.getSpot(5, 3), board));
    }  
    
    @Test 
    public void moveWorks() {
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(3, 5), board)) {
            this.bishop.move(this.board.getSpot(3, 5), board);
        }
        
        assertEquals(this.board.getPiece(3, 5).getId(), "Bishop");
    }  
    
    @Test 
    public void moveWorks2() {
        this.bishop = new Bishop(4, 4, "Black");
        this.board.getSpot(4, 4).occupySpot(bishop);
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(5, 5), board)) {
            this.bishop.move(this.board.getSpot(5, 5), board);
        }
        
        assertEquals(this.board.getPiece(5, 5).getId(), "Bishop");
    }  
    
    @Test 
    public void moveWorks3() {
        this.bishop = new Bishop(4, 4, "Black");
        this.board.getSpot(4, 4).occupySpot(bishop);
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(3, 3), board)) {
            this.bishop.move(this.board.getSpot(3, 3), board);
        }
        
        assertEquals(this.board.getPiece(3, 3).getId(), "Bishop");
    }  
    @Test 
    public void moveWorks4() {
        this.bishop = new Bishop(4, 4, "White");
        this.board.getSpot(4, 4).occupySpot(bishop);
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(5, 3), board)) {
            this.bishop.move(this.board.getSpot(5, 3), board);
        }
        
        assertEquals(this.board.getPiece(5, 3).getId(), "Bishop");
    }  
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(4, 4).occupySpot(new Pawn(3, 5, "Black"));
        this.bishop.update(this.board);
        
        if(this.bishop.checkMove(this.board.getSpot(3, 5), board)) {
            this.bishop.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "Bishop");
    }
    
    @Test 
    public void takingOverWorks2() {
        this.board.getSpot(2, 6).occupySpot(new Pawn(2, 6, "Black"));
        this.board.getSpot(3, 5).occupySpot(new Pawn(3, 5, "Black"));
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(2, 6), board)) {
            this.bishop.move(this.board.getSpot(2, 6), board);
        }
        assertEquals(this.board.getPiece(2, 6).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks3() {
        this.board.getSpot(3, 5).occupySpot(new Pawn(3, 5, "White"));
        this.bishop.update(this.board);
        if(this.bishop.checkMove(this.board.getSpot(3, 5), board)) {
            this.bishop.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "Pawn");
    }
    
}
