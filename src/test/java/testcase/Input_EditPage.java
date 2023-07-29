package testcase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.Assert;
import org.testng.annotations.Test;
import page.EditPage;
import page.HomeTestPage;

public class Input_EditPage extends BaseTest {
    @Epic("Test all about input feature")
    @Test (priority = 1)
    public void verifyAllFeatureOfInputPageIsSuccessfully() throws InterruptedException {
        HomeTestPage homeTestPage = new HomeTestPage(driver);
        homeTestPage.clickOn_btnEdit_GoToInputPage();

        EditPage editPage = new EditPage(driver);
        editPage.inputFullName("Nguyen Phuc Nguyen");

        editPage.pressTab_from_txtFullName_to_txtJoinText();

        Assert.assertEquals("ortonikc", editPage.getAttributeOf_txtGetMe("value"));

        editPage.clearContentOf_txtClearMe();

        boolean isDisableTextField = editPage.isEnableEditTextField();
        Assert.assertFalse(isDisableTextField);

        boolean isReadOnlyTextField = editPage.isTxtReadOnlyCanNotEdit();
        Assert.assertTrue(isReadOnlyTextField);
    }

}
