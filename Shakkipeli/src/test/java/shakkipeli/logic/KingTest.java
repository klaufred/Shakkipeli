
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
    public void takingOverWorks() {
        this.board.getSpot(5, 5).occupySpot(new Pawn(5, 5, "Black"));
        this.king.update(this.board);
        if(this.king.checkMove(this.board.getSpot(5, 5), board)) {
            this.king.move(this.board.getSpot(5, 5), board);
        }
        assertEquals(this.board.getPiece(5, 5).getId(), "King");
    }
}
