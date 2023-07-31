package page;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClickPage extends BasePage {
    public ClickPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "home")
    private WebElement btnGoToHome;

    @FindBy(how = How.ID, using = "position")
    private WebElement btnFindLocation;

    public void clickBtnGoToHome() {
        actionKeyword.click(btnGoToHome);
        allureReport.saveScreenshot("After go to home page");
    }

    public Point getLocation() {
        return btnFindLocation.getLocation();
    }


}
