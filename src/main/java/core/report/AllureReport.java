package core.report;

import core.configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AllureReport {

    private WebDriver driver;
    private Configuration configuration = new Configuration("src/test/resources/app.properties");

//    public AllureReport(WebDriver driver) {
//        this.driver = driver;
//    }

    /***
     * image attachment to report after test
     * @param imageName name of image
     * @return byte[] to upload image
     */
    @Attachment(value = "Image: {imageName}", type = "image/png")
    public byte[] saveScreenshot(String imageName) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public void writeEnvironmentConfig() {
        try {
            File environment = new File("allure-results/environment.properties");

            Writer writer = new FileWriter(environment);

            writer.write("Browser_name = " + configuration.getProperty("browser"));
            writer.write("\n");

            writer.write("Operating system name = " + System.getProperty("os.name"));
            writer.write("\n");

            writer.write("Java JDK version = " + System.getProperty("java.version"));
            writer.write("\n");

            writer.write("Link of website project for testing = " + configuration.getProperty("url"));
            writer.write("\n");

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
