package shakkipeli.ui;

import shakkipeli.domain.Board;
import java.util.Scanner;
import shakkipeli.logic.GameLogic;
/**
 * This class was working as the interface class. It read the players 
 * commands and informed the logic to do them, if they are appropriate. It 
 * created the logic and the board. This is the former text based UI. Not relevant anymore.
 */
public class ChessGame {

    private Board board;
    private boolean black;
    private boolean white;
    private Scanner reader;
    private GameLogic logic;
    
    /**
    * This method created the ChessGame. It made the board and the logic as well
    * as the scanner and the set the players turn booleans to false.
    */
    public ChessGame() {
        this.black = false;
        this.white = false;
        this.board = new Board();
        this.reader = new Scanner(System.in);
        this.logic = new GameLogic();
        this.board.setPieces();
    }

    public Board getBoard() {
        return this.board;
    }
    /*
    public void moveWhite(String from, String to) {
        if (this.logic.validMove(from, to) == true) {
            this.logic.move(from, to);
            this.white = false;
            this.black = true;
        } 
    }
    */
    
    /*
    public void moveBlack(String from, String to) {
        if (this.logic.validMove(from, to) == true) {
            this.logic.move(from, to);
            this.black = false;
            this.white = true;
        } 
    }
    */
    
    /**
    * This method asked where the piece was supposed to move from.
     * @return String were the spot would be.
    */
    public String askWhereFrom() {
        String from;
        while (true) {
            System.out.println("What piece would you like to move?");
            from = this.reader.nextLine(); 
            if (check(from)) {
                break;
            }
        }
        return from;
    }
    
    /**
    * This method creates the asks where to move the piece.
    @return String were you wanted it to be moved.
    */
    public String askWhereTo() {
        String to;
        while (true) {
            System.out.println("And where to?");
            to = this.reader.nextLine(); 
           
            if (check(to)) {
                break;
            }
        }
        
        return to;
    }
    /**
    * This method checks that the command it correct.
     * @param command to be read.
     * @return boolean whether it was a genuine command or false.
    */
    public boolean check(String command) {
        if (command.isEmpty() || command.equals("quit") || command.equals("a1")
                || command.equals("a2") || command.equals("a3") 
                || command.equals("a4") || command.equals("a5")
                || command.equals("a6") || command.equals("a7")
                || command.equals("a8") || command.equals("b1")
                || command.equals("b2") || command.equals("b3") 
                || command.equals("b4") || command.equals("b5")
                || command.equals("b6") || command.equals("b7")
                || command.equals("b8") || command.equals("c1")
                || command.equals("c2") || command.equals("c3") 
                || command.equals("c4") || command.equals("c5")
                || command.equals("c6") || command.equals("c7")
                || command.equals("c8") || command.equals("d1")
                || command.equals("d2") || command.equals("d3") 
                || command.equals("d4") || command.equals("d5")
                || command.equals("d6") || command.equals("d7")
                || command.equals("d8") || command.equals("e1")
                || command.equals("e2") || command.equals("e3") 
                || command.equals("e4") || command.equals("e5")
                || command.equals("e6") || command.equals("e7")
                || command.equals("e8") || command.equals("f1")
                || command.equals("f2") || command.equals("f3") 
                || command.equals("f4") || command.equals("f5")
                || command.equals("f6") || command.equals("f7")
                || command.equals("f8") || command.equals("g1")
                || command.equals("g2") || command.equals("g3") 
                || command.equals("g4") || command.equals("g5")
                || command.equals("g6") || command.equals("g7")
                || command.equals("g8") || command.equals("h1")
                || command.equals("h2") || command.equals("h3") 
                || command.equals("h4") || command.equals("h5")
                || command.equals("h6") || command.equals("h7")
                || command.equals("h8")) {
            return true;
        } else {
            return false;
        }
    }
    /**
    * This method checks if the command was quit.
     * @param command checks if the String is quit.
     * @return boolean false if it is quit.
    */
    public boolean checkQuit(String command) {
        return !command.equals("quit");
    }
    /**
    * This method acts as a game turn.
    * @return boolean yes if the status is yes, if the game is still going on.
    */
    public boolean turn() {
        boolean gameStatus = true;
        
        while (true) {
            String from = askWhereFrom();
            if (checkQuit(from) == false) {
                gameStatus = false;
                break;
            }
            
            String to = askWhereTo();
            if (checkQuit(to) == false) {
                gameStatus = false;
                break;
            }
            /*
            if (this.white = true) {
                moveWhite(from, to);
            }
            */
            /*
            if (this.black = true) {
                moveBlack(from, to);
            }
            */
            if (this.board.gameOver() == false) {
                gameStatus = false;
            }
            break;
        }
        return gameStatus;
    }
    
    /**
    * This method runs the text interface and makse the turns.
    */
    public void runGame() {
        System.out.println("To move a piece, write where is the piece that you "
                + "would like to move and where you would like to move it");
        System.out.println("For example: if you want to move a piece from a4 "
                + "to a5, you would write a4, when asked what to move and a5 "
                + "when asked where to move it");
        System.out.println("Write 'quit' to end the game");
        System.out.println("White player begins");
        this.white = true;
        boolean gameOn;
        
        while (true) {
            gameOn = turn();
            if (gameOn == false) {
                break;
            }
            System.out.println("next turn:");
        }
    }
}
