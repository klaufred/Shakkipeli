
package logics;

import logics.ChessPiece;
import logics.Pawn;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {
    private ChessPiece pawn;
    
    @Before
    public void setUp() {
        this.pawn = new Pawn(1,1);
    }
    
    @Test 
    public void PawnCreatedRight() {
        assertEquals(this.pawn.getX(), 1);
        assertEquals(this.pawn.getY(), 1);
        assertEquals(this.pawn.getId(), "Pawn");
    }  
    
    
}
