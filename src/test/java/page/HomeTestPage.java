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
    private WebElement btnLogo_GoToHomePage;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Edit")
    private WebElement btnEditInputFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Click")
    private WebElement btnButtonFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Drop-Down")
    private WebElement btnDropDownFeature;






    public void goToPage(String pageName) {
        allureReport.saveScreenshot("Home Page");
        switch (pageName) {
            case "Edit":
                actionKeyword.click(btnEditInputFeature);
                allureReport.saveScreenshot("After click on Edit button");
                break;
            case "Button":
                actionKeyword.click(btnButtonFeature);
                allureReport.saveScreenshot("After click on 'Click' going to Button Page");
                break;
            case "Drop-Down" :
                actionKeyword.click(btnDropDownFeature);
                allureReport.saveScreenshot("After click on 'Drop-Down' to going to Drop-down page");
                break;

            default:
                actionKeyword.click(btnEditInputFeature);
                driver.navigate().back();


        }
    }



}
