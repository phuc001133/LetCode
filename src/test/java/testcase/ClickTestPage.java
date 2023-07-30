package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickTestPage extends BaseTest {
    @Test(priority = 1)
    public void verifyClickToButtonGotoHomeAndComeBackClickPage() {
        homeTestPage.goToPage("Button");
        clickPage.clickBtnGoToHome();
        if (driver.getCurrentUrl().equals("https://letcode.in/")) {
            driver.navigate().back();
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://letcode.in/buttons");
    }

}
