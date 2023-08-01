package testcase;

import core.configuration.Configuration;
import core.datadriven.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.*;

public class BaseTest {
    public WebDriver driver;
    public HomeTestPage homeTestPage;
    public EditPage editPage;
    public ClickPage clickPage;
    public DropdownPage dropdownPage;
    public DialogPage dialogPage;
    public InnerHTMLPage innerHTMLPage;

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
        innerHTMLPage = new InnerHTMLPage(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
