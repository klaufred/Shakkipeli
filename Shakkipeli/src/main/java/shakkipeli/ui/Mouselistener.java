
package shakkipeli.ui;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.GameLogic;

public class Mouselistener implements MouseListener {
    private GameLogic logic;
    private ChessPiece piece;
    private boolean choosePiece;
    
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
            if (this.piece.checkMove(this.logic.findSpot(x, y), this.logic.getBoard()))  {
                this.piece.move(this.logic.findSpot(x, y), this.logic.getBoard());
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
