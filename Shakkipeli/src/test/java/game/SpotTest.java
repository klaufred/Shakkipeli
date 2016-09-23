
package game;

import game.Pawn;
import game.Spot;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpotTest {
    private Spot spot;

    
    @Before
    public void setUp() {
        this.spot = new Spot(1, 1);
    }
    
    
    
    @Test
    public void createdSpotWorks() {
        assertEquals(this.spot.getX(),1);
        assertEquals(this.spot.getY(),1);
    }
    
    @Test
    public void occypySlotsWorks() {
        Pawn piece = new Pawn(1, 1);
        this.spot.occupySpot(piece);
        assertTrue(this.spot.getPiece() == piece);
    }
    
    @Test
    public void emptySlotWorks() {
        Pawn piece = new Pawn(1, 1);
        this.spot.occupySpot(piece);
        this.spot.emptySpot();
        assertTrue(this.spot.getPiece() == null);
    }
    
    @Test
    public void checkSpotWorks1() {
        Pawn piece = new Pawn(1, 1);
        this.spot.occupySpot(piece);
        assertTrue(this.spot.checkSpot()== false);
    }
    
    @Test
    public void checkSpotWorks2() {
        assertTrue(this.spot.checkSpot()== true);
    }
    
}
