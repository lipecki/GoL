package code.review.universe;

public class GridAdministrator extends GridRules {
    private final boolean[][] boolGrid;
    private final int[][] neighbourhoodCounter;

    public GridAdministrator(TheGrid theGrid) {
        this.boolGrid = theGrid.getObservableUniverse();
        this.neighbourhoodCounter = new int[this.boolGrid.length][];
        for (int rowIndex = 0; rowIndex < this.boolGrid.length; rowIndex++) {
            this.neighbourhoodCounter[rowIndex] = new int[this.boolGrid[rowIndex].length];
        }
    }

    /**
     * Counts living cells in the neighbourhood by
     * finding neighbourhood indexes (cell index +/-1 in two dimensions),
     * excluding negative and out of bounds indexes,
     * for every cell on the boolGrid, and then updating the neighbourhoodCounter
     *
     * @param rowIndex grid row index
     * @param columnIndex grid column index
     */
    private void setLiveCellCount(int rowIndex, int columnIndex) {
        int liveCellCount = 0;

        // Get row index boundaries
        int neighbourhoodRowStartIndex = Integer.max(0, rowIndex - 1);
        // + 2 row index for the sake of simpler loop syntax
        int neighbourhoodRowBreakIndex = Integer.min(this.boolGrid.length, rowIndex + 2);

        // Get column index boundaries
        int neighbourhoodColumnStartIndex = Integer.max(0, columnIndex - 1);
        int neighbourhoodColumnBreakIndex = Integer.min(this.boolGrid[rowIndex].length, columnIndex + 2);

        // Loop over neighbourhood cells, including given cell
        for (int neighbourhoodRowIndex = neighbourhoodRowStartIndex; neighbourhoodRowIndex < neighbourhoodRowBreakIndex; neighbourhoodRowIndex++) {
            for (int neighbourhoodColumnIndex = neighbourhoodColumnStartIndex; neighbourhoodColumnIndex < neighbourhoodColumnBreakIndex; neighbourhoodColumnIndex++) {
                liveCellCount += this.boolGrid[neighbourhoodRowIndex][neighbourhoodColumnIndex] ? 1 : 0;
            }
        }
        this.neighbourhoodCounter[rowIndex][columnIndex] = liveCellCount;
    }

    private boolean getNextValueForCell(int rowIndex, int columnIndex) {
        boolean currentValue = this.boolGrid[rowIndex][columnIndex];
        int neighbourhoodCount = this.neighbourhoodCounter[rowIndex][columnIndex];
        return GridRules.cellShouldLiveNextRound(currentValue,neighbourhoodCount);
    }

    private void updateGrid() {
        for (int rowIndex = 0; rowIndex < this.boolGrid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.boolGrid[rowIndex].length; columnIndex++) {
                this.boolGrid[rowIndex][columnIndex] = this.getNextValueForCell(rowIndex, columnIndex);
            }
        }
    }

    private void tick() {
        for (int rowIndex = 0; rowIndex < this.boolGrid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.boolGrid[rowIndex].length; columnIndex++) {
                this.setLiveCellCount(rowIndex, columnIndex);
            }
        }
    }

    public boolean[][] advanceTimeAndReturnNextFrame() {
        tick();
        updateGrid();
        return this.boolGrid.clone();
    }
}
