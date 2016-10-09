
package shakkipeli.ui;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shakkipeli.domain.Spot;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.GameLogic;

/**
* This class records and uses to the mouse movements.
*/
public class Mouselistener implements MouseListener {
    private GameLogic logic;
    private ChessPiece piece;
    private boolean choosePiece;
    
    /**
    * This method creates the class. It gives the choosePiece a false boolean. 
    * @param logic given to the class for moving the pieces.
    */
    public Mouselistener(GameLogic logic) {
        this.logic = logic;
        this.choosePiece = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 60;
        int y = e.getY() / 60;

        if (choosePiece == false) {
            this.piece = this.logic.findPiece(x, y);
            choosePiece = true;
        } else {
            Spot spot = this.logic.findSpot(x, y);
            if (this.piece.checkMove(spot, this.logic.getBoard()))  {
                this.piece.move(spot, this.logic.getBoard());
                choosePiece = false; 
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
