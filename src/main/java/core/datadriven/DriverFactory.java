package core.datadriven;

import core.configuration.Configuration;
import core.report.AllureReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

    public static WebDriver getDriver(String browser) throws Exception {

        AllureReport allureReport = new AllureReport();
        allureReport.writeEnvironmentConfig();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("incognito");
                chromeOptions.addArguments("--kiosk");

                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();

            case "opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            case "microsoft edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "internet explorer":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();

            default:
                throw new Exception(new Exception("Can not find browser to open up"));
        }

    }
}
