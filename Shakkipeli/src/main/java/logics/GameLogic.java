
package logics;

import domain.Board;
import domain.Spot;

/**
 * This will be the logics class. It will control the moves on the board.
 */

public class GameLogic {
    private Board board;

    public GameLogic(Board board) {
        this.board = board;
    }
    
    public boolean validMove(String from, String to) {
        ChessPiece piece = findPiece(from);
        return piece.checkMove(findSpot(to)) == true;
    }

    public void move(String from, String to) {
        ChessPiece piece = findPiece(from);
        piece.move(findSpot(to));
    }
    
    public ChessPiece findPiece(String yx) {
        int fromY = translateY(yx.charAt(0));
        int fromX = yx.charAt(1) - 1;
        ChessPiece piece = this.board.getPiece(fromX, fromY);
        return piece;
    }    
    
    public Spot findSpot(String yx) {
        int toX = yx.charAt(1) - 1;
        int toY = translateY(yx.charAt(0));
        Spot spot = this.board.getSpot(toX, toY);
        return spot;
    }

    public int translateY(char y) {
        if (y == 'a') {
            return 0;
        } else if (y == 'b') {
            return 1;
        } else if (y == 'c') {
            return 2;
        } else if (y == 'd') {
            return 3;
        } else if (y == 'e') {
            return 4;
        } else if (y == 'f') {
            return 5;
        } else if (y == 'g') {
            return 6;
        } else if (y == 'h') {
            return 7;
        }
        
        return 8;
    }
    
}
