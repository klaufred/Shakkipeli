package game;


public class Board {

    private Spot[][] spots;

    public Board() {
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

}
