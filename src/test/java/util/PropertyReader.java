package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Property reader reads the properties from config.properties file. Currently there are two available properties:
 * browser - where the tests should run (chrome = desktop chrome, mobile = mobile emulation)
 * timeout - how long WebDriver should wait for the elements (in seconds). Set to 2, but it is recommended to increase
 * the value if the tested website is under heavy load.
 */
public class PropertyReader {

    private Properties properties = new Properties();
    private InputStream inputStream = null;

    public PropertyReader() {
        loadProperties();
    }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}
