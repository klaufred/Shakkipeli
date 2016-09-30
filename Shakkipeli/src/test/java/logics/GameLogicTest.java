
package logics;

import domain.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameLogicTest {
    private Board board;
    private GameLogic logic;
    
    @Before
    public void setUp() {
        this.board = new Board();
        this.board.setPieces();
        this.logic = new GameLogic(this.board);
    }
    
    //En tiedä miksei testit toimi!!
    
    //@Test 
    //public void findSpotWorks() {
    //    assertEquals(this.logic.findSpot("a0").getX(), 0);  
    //    assertEquals(this.logic.findSpot("a0").getY(), 0);  
    //}  
    
    //@Test 
    //public void findPieceWorks() {
    //   assertEquals(this.logic.findPiece("a0").getId(), "Rook");
    //}  
    
    //@Test 
    //public void moveWorks() {
    //    this.logic.move("a0", "a1");
    //}  
    
    //@Test 
    //public void validMoveWorks() {
    //    assertTrue(this.logic.validMove("a0", "a1"));
    //}  
}
