
package logics;

import logics.Bishop;
import logics.ChessPiece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BishopTest {
    private ChessPiece bishop;
    
    @Before
    public void setUp() {
        this.bishop = new Bishop(1,1);
    }
    
    @Test 
    public void BishopCreatedRight() {
        assertEquals(this.bishop.getX(), 1);
        assertEquals(this.bishop.getY(), 1);
        assertEquals(this.bishop.getId(), "Bishop");
    }  
    
}
