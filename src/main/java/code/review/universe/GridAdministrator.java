package code.review.universe;

public class GridAdministrator extends GridRules {
    private boolean[][] boolBoard;
    private int[][] boolBoardCounter;

    public GridAdministrator(TheGrid theGrid) {
        this.boolBoard = theGrid.getObservableUniverse();
        this.boolBoardCounter = new int[this.boolBoard.length][];
        for (int rowIndex = 0; rowIndex < this.boolBoard.length; rowIndex++) {
            this.boolBoardCounter[rowIndex] = new int[this.boolBoard[rowIndex].length];
        }
    }

    private void setLiveCellCount(int rowIndex, int columnIndex) {
        int liveCellCount = 0;

        // Get row index boundaries
        int neighbourhoodRowStartIndex = Integer.max(0, rowIndex - 1);
        int neighbourhoodRowBreakIndex = Integer.min(this.boolBoard.length,rowIndex + 2);

        // Get column index boundaries
        int neighbourhoodColumnStartIndex = Integer.max(0, columnIndex - 1);
        int neighbourhoodColumnBreakIndex = Integer.min(this.boolBoard[rowIndex].length,columnIndex + 2);

        // Loop over neighbourhood cells, including given cell
        for (int neighbourhoodRowIndex = neighbourhoodRowStartIndex; neighbourhoodRowIndex < neighbourhoodRowBreakIndex ; neighbourhoodRowIndex++) {
            for (int neighbourhoodColumnIndex = neighbourhoodColumnStartIndex; neighbourhoodColumnIndex < neighbourhoodColumnBreakIndex; neighbourhoodColumnIndex++) {
                liveCellCount += this.boolBoard[neighbourhoodRowIndex][neighbourhoodColumnIndex] ? 1 : 0;
            }
        }
        this.boolBoardCounter[rowIndex][columnIndex] = liveCellCount;
    }

    private void updateGrid(){
        for (int rowIndex = 0; rowIndex < this.boolBoard.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.boolBoard[rowIndex].length; columnIndex++) {
                this.boolBoard[rowIndex][columnIndex] = this.getNextValueForCell(rowIndex,columnIndex);
            }
        }
    }

    public boolean[][] getUpdatedGrid() {
        updateGrid();
        return this.boolBoard;
    }

    public void tick() {

        for (int rowIndex = 0; rowIndex < this.boolBoard.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.boolBoard[rowIndex].length; columnIndex++) {
                setLiveCellCount(rowIndex,columnIndex);
            }
        }
    }

    private boolean getNextValueForCell(int rowIndex, int columnIndex) {
        return GridRules.cellShouldLiveNextRound(this.boolBoard[rowIndex][columnIndex],this.boolBoardCounter[rowIndex][columnIndex]);
    }
}
