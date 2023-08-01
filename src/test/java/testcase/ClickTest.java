package testcase;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ClickPage;

import java.io.IOException;

@Epic("All about Button element test cases")
@Severity(SeverityLevel.NORMAL)
@Link("https://letcode.in/buttons")
public class ClickTest extends BaseTest {
    @Test(priority = 1)
    public void verifyClickToButtonGotoHomeAndComeBackClickPage() {
        homeTestPage.goToPage("Click");

        clickPage.clickBtnGoToHome();
        if (driver.getCurrentUrl().equals("https://letcode.in/")) {
            driver.navigate().back();
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://letcode.in/buttons");
    }


    @Test(priority = 2)
    public void verifyGetLocationOfBtnFindElement() throws IOException {
        homeTestPage.goToPage("Click");

        Assert.assertEquals(clickPage.getLocation(), new Point(72,338));
    }


    @Test(priority = 3)
    public void verifyGetColorOfColorButton() throws IOException {
        homeTestPage.goToPage("Click");
        Assert.assertEquals(clickPage.getColorOfColorButton(), "rgba(138, 77, 118, 1)");
    }

    @Test(priority = 4)
    public void verifyGetHeightAndWidthOfButton() throws IOException {
        homeTestPage.goToPage("Click");
        Assert.assertEquals(clickPage.getHeightAndWidthOfButton(), "(176, 40)");
    }

    @Test(priority = 5)
    public void verifyIsDisabledButton() throws IOException {
        homeTestPage.goToPage("Click");
        Assert.assertTrue(clickPage.isDisabledButton());
    }

    @Test(priority = 6)
    public void verifyPerformClickAndHoldButtonSuccessfully() throws InterruptedException, IOException {
        homeTestPage.goToPage("Click");
        Assert.assertEquals(clickPage.getTextOfBtnClickAndHoldAfterClickAndHold(), "Button has been long pressed");
    }



}
