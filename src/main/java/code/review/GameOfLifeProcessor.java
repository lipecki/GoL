package code.review;

import code.review.helpers.PropertiesHelper;
import code.review.universe.TheGrid;
import code.review.universe.GridAdministrator;

import java.util.Arrays;
import java.util.Properties;

public class GameOfLifeProcessor {
    public static void main(String[] args){
        Properties properties  = PropertiesHelper.getProperties(args);
        int boardWidth = Integer.parseInt((String) properties.get("Grid Width"));
        int boardHeight = Integer.parseInt((String) properties.get("Grid Height"));

        TheGrid theGrid = new TheGrid(boardWidth,boardHeight);
        GridAdministrator administrator = new GridAdministrator(theGrid);

        // Run for some multiple of 1/2 second
        for (int time = 0; time < 20; time++) {
            administrator.tick();
            for (boolean[] row : administrator.getUpdatedGrid()) {
                for (boolean b : row) {

                    System.out.print(b ? "X" : "O" );
                }
                System.out.println(String.format("---%d---",time));
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Just carry on
            }
        }
    }
}
