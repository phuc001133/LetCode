package testcase;

import org.openqa.selenium.Point;
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

    @Test(priority = 2)
    public void verifyGetLocationOfBtnFindElement() {
        homeTestPage.goToPage("Button");

        Assert.assertEquals(clickPage.getLocation(), new Point(72,338));
    }

    


}
