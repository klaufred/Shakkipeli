
package shakkipeli.ui;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import shakkipeli.logic.ChessPiece;
import shakkipeli.logic.GameLogic;
/**
* Connects the pieces to their pictures and draws them and the board.
*/

public class Drawboard extends JPanel {
    private File blackKing;
    private File blackQueen;
    private File blackBishop;
    private File blackHorse;
    private File blackRook;
    private File blackPawn;
    private File whiteKing;
    private File whiteQueen;
    private File whiteBishop;
    private File whiteHorse;
    private File whiteRook;
    private File whitePawn;
    
    private GameLogic logic;
    private BufferedImage image;
    private int sivu;
    
    /**
    * This method add the logic to the class and assigns the spots sides length.
    * It also gives all the piece files their photos.
    * @param logic for running the game.
    */
    public Drawboard(GameLogic logic) {
        this.logic = logic;
        this.sivu = 60;
        
        this.blackBishop = new File("src/ChessImages/Black_Bishop.png");
        this.blackHorse = new File("src/ChessImages/Black_Knight.png");
        this.blackKing = new File("src/ChessImages/Black_King.png");
        this.blackPawn = new File("src/ChessImages/Black_Pawn.png");
        this.blackQueen = new File("src/ChessImages/Black_Queen.png");
        this.blackRook = new File("src/ChessImages/Black_Rook.png");
        this.whiteBishop = new File("src/ChessImages/White_Bishop.png");
        this.whiteHorse = new File("src/ChessImages/White_Knight.png");
        this.whiteKing = new File("src/ChessImages/White_King.png");
        this.whitePawn = new File("src/ChessImages/White_Pawn.png");
        this.whiteQueen = new File("src/ChessImages/White_Queen.png");
        this.whiteRook = new File("src/ChessImages/White_Rook.png");
        
        
    }
    
    /**
    * Draws the board for the game. Determines the colour and size of the Spots.
    * @param g as the graphics.
    */
    public void drawBoard(Graphics g) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (x % 2 == 1 && y % 2 == 0 || x % 2 == 0 && y % 2 == 1) {
                    g.setColor(Color.decode("#870a0a"));
                } else {
                    g.setColor(Color.decode("#160776"));
                }
                g.fillRect(x * this.sivu, y * this.sivu, this.sivu, this.sivu);
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
        try {
            drawChessPieces(g);
        } catch (IOException ex) {
            Logger.getLogger(Drawboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
    
    /**
    * Draws the pieces based on the ChessPiece's class.
    */

    private void drawChessPieces(Graphics g) throws IOException {
        for (ChessPiece piece : this.logic.getList()) {
            try {
                image = ImageIO.read(getPiecePicture(piece));
            } catch (IOException ex) {
                Logger.getLogger(Drawboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            int x = piece.getX();
            int y = piece.getY();
            g.drawImage(image, x * this.sivu, y * this.sivu, this.sivu, this.sivu, this);

            if (piece.getChosen()) {
                highlight(piece.getX(), piece.getY(), g);
            }
        }
        repaint();
    }
    /**
    * This method highlights the chosen spot.
     * @param x the x coordinates of the Spot.
     * @param y the y coordinates of the Spot.
     * @param g as the graphics
    */
    public void highlight(int x, int y, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        double thickness = 5.0;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke((float) thickness));
        g2.setColor(Color.blue);
        g2.drawRect(x * 60, y * 60, 60, 60);
        g2.setStroke(oldStroke);
    }
    
    /**
    * Connects the ChessPiece with it's picture in it's File.
    * @param   piece   ChessPiece which needs to be connected to it's File (picture).
    * 
    * @return File of the piece given as the parameter.
    */
    public File getPiecePicture(ChessPiece piece) {
        if (piece.getColor() == "White" && piece.getId() == "Pawn") {
            return this.whitePawn;
        } else if (piece.getColor() == "White" && piece.getId() == "Queen") {
            return this.whiteQueen;
        } else if (piece.getColor() == "White" && piece.getId() == "Rook") {
            return  this.whiteRook;
        } else if (piece.getColor() == "White" && piece.getId() == "King") {
            return  this.whiteKing;
        } else if (piece.getColor() == "White" && piece.getId() == "Bishop") {
            return  this.whiteBishop;
        } else if (piece.getColor() == "White" && piece.getId() == "Knight") {
            return  this.whiteHorse;
        } else if (piece.getColor() == "Black" && piece.getId() == "King") {
            return  this.blackKing;
        } else if (piece.getColor() == "Black" && piece.getId() == "Queen") {
            return  this.blackQueen;
        } else if (piece.getColor() == "Black" && piece.getId() == "Pawn") {
            return  this.blackPawn;
        } else if (piece.getColor() == "Black" && piece.getId() == "Rook") {
            return  this.blackRook;
        } else if (piece.getColor() == "Black" && piece.getId() == "Bishop") {
            return  this.blackBishop;
        } else {
            return  this.blackHorse;
        }
    }
}

















