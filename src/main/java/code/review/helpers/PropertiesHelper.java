package code.review.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class PropertiesHelper {
    public static Properties getProperties(String[] args) {
        int gridWidth = 0;
        int gridHeight= 0;

        if (args.length > 1) {
            gridWidth = Integer.parseInt(args[1]);
            if(args.length > 2) {
                gridHeight = Integer.parseInt(args[2]);
            }
        }

        Properties properties = new Properties();
        try {

            InputStream input = new FileInputStream("src/main/resources/config.properties");
            properties.load(input);
            int maxWidth = Integer.parseInt((String) properties.get("UNIVERSE_WIDTH_BOUNDARY"));
            int maxHeight = Integer.parseInt((String) properties.get("UNIVERSE_HEIGHT_BOUNDARY"));
            if (args.length < 2) {
                gridWidth = new Random().nextInt(maxWidth);
            } else if (args.length < 3) {
                gridHeight = new Random().nextInt(maxHeight);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException np) {
            gridWidth = new Random().nextInt(400);
            gridHeight = new Random().nextInt(400);
        }

        properties.setProperty("Grid Width",String.valueOf(gridWidth));
        properties.setProperty("Grid Height",String.valueOf(gridHeight));
        return properties;
    }
}
