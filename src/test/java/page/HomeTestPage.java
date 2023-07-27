package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeTestPage extends BasePage{
    public HomeTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "[href='/edit']")
    private WebElement btnEditInputFeature;



    public boolean isBtnEditInputFeatureDisplay() throws InterruptedException {
        Thread.sleep(2000);
        return btnEditInputFeature.isDisplayed();
    }


}
