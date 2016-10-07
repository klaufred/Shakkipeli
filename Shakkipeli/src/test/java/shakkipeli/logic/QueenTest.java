
package shakkipeli.logic;

import shakkipeli.logic.Pawn;
import shakkipeli.domain.Board;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.Queen;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {
    
    private ChessPiece queen;
    private Board board;
    
    @Before
    public void setUp() {
        this.queen = new Queen(4,4, "White");
        this.board = new Board();
    }
    
    @Test 
    public void QueenCreatedRight() {
        assertEquals(this.queen.getX(), 4);
        assertEquals(this.queen.getY(), 4);
        assertEquals(this.queen.getId(), "Queen");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks() {
        this.board.setPieces();
        this.queen.update(this.board);
        assertTrue(this.queen.checkMove(this.board.getSpot(3, 5), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(3, 3), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(5, 5), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(5, 3), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(4, 2), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(3, 3), board));
        assertTrue(this.queen.checkMove(this.board.getSpot(5, 3), board));
    }  
    
    @Test 
    public void moveWorks() {
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(3, 5), board)) {
            this.queen.move(this.board.getSpot(3, 5), board);
        }
        
        assertEquals(this.board.getPiece(3, 5).getId(), "Queen");
    }  
    
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(4, 4).occupySpot(new Pawn(3, 5, "Black"));
        this.queen.update(this.board);
        
        if(this.queen.checkMove(this.board.getSpot(3, 5), board)) {
            this.queen.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "Queen");
    }
    
    @Test 
    public void takingOverWorks2() {
        this.board.getSpot(2, 6).occupySpot(new Pawn(2, 6, "Black"));
        this.board.getSpot(3, 5).occupySpot(new Pawn(3, 5, "Black"));
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(2, 6), board)) {
            this.queen.move(this.board.getSpot(2, 6), board);
        }
        assertEquals(this.board.getPiece(2, 6).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks3() {
        this.board.getSpot(3, 5).occupySpot(new Pawn(3, 5, "White"));
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(3, 5), board)) {
            this.queen.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "Pawn");
    }
    
    @Test 
    public void moveWorks2() {
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(4, 5), board)) {
            this.queen.move(this.board.getSpot(4, 5), board);
        }
        
        assertEquals(this.board.getPiece(4, 5).getId(), "Queen");
    }  
    
    @Test 
    public void takingOverWorks4() {
        this.board.getSpot(4, 5).occupySpot(new Pawn(4, 5, "Black"));
        this.queen.update(this.board);
        
        if(this.queen.checkMove(this.board.getSpot(4, 5), board)) {
            this.queen.move(this.board.getSpot(4, 5), board);
        }
        assertEquals(this.board.getPiece(4, 5).getId(), "Queen");
    }
    
    @Test 
    public void takingOverWorks5() {
        this.board.getSpot(4, 6).occupySpot(new Pawn(4, 6, "Black"));
        this.board.getSpot(4, 5).occupySpot(new Pawn(4, 5, "Black"));
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(4, 6), board)) {
            this.queen.move(this.board.getSpot(4, 6), board);
        }
        assertEquals(this.board.getPiece(4, 6).getId(), "Pawn");
        assertEquals(this.board.getPiece(4, 5).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks6() {
        this.board.getSpot(4, 6).occupySpot(new Pawn(4, 6, "Black"));
        this.board.getSpot(4, 5).occupySpot(new Pawn(4, 5, "White"));
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(4, 6), board)) {
            this.queen.move(this.board.getSpot(4, 6), board);
        }
        assertEquals(this.board.getPiece(4, 5).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks7() {
        this.board.getSpot(4, 4).occupySpot(new Pawn(4, 4, "White"));
        this.queen.update(this.board);
        if(this.queen.checkMove(this.board.getSpot(4, 4), board)) {
            this.queen.move(this.board.getSpot(4, 4), board);
        }
        assertEquals(this.board.getPiece(4, 4).getId(), "Pawn");
    }
}
