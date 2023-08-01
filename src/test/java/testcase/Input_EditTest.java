package testcase;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Epic("All about Input (Text field) element test cases ")
@Severity(SeverityLevel.NORMAL)
@Link("https://letcode.in/edit")
public class Input_EditTest extends BaseTest {

    @Test(priority = 1)
    public void verifyInputFullname() {
        homeTestPage.goToPage("Edit");
        editPage.inputFullName("Nguyen Phuc");
        Assert.assertTrue(!editPage.getFullname().isEmpty());
    }

    @Test(priority = 2)
    public void verifyPressTab_from_txtFullName_to_txtJoinTextSuccessfully() {
        homeTestPage.goToPage("Edit");

        editPage.pressTab_from_txtFullName_to_txtJoinText();

        Assert.assertEquals("I am good", editPage.getTextOf_txtJoinText());
    }

    @Test(priority = 3)
    public void verifyGetAttributeContentInTextFieldSuccessfully() {
        homeTestPage.goToPage("Edit");

        editPage.getAttributeOf_txtGetMe();

        Assert.assertTrue(editPage.getAttributeOf_txtGetMe().equals("ortonikc"));
    }

    @Test(priority = 4)
    public void verifyClearContentInTextFieldSuccessfully() {
        homeTestPage.goToPage("Edit");

        editPage.clearContentOf_txtClearMe();

        Assert.assertTrue(editPage.isEmptyTextfield());
    }

    @Test(priority = 5)
    public void verifyDisableTextField() {
        homeTestPage.goToPage("Edit");

        Assert.assertFalse(editPage.isDisableEditTextField());
    }

    @Test(priority = 6)
    public void verifyReadOnlyTextField() {
        homeTestPage.goToPage("Edit");

        boolean isReadOnlyTextField = editPage.isTxtReadOnlyCanNotEdit();
        Assert.assertTrue(isReadOnlyTextField);
    }
}

