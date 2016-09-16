package gametests;

import game.Bishop;
import game.ChessGame;
import game.King;
import game.Knight;
import game.Pawn;
import game.Player;
import game.Queen;
import game.Rook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player black;
    private Player white;

    @Before
    public void setUp() {
        black = new Player("black");
        white = new Player("white");
    }

    @Test
    public void blackTest() {
        assertEquals(black.getSide(), "black");
    }

    @Test
    public void whiteTest() {
        assertEquals(white.getSide(), "white");
    }

    @Test
    public void piecesSetUp() {
        black.GameSetUp();
        assertTrue(black.getPieces() != null);
    }

}
