package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeTestPage extends BasePage{
    public HomeTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement lblNameOfHomeTestPage;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Edit")
    private WebElement btnEditInputFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Click")
    private WebElement btnButtonFeature;

    public String getNameOfHomeTestPage() {
        allureReport.saveScreenshot("Home Test Page");
        return lblNameOfHomeTestPage.getText();
    }

    public void clickOn_btnEdit_GoToInputPage() {
        actionKeyword.click(btnEditInputFeature);
        allureReport.saveScreenshot("Click on Edit button");
    }

    public void clickOn_btnBtnFeature_GoToButtonPage() {
        actionKeyword.click(btnButtonFeature);
        allureReport.saveScreenshot("Click on Button going to Button Page");
    }




}
