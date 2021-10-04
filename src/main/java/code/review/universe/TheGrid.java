package code.review.universe;


import java.util.Arrays;

public class TheGrid {
    private final int width;
    private final int height;
    private boolean[][] boolBoard;

    public TheGrid(int width, int height){
        super();
        this.width = width;
        this.height = height;
        this.boolBoard = new boolean[width][height];
//        for (boolean[] booleans : this.boolBoard) {
//            Arrays.fill(booleans,Boolean.FALSE);
//        }
    }

    public TheGrid(int width) {
        this(width,width);
    }

    public TheGrid() {
        this(40);
    }

    public boolean[][] getObservableUniverse() {
        return this.boolBoard.clone();
    }
}
