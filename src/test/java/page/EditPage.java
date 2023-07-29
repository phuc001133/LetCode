package page;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditPage extends BasePage{
    public EditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "fullName")
    private WebElement txtFullName;

    @FindBy(how = How.ID, using = "join")
    private WebElement txtJoinText;

    @FindBy(how = How.ID, using = "getMe")
    private WebElement txtGetMe;

    @FindBy(how = How.ID, using = "clearMe")
    private WebElement txtClearMe;

    @FindBy(how = How.ID, using = "noEdit")
    private WebElement txtUnableEdit;

    @FindBy(how = How.ID, using = "dontwrite")
    private WebElement txtReadOnly;

    public void inputFullName(String fullName) {
        actionKeyword.setText(txtFullName, fullName);
        allureReport.saveScreenshot("After fill fullname");
    }

    public void clickOnFullnameTextField() {
        actionKeyword.click(txtFullName);
    }

    public String getFullname() {
        return txtFullName.getAttribute("value");
    }

    public void pressTab_from_txtFullName_to_txtJoinText() throws InterruptedException {
        actionKeyword.press_tab_key();
    }

    public String getTextOf_txtJoinText() {
        return txtJoinText.getAttribute("value");
    }

    public String getAttributeOf_txtGetMe(String attribute) {
        return txtGetMe.getAttribute(attribute);
    }

    public void clearContentOf_txtClearMe() {
        txtClearMe.clear();
    }

    public boolean isEnableEditTextField() {
        return txtUnableEdit.isEnabled();
    }

    public boolean isTxtReadOnlyCanNotEdit() {
        try {
            txtReadOnly.clear();
        } catch (InvalidElementStateException e) {
            //txtReadOnly can read only
            return true;
        }
        //txtReadOnly can edit
        return false;
    }

}
