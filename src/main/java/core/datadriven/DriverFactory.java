package core.datadriven;

import core.configuration.Configuration;
import core.report.AllureReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {

        AllureReport allureReport = new AllureReport();
        allureReport.writeEnvironmentConfig();

        switch (browser) {
            case "chrome":
                //WebDriverManager is a library help controlling web browser
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("incognito");
                chromeOptions.addArguments("--kiosk");

                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--kiosk");
                firefoxOptions.addArguments("-private");

            case "opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            case "microsoft edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "internet explorer":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();

            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();

            default:
                //run chrome browser if didn't get a browser name
                return new ChromeDriver();
        }

    }
}
