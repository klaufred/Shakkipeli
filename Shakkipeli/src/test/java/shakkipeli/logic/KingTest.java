
package shakkipeli.logic;

import shakkipeli.logic.Pawn;
import shakkipeli.domain.Board;
import shakkipeli.logic.King;
import shakkipeli.logic.ChessPiece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {
    
    private ChessPiece king;
    private Board board;
    
    @Before
    public void setUp() {
        this.king = new King(4,4, "White");
        this.board = new Board();
    }
    
    @Test 
    public void KingCreatedRight() {
        assertEquals(this.king.getX(), 4);
        assertEquals(this.king.getY(), 4);
        assertEquals(this.king.getId(), "King");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks1() {
        this.king.update(this.board);
        assertTrue(this.king.checkMove(this.board.getSpot(5, 5), board));
    }  
    
    @Test 
    public void moveWorks() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 5), board)) {
            this.king.move(this.board.getSpot(5, 5), board);
        }
        assertEquals(this.board.getPiece(5, 5).getId(), "King");
    } 
    
    @Test 
    public void moveWorks2() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 5), board)) {
            this.king.move(this.board.getSpot(5, 5), board);
        }
        assertEquals(this.board.getPiece(5, 5).getId(), "King");
    }  
    
    @Test 
    public void moveWorks3() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 4), board)) {
            this.king.move(this.board.getSpot(5, 4), board);
        }
        assertEquals(this.board.getPiece(5, 4).getId(), "King");
    }  
    
    @Test 
    public void moveWorks4() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(4, 5), board)) {
            this.king.move(this.board.getSpot(4, 5), board);
        }
        assertEquals(this.board.getPiece(4, 5).getId(), "King");
    }  
    
    @Test 
    public void moveWorks5() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(3, 3), board)) {
            this.king.move(this.board.getSpot(3, 3), board);
        }
        assertEquals(this.board.getPiece(3, 3).getId(), "King");
    }  
    
    @Test 
    public void moveWorks6() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 3), board)) {
            this.king.move(this.board.getSpot(5, 3), board);
        }
        assertEquals(this.board.getPiece(5, 3).getId(), "King");
    }  
    
    @Test 
    public void moveWorks7() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(3, 5), board)) {
            this.king.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "King");
    }  
    
    @Test 
    public void moveWorks8() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(4, 3), board)) {
            this.king.move(this.board.getSpot(4, 3), board);
        }
        assertEquals(this.board.getPiece(4, 3).getId(), "King");
    }  
    
    @Test 
    public void moveWorks9() {
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(3, 4), board)) {
            this.king.move(this.board.getSpot(3, 4), board);
        }
        assertEquals(this.board.getPiece(3, 4).getId(), "King");
    }  
    
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(5, 5).occupySpot(new Pawn(5, 5, "Black"));
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 5), board)) {
            this.king.move(this.board.getSpot(5, 5), board);
        }
        assertEquals(this.board.getPiece(5, 5).getId(), "King");
    }
    
}
