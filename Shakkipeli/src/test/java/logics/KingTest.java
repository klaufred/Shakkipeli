
package logics;

import logics.King;
import logics.ChessPiece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {
    
    private ChessPiece king;
    
    @Before
    public void setUp() {
        this.king = new King(1,1);
    }
    
    @Test 
    public void KingCreatedRight() {
        assertEquals(this.king.getX(), 1);
        assertEquals(this.king.getY(), 1);
        assertEquals(this.king.getId(), "King");
    }  
    
}
