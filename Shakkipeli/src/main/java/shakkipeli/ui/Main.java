package shakkipeli.ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] agrs) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Welcome to ChessGame");
        UI game = new UI();
        game.run();
    }
}
