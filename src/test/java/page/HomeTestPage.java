package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeTestPage extends BasePage{
    public HomeTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Edit")
    private WebElement btnEditInputFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Click")
    private WebElement btnButtonFeature;


    public void goToPage(String pageName) {
        switch (pageName) {
            case "Edit":
                actionKeyword.click(btnEditInputFeature);
                allureReport.saveScreenshot("Click on Edit button");
                break;
            case "Button":
                actionKeyword.click(btnButtonFeature);
                allureReport.saveScreenshot("Click on 'Click' going to Button Page");
                break;

        }
    }



}
