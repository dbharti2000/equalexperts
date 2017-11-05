package hotel.booking.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReaders {

    Properties properties = new Properties();
    InputStream inputStream = null;

    public PropertyReaders() { loadProperties();}

    private void loadProperties() {
        try{
            inputStream = new FileInputStream("src/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key){
        return properties.getProperty(key);
    }
}
