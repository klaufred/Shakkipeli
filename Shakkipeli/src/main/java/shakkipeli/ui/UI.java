
package shakkipeli.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import shakkipeli.logic.GameLogic;

/**
     * This class will be working as the interface class It creates the logic and the board as well as run the game.
    */

public class UI implements Runnable {

    private GameLogic logic;
    private JFrame frame;
    private int sivu;
    private Drawboard drawboard;
    
    /**
    * This method creates the UI. It makes a new board and a new logic. It also 
    * determines the size of the spots side.
    */
    public UI() {
        this.logic = new GameLogic();
        this.sivu = 60;
    }
    
    public Drawboard getDrawboard() {
        return this.drawboard;
    }
    /**
    * Runs the game interface.
    */
    @Override
    public void run() {
        frame = new JFrame("Chessgame");

        frame.setPreferredSize(new Dimension(this.sivu * 8 + 10, this.sivu * 8 + 27));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addDrawboard(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
    * Makes the drawing board for the run()-method.
    * @param container to add the drawing board to.
    */
    
    public void addDrawboard(Container container) {
        drawboard = new Drawboard(logic);
        container.add(drawboard);

        frame.addMouseListener(new Mouselistener(logic));
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
