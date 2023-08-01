package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAcceptAlert() {
        homeTestPage.goToPage("Dialog");
        dialogPage.clickOnBtnSimpleAlert();

        boolean isDisplayMessageOfAlert = dialogPage.getTextInAlert().contentEquals("Hey! Welcome to LetCode");

        dialogPage.clickOnAcceptButtonWhenAlertDisplayed();

        Assert.assertTrue(isDisplayMessageOfAlert);
    }

    @Test(priority = 2)
    public void verifyDismissAlert() {
        homeTestPage.goToPage("Dialog");
        dialogPage.clickOnBtnConfirmAlert();

        boolean isDisplayMessageOfAlert = dialogPage.getTextInAlert().contentEquals("Are you happy with LetCode?");
        dialogPage.dismissAlert();

        Assert.assertTrue(isDisplayMessageOfAlert);
    }

    @Test(priority = 3)
    public void verifyInputTextToPromptAlert() {
        homeTestPage.goToPage("Dialog");
        dialogPage.clickOnBtnPromptAlert();

        dialogPage.inputTextInAlert("Phuc Nguyen");
        dialogPage.clickOnAcceptButtonWhenAlertDisplayed();

        Assert.assertTrue(dialogPage.isDisplayNotification());
    }

    @Test(priority = 4)
    public void verifyModernAlertShowUpSuccessfully() {
        homeTestPage.goToPage("Dialog");
        dialogPage.clickOnBtnModernAlert();

        Assert.assertTrue(dialogPage.isDisplayMessageOfModernAlert());
    }

}
