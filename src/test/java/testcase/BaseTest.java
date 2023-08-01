package testcase;

import core.configuration.Configuration;
import core.datadriven.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.*;

import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public HomeTestPage homeTestPage;
    public EditPage editPage;
    public ClickPage clickPage;
    public DropdownPage dropdownPage;
    public DialogPage dialogPage;

    @BeforeMethod
    public void setUp() throws Exception {
        Configuration configuration = new Configuration("src/test/resources/app.properties");
        driver = DriverFactory.getDriver(configuration.getProperty("browser"));
        driver.get(configuration.getProperty("url"));
        homeTestPage = new HomeTestPage(driver);
        editPage = new EditPage(driver);
        clickPage = new ClickPage(driver);
        dropdownPage = new DropdownPage(driver);
        dialogPage = new DialogPage(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
