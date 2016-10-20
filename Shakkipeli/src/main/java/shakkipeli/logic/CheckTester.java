
package shakkipeli.logic;

import java.util.ArrayList;
import shakkipeli.domain.Board;

public class CheckTester {
    private GameLogic logic;
    private Board board;
    private ChessPiece piece;
    
    public CheckTester(Board board) {
        this.board = new Board();
        this.logic = new GameLogic(this.board);
        
        ArrayList<ChessPiece> list = board.getPieceList();
    }
    
    
}
