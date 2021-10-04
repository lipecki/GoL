package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheGridTest {

    @Test
    void getObservableUniverse() {
        int lengthAndWidth = 5;
        TheGrid grid = new TheGrid(lengthAndWidth);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,lengthAndWidth);
        Assertions.assertEquals(observableUniverse[0].length,lengthAndWidth);


    }

    @Test
    void getZeroObservableUniverse() {
        int lengthAndWidth = 0;
        TheGrid grid = new TheGrid(lengthAndWidth);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,TheGrid.MIN_SIZE);
        Assertions.assertEquals(observableUniverse[0].length,TheGrid.MIN_SIZE);
    }
}