package code.review.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class PropertiesHelper {
    public static Properties getProperties() {
        int gridWidth = 0;
        int gridHeight= 0;

        Properties properties = new Properties();
        try {

            InputStream input = new FileInputStream("src/main/resources/config.properties");
            properties.load(input);
            int maxWidth = Integer.parseInt((String) properties.get("UNIVERSE_WIDTH_BOUNDARY"));
            int maxHeight = Integer.parseInt((String) properties.get("UNIVERSE_HEIGHT_BOUNDARY"));

            gridWidth = new Random().nextInt(maxWidth);
            gridHeight = new Random().nextInt(maxHeight);


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException np) {
            Random random = new Random();
            gridWidth = random.nextInt(400);
            gridHeight = random.nextInt(400);
        }

        properties.setProperty("Grid Width",String.valueOf(gridWidth));
        properties.setProperty("Grid Height",String.valueOf(gridHeight));
        return properties;
    }
}
