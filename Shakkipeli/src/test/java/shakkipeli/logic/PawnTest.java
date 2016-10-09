
package shakkipeli.logic;

import shakkipeli.domain.Board;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.Pawn;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {
    private ChessPiece pawn;
    private Board board;
    
    @Before
    public void setUp() {
        this.pawn = new Pawn(5,1,"White");
        this.board = new Board();
    }
    
    @Test 
    public void PawnCreatedRight() {
        assertEquals(this.pawn.getX(), 5);
        assertEquals(this.pawn.getY(), 1);
        assertEquals(this.pawn.getId(), "Pawn");
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks1() {
        this.board.setPieces();
        this.pawn.update(this.board);
        assertTrue(this.pawn.checkMove(this.board.getSpot(5, 2), board));
    }  
    
    @Test 
    public void checkMoveAndUpdateWorks2() {
        this.pawn.update(this.board);
        assertTrue(this.pawn.checkMove(this.board.getSpot(5, 3), board));
    }  
    
    @Test 
    public void moveWorks() {
        this.pawn.update(this.board);
        if(this.pawn.checkMove(this.board.getSpot(5, 2), board)) {
            this.pawn.move(this.board.getSpot(5, 2), board);
        }
        assertEquals(this.board.getPiece(5, 2).getId(), "Pawn");
    }  
    
    @Test 
    public void takingOverWorks() {
        this.board.getSpot(4, 3).occupySpot(new Bishop(4, 3, "Black"));
        this.pawn.update(this.board);
        if(this.pawn.checkMove(this.board.getSpot(5, 2), board)) {
            this.pawn.move(this.board.getSpot(5, 2), board);
        }
        this.pawn.update(this.board);
        if(this.pawn.checkMove(this.board.getSpot(4, 3), board)) {
            this.pawn.move(this.board.getSpot(4, 3), board);
        }
        assertEquals(this.board.getPiece(4, 3).getId(), "Pawn");
    }  
}
