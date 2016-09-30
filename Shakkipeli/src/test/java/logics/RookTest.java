
package logics;

import logics.ChessPiece;
import logics.Rook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    
    private ChessPiece rook;
    
    @Before
    public void setUp() {
        this.rook = new Rook(1,1);
    }
    
    @Test 
    public void RookCreatedRight() {
        assertEquals(this.rook.getX(), 1);
        assertEquals(this.rook.getY(), 1);
        assertEquals(this.rook.getId(), "Rook");
    }  
    
}
