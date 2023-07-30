package testcase;

import core.configuration.Configuration;
import core.datadriven.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.EditPage;
import page.HomeTestPage;

import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public HomeTestPage homeTestPage;
    public EditPage editPage;

    @BeforeMethod
    public void setUp() throws Exception {
        Configuration configuration = new Configuration("src/test/resources/app.properties");
        driver = DriverFactory.getDriver(configuration.getProperty("browser"));
        driver.get(configuration.getProperty("url"));
        homeTestPage = new HomeTestPage(driver);
        editPage = new EditPage(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
