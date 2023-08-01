package core.report;

import core.configuration.Configuration;
import core.datadriven.DriverFactory;
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

    public AllureReport() {

    }

    public AllureReport(WebDriver driver) {
        this.driver = driver;
    }

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
            File environment = new File("allure-report/environment.properties");

            Writer writer = new FileWriter(environment);

            writer.write("Browser_name = " + configuration.getProperty("browser"));
            writer.write("\n");

            writer.write("Operating_system_name " + System.getProperty("os.name"));
            writer.write("\n");

            writer.write("Java_JDK_version " + System.getProperty("java.version"));
            writer.write("\n");

            writer.write("Link_of_website_project_for_testing " + configuration.getProperty("url"));
            writer.write("\n");

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
