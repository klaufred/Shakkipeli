
package logics;

import logics.ChessPiece;
import logics.Queen;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {
    
    private ChessPiece queen;
    
    @Before
    public void setUp() {
        this.queen = new Queen(1,1);
    }
    
    @Test 
    public void QueenCreatedRight() {
        assertEquals(this.queen.getX(), 1);
        assertEquals(this.queen.getY(), 1);
        assertEquals(this.queen.getId(), "Queen");
    }  
    
}
