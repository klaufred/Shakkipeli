
package shakkipeli.ui;

import shakkipeli.domain.Board;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import shakkipeli.logic.GameLogic;

public class UI implements Runnable {

    private GameLogic logic;
    private Board board;
    private JFrame frame;
    private int sivu;
    private Drawboard drawboard;
    
    /**
     * This class will be working as the interface class It creates the logic and the board.
    */
    
    public UI() {
        this.board = new Board();
        this.logic = new GameLogic(this.board);
        this.sivu = 60;
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    public Drawboard getDrawboard() {
        return this.drawboard;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Chessgame");

        frame.setPreferredSize(new Dimension(this.sivu * 8 + 10, this.sivu * 8 + 27));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addDrawboard(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void addDrawboard(Container container) {
        drawboard = new Drawboard(logic);
        container.add(drawboard);

        frame.addMouseListener(new Mouselistener(logic));
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
