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

    public String getFullname() {
        return txtFullName.getAttribute("value");
    }

    public void pressTab_from_txtFullName_to_txtJoinText() {
        allureReport.saveScreenshot("Before press TAB key");
        actionKeyword.press_tab_key(txtFullName);
        allureReport.saveScreenshot("After press TAB key");
    }

    public String getTextOf_txtJoinText() {
        return txtJoinText.getAttribute("value");
    }

    public String getAttributeOf_txtGetMe() {
        return txtGetMe.getAttribute("value");
    }

    public void clearContentOf_txtClearMe() {
        allureReport.saveScreenshot("Before clear text content");
        txtClearMe.clear();
        allureReport.saveScreenshot("After clear text content");
    }

    public boolean isEmptyTextfield() {
        return txtClearMe.getAttribute("value").isEmpty();
    }

    public boolean isDisableEditTextField() {
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
