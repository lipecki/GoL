package code.review.universe;

public class GridRules {
    /**
     * @param cellIsLive boolean value describing cell state as live or dead
     * @param neighbourhoodLiveCount live cells in neighbourhood, including the cell in question
     * @return whether cell should live or not
     */
    public static boolean cellShouldLiveNextRound(boolean cellIsLive, int neighbourhoodLiveCount) {
        if (cellIsLive) {
            // underpopulation or overpopulation
            if (neighbourhoodLiveCount < 2 || neighbourhoodLiveCount > 4) {
                // die
                return false;
            }
        } else if (neighbourhoodLiveCount != 3) {
                // do not return from the dead
                return false;
        }
        return true;
    }
}
