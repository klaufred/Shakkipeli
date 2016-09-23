
package game;

import game.Board;
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
}
