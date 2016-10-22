
package shakkipeli.ui;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.GameLogic;

/**
* This class records and uses to the mouse movements.
*/
public class Mouselistener implements MouseListener {
    private GameLogic logic;
    private ChessPiece piece;
    private boolean choosePiece;
    private boolean gameOver;
    
    /**
    * This method creates the class. It gives the choosePiece a false boolean. 
    * @param logic given to the class for moving the pieces.
    */
    public Mouselistener(GameLogic logic) {
        this.logic = logic;
        this.choosePiece = false;
        this.gameOver = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / 60;
        int y = e.getY() / 60;

        if (this.gameOver == false) {
            if (choosePiece == false && this.logic.findPiece(x, y) != null && this.logic.findPiece(x, y).getColor().equals(this.logic.turnColor())) {
                this.piece = this.logic.findPiece(x, y);
                this.piece.choose(true);
                choosePiece = true;
            } else if (this.choosePiece == true && this.piece == this.logic.findPiece(x, y)) {
                this.piece.choose(false);
                this.choosePiece = false;
            } else if (this.choosePiece == true) {
                this.gameOver = this.logic.movePiece(this.piece, this.logic.findSpot(x, y));
                this.choosePiece = false;
                this.piece.choose(false);
            }   
        }
         
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
