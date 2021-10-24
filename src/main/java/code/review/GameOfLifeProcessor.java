package code.review;

import code.review.helpers.PropertiesHelper;
import code.review.universe.TheGrid;
import code.review.universe.GridAdministrator;

import java.util.Arrays;
import java.util.Properties;

public class GameOfLifeProcessor {
    public static void main(String[] args){
        Properties properties  = PropertiesHelper.getProperties();
        int boardWidth =  Integer.max(Integer.parseInt((String) properties.get("Grid Width")),4);
        int boardHeight = Integer.max(Integer.parseInt((String) properties.get("Grid Height")),4);

        TheGrid theGrid = new TheGrid(boardWidth,boardHeight);
        GridAdministrator administrator = new GridAdministrator(theGrid);

        // Run for some multiple of 1/2 second
        for (int time = 0; time < 20; time++) {
            System.out.printf("---%d---%n",time);
            for (boolean[] row : administrator.advanceTimeAndReturnNextFrame()) {
                String[] cells = new String[row.length];
                for (int col = 0; col < row.length; col++) {
                    cells[col] = row[col] ? "#" : "0";
                }
                System.out.println(Arrays.toString(cells));
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Just carry on
            }
        }
    }
}
