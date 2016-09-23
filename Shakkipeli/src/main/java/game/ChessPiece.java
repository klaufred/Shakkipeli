package game;


public abstract class ChessPiece {

    private int x;
    private int y;
    private boolean existence;

    public ChessPiece(int x, int y) {
        this.x = x;
        this.y = y;
        this.existence = true;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void removePiece() {
        this.existence = false;
    }
}
