package code.review.universe;

public class GridRules {
    /**
     * @param cellLives boolean value describing cell state as live or dead
     * @param neighbourhoodLiveCount live cells in neighbourhood, including the cell in question
     * @return whether cell should live or not
     */
    public static boolean cellShouldLiveNextRound(boolean cellLives, int neighbourhoodLiveCount) {
        // Live cell rules
        if (cellLives) {
            // Continue living with two or three living neighbours
            return neighbourhoodLiveCount >= 3 && neighbourhoodLiveCount <= 4;

        // Dead cell rules
        // Resurrection at three living neighbours
        } else return neighbourhoodLiveCount == 3;
    }
}
