package game;

import java.util.Scanner;

public class ChessGame {

    private Board board;
    private Player black;
    private Player white;
    private Scanner reader;

    public ChessGame() {
        this.black = new Player("black");
        this.white = new Player("white");
        this.board = new Board();
        this.reader = new Scanner(System.in);
    }

    public Player getBlack() {
        return this.black;
    }

    public Player getWhite() {
        return this.white;
    }

    public Board getBoard() {
        return this.board;
    }

    public void runGame() {
        this.white.GameSetUp();
        this.black.GameSetUp();

        while (true) {
            System.out.println("White's turn, write 'quit' to end the game");
            String command = this.reader.nextLine();
            if (command.equals("quit")) {
                break;
            }
        }

    }

}
