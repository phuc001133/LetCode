package page;

import org.junit.experimental.theories.Theories;
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

    @FindBy(how = How.ID, using = "color")
    private WebElement btnColor;

    @FindBy(how = How.ID, using = "property")
    private WebElement btnHeightAndWidth;

    @FindBy(how = How.CSS, using = ".field:nth-of-type(6) button")
    private WebElement btnClickAndHold;

    @FindBy(how = How.CSS, using = ".field:nth-of-type(5) button")
    private WebElement btnDisabled;

    public void clickBtnGoToHome() {
        actionKeyword.click(btnGoToHome);
        allureReport.saveScreenshot("After go to home page");
    }

    public Point getLocation() {
        return btnFindLocation.getLocation();
    }

    public String getColorOfColorButton() {
        return btnColor.getCssValue("background-color");
    }

    public String getHeightAndWidthOfButton() {
        return String.valueOf(btnHeightAndWidth.getSize());
    }

    public boolean isDisabledButton() {
        return !btnDisabled.isEnabled();
    }

    public String getTextOfBtnClickAndHoldAfterClickAndHold() throws InterruptedException {
        actionKeyword.clickAndHoldButton(btnClickAndHold);
        Thread.sleep(500);
        return btnClickAndHold.getText();
    }

}
