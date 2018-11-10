package cz.ucl.javase.dictionary;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertyReader {

    public Properties readProperties(String propertiesName) {
        Properties properties = new Properties();

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesName)){
            properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        } catch ( IOException ex) {
            System.err.println(ex);
        }
        return properties;
    }


}
