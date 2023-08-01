package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DialogPage extends BasePage{
    public DialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "accept")
    private WebElement btnSimpleAlert;

    @FindBy(how = How.ID, using = "confirm")
    private WebElement btnConfirmAlert;

    @FindBy(how = How.ID, using = "prompt")
    private WebElement btnPromptAlert;

    @FindBy(how = How.ID, using = "myName")
    private WebElement lblNotification;

    @FindBy(how = How.ID, using = "modern")
    private WebElement btnModernAlert;

    @FindBy(how = How.CLASS_NAME, using = "title")
    private WebElement lblMessageOfModernAlert;

    public void clickOnBtnSimpleAlert() {
        actionKeyword.click(btnSimpleAlert);
    }

    public void clickOnBtnConfirmAlert() {
        actionKeyword.click(btnConfirmAlert);
    }

    public void clickOnBtnPromptAlert() {
        actionKeyword.click(btnPromptAlert);
    }

    public void clickOnBtnModernAlert() {
        actionKeyword.click(btnModernAlert);
    }

    public void clickOnAcceptButtonWhenAlertDisplayed() {
        actionKeyword.acceptAlert();
    }

    public void dismissAlert() {
        actionKeyword.dismissAlert();
    }

    public String getTextInAlert() {
        return actionKeyword.getTextOfAlert();
    }

    public void inputTextInAlert(String content) {
        actionKeyword.inputContentInPromptAlert(content);

    }

    public boolean isDisplayNotification() {
        return lblNotification.isDisplayed();
    }

    public boolean isDisplayMessageOfModernAlert() {
        return lblMessageOfModernAlert.isDisplayed();
    }

}
