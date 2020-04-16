package propertiesConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropFile {

    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/propertiesConcept/config.properties");
        prop.load(fis);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("URL");
        System.out.println(url);

        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

    }
}
