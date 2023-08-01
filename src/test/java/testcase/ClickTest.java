package testcase;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickTest extends BaseTest {
    @Test(priority = 1)
    public void verifyClickToButtonGotoHomeAndComeBackClickPage() {
        homeTestPage.goToPage("Button");
        clickPage.clickBtnGoToHome();
        if (driver.getCurrentUrl().equals("https://letcode.in/")) {
            driver.navigate().back();
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://letcode.in/buttons");
    }

    @Test(priority = 2)
    public void verifyGetLocationOfBtnFindElement() {
        homeTestPage.goToPage("Button");

        Assert.assertEquals(clickPage.getLocation(), new Point(72,338));
    }


    @Test(priority = 3)
    public void verifyGetColorOfColorButton() {
        homeTestPage.goToPage("Button");
        Assert.assertEquals(clickPage.getColorOfColorButton(), "rgba(138, 77, 118, 1)");
    }

    @Test(priority = 4)
    public void verifyGetHeightAndWidthOfButton() {
        homeTestPage.goToPage("Button");
        Assert.assertEquals(clickPage.getHeightAndWidthOfButton(), "(176, 40)");
    }

    @Test(priority = 5)
    public void verifyIsDisabledButton() {
        homeTestPage.goToPage("Button");
        Assert.assertTrue(clickPage.isDisabledButton());
    }

    @Test(priority = 6)
    public void verifyPerformClickAndHoldButtonSuccessfully() throws InterruptedException {
        homeTestPage.goToPage("Button");
        Assert.assertEquals(clickPage.getTextOfBtnClickAndHoldAfterClickAndHold(), "Button has been long pressed");
    }
    


}
