
package shakkipeli.logic;

import shakkipeli.logic.Pawn;
import shakkipeli.domain.Board;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.Knight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {
    
    private ChessPiece knight;
    private Board board;
    
    @Before
    public void setUp() {
        this.knight = new Knight(5, 4, "White");
        this.board = new Board();
    }
    
    @Test 
    public void KnightCreatedRight() {
        assertEquals(this.knight.getX(), 5);
        assertEquals(this.knight.getY(), 4);
        assertEquals(this.knight.getId(), "Knight");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks1() {
        this.board.setPieces();
        this.knight.update(this.board);
        assertTrue(this.knight.checkMove(this.board.getSpot(4, 2), board));
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks2() {
        this.knight = new Knight(4, 4, "Black");
        this.board.setPieces();
        this.knight.update(this.board);
        assertTrue(this.knight.checkMove(this.board.getSpot(5, 2), board));
    } 
    
    @Test 
    public void moveWorks() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(4, 2), board)) {
            this.knight.move(this.board.getSpot(4, 2), board);
        }
        assertEquals(this.board.getPiece(4, 2).getId(), "Knight");
    }  
    
    @Test 
    public void moveWorks2() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(6, 6), board)) {
            this.knight.move(this.board.getSpot(6, 6), board);
        }
        assertEquals(this.board.getPiece(6, 6).getId(), "Knight");
    }  
    
    @Test 
    public void moveWorks3() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(4, 6), board)) {
            this.knight.move(this.board.getSpot(4, 6), board);
        }
        assertEquals(this.board.getPiece(4, 6).getId(), "Knight");
    }  
    
    @Test 
    public void moveWorks4() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(3, 3), board)) {
            this.knight.move(this.board.getSpot(3, 3), board);
        }
        assertEquals(this.board.getPiece(3, 3).getId(), "Knight");
    }  
    
    @Test 
    public void moveWorks5() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(7, 5), board)) {
            this.knight.move(this.board.getSpot(7, 5), board);
        }
        assertEquals(this.board.getPiece(7, 5).getId(), "Knight");
    }  
    
    @Test 
    public void moveWorks6() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(3, 5), board)) {
            this.knight.move(this.board.getSpot(3, 5), board);
        }
        assertEquals(this.board.getPiece(3, 5).getId(), "Knight");
    }
    
    @Test 
    public void moveWorks7() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(7, 3), board)) {
            this.knight.move(this.board.getSpot(7, 3), board);
        }
        assertEquals(this.board.getPiece(7, 3).getId(), "Knight");
    }
    
    @Test 
    public void moveWorks8() {
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(6, 2), board)) {
            this.knight.move(this.board.getSpot(6, 2), board);
        }
        assertEquals(this.board.getPiece(6, 2).getId(), "Knight");
    }
    
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(4, 2).occupySpot(new Pawn(4, 2, "Black"));
        this.knight.update(this.board);
        if(this.knight.checkMove(this.board.getSpot(4, 2), board)) {
            this.knight.move(this.board.getSpot(4, 2), board);
        }
        assertEquals(this.board.getPiece(4, 2).getId(), "Knight");
    }
}
