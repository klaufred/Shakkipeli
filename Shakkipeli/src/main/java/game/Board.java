package game;


public class Board {

    private Spot[][] spots;
    private boolean  gameStatus;

    public Board() {
        this.gameStatus = true;
        this.spots = new Spot[8][8];

        for (int x = 0; x < this.spots.length; x++) {
            for (int y = 0; y < this.spots.length; y++) {
                this.spots[x][y] = new Spot(x, y);
            }
        }
    } 

    public Spot getSpot(int x, int y) {
        return this.spots[x][y];
    }

    public boolean validMove(String from, String to, Player player) {
        return true;
    }

    public void move(String from, String to, Player player) {
        
    }

    public boolean gameOver() {
        return this.gameStatus;
    }
    
    public void theKingIsDead() {
        this.gameStatus = false;
    }

    
}
