package core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private Properties prop;
    private InputStream inputStream;
    private String filePath;

    public Configuration(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Read file .properties and get string value of property
     * @param propertyName want to get value
     * @return result value of property
     * @throws IOException
     */
    public String getProperty(String propertyName) throws IOException {
        String result = "";

        try {
            prop = new Properties();

            inputStream = new FileInputStream(this.filePath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file " + filePath + " not found in the classpath");
            }

            result = prop.getProperty(propertyName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
        }

        return result;
    }
}
