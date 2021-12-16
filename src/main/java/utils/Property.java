package utils;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class Property {
  Properties properties = new Properties();

    public Property() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);
    }

    public String getToken() {
        return properties.getProperty("TOKEN");
    }
}