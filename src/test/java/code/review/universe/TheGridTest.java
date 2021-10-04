package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheGridTest {

    @Test
    void getObservableUniverse() {
        TheGrid grid = new TheGrid(5);
        for (boolean[] rows : grid.getObservableUniverse()) {

            for (boolean cell: rows) {
                Assertions.assertFalse(cell);
            }
        }
    }
}