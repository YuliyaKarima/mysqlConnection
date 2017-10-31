package service;

import java.io.*;
import java.util.Properties;

public class PropertiesService {
    static Properties properties = new Properties();

    public static Properties getProperty(String filePath) {
        InputStream input = null;
        try {
            input = new BufferedInputStream(
                    new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
