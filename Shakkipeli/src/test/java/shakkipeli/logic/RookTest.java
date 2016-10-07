
package shakkipeli.logic;

import shakkipeli.logic.Pawn;
import shakkipeli.domain.Board;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.Rook;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    
    private ChessPiece rook;
    private Board board;
    
    @Before
    public void setUp() {
        this.rook = new Rook(4,3, "White");
        this.board = new Board();
    }
    
    @Test 
    public void RookCreatedRight() {
        assertEquals(this.rook.getX(), 4);
        assertEquals(this.rook.getY(), 3);
        assertEquals(this.rook.getId(), "Rook");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks1() {
        this.board.setPieces();
        this.rook.update(this.board);
        assertTrue(this.rook.checkMove(this.board.getSpot(4, 4), board));
        assertTrue(this.rook.checkMove(this.board.getSpot(4, 2), board));
        assertTrue(this.rook.checkMove(this.board.getSpot(3, 3), board));
        assertTrue(this.rook.checkMove(this.board.getSpot(5, 3), board));
    }  
    
    @Test 
    public void moveWorks() {
        this.rook.update(this.board);
        if(this.rook.checkMove(this.board.getSpot(4, 4), board)) {
            this.rook.move(this.board.getSpot(4, 4), board);
        }
        
        assertEquals(this.board.getPiece(4, 4).getId(), "Rook");
    }  
    
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(4, 4).occupySpot(new Pawn(4, 4, "Black"));
        this.rook.update(this.board);
        
        if(this.rook.checkMove(this.board.getSpot(4, 4), board)) {
            this.rook.move(this.board.getSpot(4, 4), board);
        }
        assertEquals(this.board.getPiece(4, 4).getId(), "Rook");
    }
    
    @Test 
    public void takingOverWorks2() {
        this.board.getSpot(4, 5).occupySpot(new Pawn(4, 5, "Black"));
        this.board.getSpot(4, 4).occupySpot(new Pawn(4, 4, "Black"));
        this.rook.update(this.board);
        if(this.rook.checkMove(this.board.getSpot(4, 5), board)) {
            this.rook.move(this.board.getSpot(4, 5), board);
        }
        assertEquals(this.board.getPiece(4, 5).getId(), "Pawn");
        assertEquals(this.board.getPiece(4, 4).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks3() {
        this.board.getSpot(4, 5).occupySpot(new Pawn(4, 5, "Black"));
        this.board.getSpot(4, 4).occupySpot(new Pawn(4, 4, "White"));
        this.rook.update(this.board);
        if(this.rook.checkMove(this.board.getSpot(4, 5), board)) {
            this.rook.move(this.board.getSpot(4, 5), board);
        }
        assertEquals(this.board.getPiece(4, 5).getId(), "Pawn");
    }
    
    @Test 
    public void takingOverWorks4() {
        this.board.getSpot(4, 4).occupySpot(new Pawn(4, 4, "White"));
        this.rook.update(this.board);
        if(this.rook.checkMove(this.board.getSpot(4, 4), board)) {
            this.rook.move(this.board.getSpot(4, 4), board);
        }
        assertEquals(this.board.getPiece(4, 4).getId(), "Pawn");
    }
}
