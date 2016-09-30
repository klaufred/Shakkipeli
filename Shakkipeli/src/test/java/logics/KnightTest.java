
package logics;

import logics.ChessPiece;
import logics.Knight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {
    
    private ChessPiece knight;
    
    @Before
    public void setUp() {
        this.knight = new Knight(1,1);
    }
    
    @Test 
    public void KnightCreatedRight() {
        assertEquals(this.knight.getX(), 1);
        assertEquals(this.knight.getY(), 1);
        assertEquals(this.knight.getId(), "Knight");
    }  
    
}
