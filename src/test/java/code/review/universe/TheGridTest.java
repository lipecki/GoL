package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheGridTest {

    @Test
    void TheGrid_no_arguments_constructor(){
        // Setup
        TheGrid zeroArgumentsGrid = new TheGrid();

        // I want to test the constructor and I know that I can solve the problem by spying with PowerMockito,
        // however, I have chosen to not add that for this single test.
        TheGrid testGrid = new TheGrid(TheGrid.MIN_SIZE,TheGrid.MIN_SIZE);

        boolean [][] testGridUniverse = testGrid.getObservableUniverse();
        boolean [][] zeroArgumentsUniverse = zeroArgumentsGrid.getObservableUniverse();


        Assertions.assertEquals(zeroArgumentsUniverse.length, testGridUniverse.length);
        for (int rowIndex = 0; rowIndex < zeroArgumentsUniverse.length; rowIndex++) {
            Assertions.assertEquals(zeroArgumentsUniverse[rowIndex].length,testGridUniverse[rowIndex].length);
        }
    }



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

    @Test
    void getObservableUniverse_negative_dimensions() {
        int lengthAndWidth = -1;
        TheGrid grid = new TheGrid(lengthAndWidth);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,TheGrid.MIN_SIZE);
        Assertions.assertEquals(observableUniverse[0].length,TheGrid.MIN_SIZE);
    }

    @Test
    void getObservableUniverse_negative_width(){
        int width = -1;
        int height = 1200;
        TheGrid grid = new TheGrid(width, height);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,TheGrid.MIN_SIZE);
        Assertions.assertEquals(observableUniverse[0].length,height);
    }
    @Test
    void getObservableUniverse_negative_height(){
        int width = 1377;
        int height = -42;
        TheGrid grid = new TheGrid(width, height);
        boolean[][] observableUniverse = grid.getObservableUniverse();
        Assertions.assertEquals(observableUniverse.length,width);
        Assertions.assertEquals(observableUniverse[0].length,TheGrid.MIN_SIZE);
    }
}
