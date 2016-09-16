package gametests;

import game.Board;
import game.ChessGame;
import game.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessGameTest {

    private ChessGame game;
    private Player black;
    private Player white;

    @Before
    public void setUp() {
        this.game = new ChessGame();
        black = this.game.getBlack();
        white = this.game.getWhite();
    }

    @Test
    public void runGameWorks() {
       
    }
}
