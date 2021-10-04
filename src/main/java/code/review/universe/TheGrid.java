package code.review.universe;
import java.util.Random;

public class TheGrid {
    private final int width;
    private final int height;
    private boolean[][] boolBoard;
    static int MIN_SIZE = 4;

    public TheGrid(int width, int height){
        this.width = Integer.max(width,MIN_SIZE);
        this.height = Integer.max(height,MIN_SIZE);

        // defaults to false initial values
        this.boolBoard = new boolean[this.width][this.height];
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
        this(width,width);
    }

    public TheGrid() {
        this(MIN_SIZE);
    }

    public boolean[][] getObservableUniverse() {
        return this.boolBoard.clone();
    }
}
