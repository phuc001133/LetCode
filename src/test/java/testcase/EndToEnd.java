package testcase;

import org.junit.Assert;
import org.junit.Test;
import page.HomeTestPage;

public class EndToEnd extends BaseTest {

    @Test
    public void verifyOpenUpWebsite() throws InterruptedException {
        HomeTestPage homeTestPage = new HomeTestPage(driver);

        Assert.assertTrue(homeTestPage.isBtnEditInputFeatureDisplay());
    }
}
