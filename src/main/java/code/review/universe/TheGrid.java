package code.review.universe;
import java.util.Random;

public class TheGrid {
    private final boolean[][] boolBoard;
    static final int MIN_SIZE = 4;

    public TheGrid(int width, int height){
        int width1 = Integer.max(width, MIN_SIZE);
        int height1 = Integer.max(height, MIN_SIZE);

        // defaults to false initial values
        this.boolBoard = new boolean[width1][height1];
        this.setInitialState();
    }

    private void setInitialState() {
        Random random = new Random();
        for (int rowIndex = 0; rowIndex < this.boolBoard.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < rowIndex; columnIndex++) {
                this.boolBoard[rowIndex][columnIndex] = random.nextBoolean();
            }
        }
    }

    public TheGrid(int width) {
        // Square grid initiation
        this(width,width);
    }

    public TheGrid() {
        this(MIN_SIZE);
    }

    public boolean[][] getObservableUniverse() {
        return this.boolBoard.clone();
    }
}
