package code.review.universe;

public class GridRules {
    /**
     * @param cellLives boolean value describing cell state as live or dead
     * @param neighbourhoodLiveCount live cells in neighbourhood, including the cell in question
     * @return whether cell should live or not
     */
    public static boolean cellShouldLiveNextRound(boolean cellLives, int neighbourhoodLiveCount) {
        // Do not return from the dead
        if (cellLives) {
            // underpopulation or overpopulation
            // Die
            return neighbourhoodLiveCount >= 3 && neighbourhoodLiveCount <= 4;
        } else return neighbourhoodLiveCount == 3;
        // Live and let live
    }
}
