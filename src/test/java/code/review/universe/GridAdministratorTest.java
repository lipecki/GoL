package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GridAdministratorTest {

    @Test
    void cellShouldLiveNextRound() {
    }

    @Test
    void getUpdatedGrid() {
    }

    @Test
    void tick() {
    }

    @Test
    void nextGridState1() {
        // Setup
        TheGrid grid = mock(TheGrid.class);

        // Stub the initiated array
        boolean[][] mockArray = {
                {false,false,false,false},
                {false,true,true,false},
                {false,true,false,false},
                {false,false,false,false}
        };

        // Mock return value
        when(grid.getObservableUniverse()).thenReturn(mockArray);
        GridAdministrator administrator = new GridAdministrator(grid);

        // Advance one point in time
        administrator.tick();

        // Get next state
        boolean[][] updatedGrid = administrator.getUpdatedGrid();

        // Assert
        Assertions.assertArrayEquals(updatedGrid[0],mockArray[0]);
        Assertions.assertArrayEquals(updatedGrid[1],mockArray[1]);

        // Cell (2,2) should come alive in the first tick
        Assertions.assertArrayEquals(updatedGrid[2],mockArray[1]);
        Assertions.assertArrayEquals(updatedGrid[3],mockArray[3]);
    }

    @Test
    void nextGridState2() {
        // Setup
        TheGrid grid = mock(TheGrid.class);

        // Stub the initiated array
        boolean[][] mockArray = {
                {false,false,false,false},
                {false,true,true,false},
                {false,true,true,false},
                {false,false,false,false}
        };

        // Mock return value
        when(grid.getObservableUniverse()).thenReturn(mockArray);
        GridAdministrator administrator = new GridAdministrator(grid);

        // Advance one point in time
        administrator.tick();

        // Get next state
        boolean[][] updatedGrid = administrator.getUpdatedGrid();

        // The Block Still Life
        Assertions.assertArrayEquals(updatedGrid[0],mockArray[0]);
        Assertions.assertArrayEquals(updatedGrid[1],mockArray[1]);
        Assertions.assertArrayEquals(updatedGrid[2],mockArray[2]);
        Assertions.assertArrayEquals(updatedGrid[3],mockArray[3]);
    }
}