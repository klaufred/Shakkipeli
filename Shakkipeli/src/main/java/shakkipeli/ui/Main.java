package shakkipeli.ui;
public class Main {

    /**
    * This method begins the game.
    * @param agrs for the main.
    */
    public static void main(String[] agrs) {
        System.out.println("Welcome to ChessGame");
        UI game = new UI();
        game.run();
    }
}
