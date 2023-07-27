package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import page.HomeTestPage;

public class EndToEnd extends BaseTest {

    @Test
    public void verifyOpenUpWebsite() {
        HomeTestPage homeTestPage = new HomeTestPage(driver);
        Assert.assertTrue(homeTestPage.isBtnEditInputFeatureDisplay());
    }
}
