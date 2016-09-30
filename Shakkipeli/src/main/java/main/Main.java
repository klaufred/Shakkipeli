package main;

import ui.ChessGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] agrs) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Welcome to ChessGame");
        ChessGame game = new ChessGame();
        game.runGame();

        while (true) {
            System.out.println("Hope you enjoyed this game!");
            System.out.println("Would you like to play again? Answer yes or no");
            String command = lukija.nextLine();
            if (command.equals("yes")) {
                game = new ChessGame();
                game.runGame();
            } else if (command.equals("no")) {
                break;
            }
        }
    }
}
