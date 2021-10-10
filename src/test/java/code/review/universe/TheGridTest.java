package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheGridTest {

    @Test
    void getObservableUniverse_square_grid() {
        int lengthAndWidth = 5;
        TheGrid grid = new TheGrid(lengthAndWidth);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,lengthAndWidth);
        Assertions.assertEquals(observableUniverse[0].length,lengthAndWidth);


    }

    @Test
    void getObservableUniverse_less_than_minimum_dimensions() {
        int lengthAndWidth = 0;
        TheGrid grid = new TheGrid(lengthAndWidth);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,TheGrid.MIN_SIZE);
        Assertions.assertEquals(observableUniverse[0].length,TheGrid.MIN_SIZE);
    }
}