package game;

import java.util.ArrayList;

public class Player {

    private String side;
    private ArrayList<ChessPiece> pieces;

    public Player(String side) {
        this.side = side;
        this.pieces = new ArrayList<ChessPiece>();
    }

    public String getSide() {
        return this.side;
    }

    public ArrayList<ChessPiece> getPieces() {
        return this.pieces;
    }

    public void GameSetUp() {
        if ("white".equals(this.side)) {
            for (int x = 0; x < 8; x++) {
                this.pieces.add(new Pawn(x, 1));
            }

            this.pieces.add(new King(4, 0));
            this.pieces.add(new Queen(3, 0));
            this.pieces.add(new Rook(0, 0));
            this.pieces.add(new Rook(7, 0));
            this.pieces.add(new Bishop(2, 0));
            this.pieces.add(new Bishop(5, 0));
            this.pieces.add(new Knight(2, 0));
            this.pieces.add(new Knight(6, 0));

        } else {
            for (int x = 0; x < 8; x++) {
                this.pieces.add(new Pawn(x, 6));
            }

            this.pieces.add(new King(4, 7));
            this.pieces.add(new Queen(3, 7));
            this.pieces.add(new Rook(0, 7));
            this.pieces.add(new Rook(7, 7));
            this.pieces.add(new Bishop(2, 7));
            this.pieces.add(new Bishop(5, 7));
            this.pieces.add(new Knight(2, 7));
            this.pieces.add(new Knight(6, 7));
        }
    }

}
