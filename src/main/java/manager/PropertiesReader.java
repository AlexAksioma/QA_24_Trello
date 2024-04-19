package manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final String PATH = "src/test/resources/login.properties";
    public static String getProperty(String key){
        Properties properties =new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
