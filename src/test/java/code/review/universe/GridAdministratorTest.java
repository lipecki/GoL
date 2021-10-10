package code.review.universe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GridAdministratorTest {

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_MAX() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(true,Integer.MAX_VALUE));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_negative() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(true,-1));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_two() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(true,2));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_three() {
        Assertions.assertTrue(GridRules.cellShouldLiveNextRound(true,3));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_four() {
        Assertions.assertTrue(GridRules.cellShouldLiveNextRound(true,4));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_five() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(true,5));
    }

    @Test
    void cellShouldLiveNextRound_aliveCell_liveNeighbourCount_MIN() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(true,Integer.MIN_VALUE));
    }

    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_negative() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false, -1));
    }
    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_one() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false, 1));
    }
    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_two() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false, 2));
    }
    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_three() {
        Assertions.assertTrue(GridRules.cellShouldLiveNextRound(false, 3));
    }

    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_four() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false, 4));
    }

    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_MAX() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false, Integer.MAX_VALUE));
    }

    @Test
    void cellShouldLiveNextRound_deadCell_liveNeighbourCount_MIN() {
        Assertions.assertFalse(GridRules.cellShouldLiveNextRound(false,Integer.MIN_VALUE));
    }

    @Test
    void advanceTimeAndReturnNextFrame_three_makes_four() {
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

        // Get next state
        boolean[][] updatedGrid = administrator.advanceTimeAndReturnNextFrame();

        // Assert
        Assertions.assertArrayEquals(updatedGrid[0],mockArray[0]);
        Assertions.assertArrayEquals(updatedGrid[1],mockArray[1]);

        // Cell (2,2) should come alive in the first tick
        Assertions.assertArrayEquals(updatedGrid[2],mockArray[1]);
        Assertions.assertArrayEquals(updatedGrid[3],mockArray[3]);
    }

    @Test
    void advanceTimeAndReturnNextFrame_four_remain() {
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

        // Get next state
        boolean[][] updatedGrid = administrator.advanceTimeAndReturnNextFrame();

        // The Block Still Life
        // (https://en.wikipedia.org/wiki/Conway's_Game_of_Life#/media/File:Game_of_life_block_with_border.svg)
        Assertions.assertArrayEquals(updatedGrid[0],mockArray[0]);
        Assertions.assertArrayEquals(updatedGrid[1],mockArray[1]);
        Assertions.assertArrayEquals(updatedGrid[2],mockArray[2]);
        Assertions.assertArrayEquals(updatedGrid[3],mockArray[3]);
    }

    @Test
    void advanceTimeAndReturnNextFrame_four_neighbours_kill_live_cell() {
        // Setup
        TheGrid grid = mock(TheGrid.class);

        // Stub the initiated array
        boolean[][] mockArray1 = {
                {false,false,false,false,false,false},
                {false,true,true,false,false,false},
                {false,true,true,false,false,false},
                {false,false,false,true,true,false},
                {false,false,false,true,true,false},
                {false,false,false,false,false,false}
        };

        // Stub the updated array
        boolean[][] mockArray2 = {
                {false,false,false,false,false,false},
                {false,true,true,false,false,false},
                {false,true,false,false,false,false},
                {false,false,false,false,true,false},
                {false,false,false,true,true,false},
                {false,false,false,false,false,false}
        };

        // Mock return value
        when(grid.getObservableUniverse()).thenReturn(mockArray1);
        GridAdministrator administrator = new GridAdministrator(grid);

        // Get next state
        boolean[][] updatedGrid = administrator.advanceTimeAndReturnNextFrame();

        // The Beacon Oscillator
        // (https://en.wikipedia.org/wiki/Conway's_Game_of_Life#/media/File:Game_of_life_beacon.gif)
        for (int rowIndex = 0; rowIndex < updatedGrid.length; rowIndex++) {
            Assertions.assertArrayEquals(updatedGrid[rowIndex],mockArray2[rowIndex]);
        }
    }

    @Test
    void advanceTimeAndReturnNextFrame_three_neighbours_resurrect_dead_cell() {
        // Setup
        TheGrid grid = mock(TheGrid.class);

        // Stub the initiated array
        boolean[][] mockArray1 = {
                {false,false,false,false,false,false},
                {false,true,true,false,false,false},
                {false,true,true,false,false,false},
                {false,false,false,true,true,false},
                {false,false,false,true,true,false},
                {false,false,false,false,false,false}
        };

        // Stub the updated array
        boolean[][] mockArray2 = {
                {false,false,false,false,false,false},
                {false,true,true,false,false,false},
                {false,true,false,false,false,false},
                {false,false,false,false,true,false},
                {false,false,false,true,true,false},
                {false,false,false,false,false,false}
        };

        // Mock return value
        when(grid.getObservableUniverse()).thenReturn(mockArray2);
        GridAdministrator administrator = new GridAdministrator(grid);

        // Get next state
        boolean[][] updatedGrid = administrator.advanceTimeAndReturnNextFrame();

        // The Beacon Oscillator
        for (int rowIndex = 0; rowIndex < updatedGrid.length; rowIndex++) {
            Assertions.assertArrayEquals(updatedGrid[rowIndex],mockArray1[rowIndex]);
        }
    }
}
