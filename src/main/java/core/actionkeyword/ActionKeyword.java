package core.actionkeyword;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionKeyword {
    WebDriver driver;
    WebDriverWait wait;


    public ActionKeyword(WebDriver driver) {
        this.driver = driver;
        //Explicit wait will pause excute script until satisfied with a condition or maximum time has elapsed
        wait = new WebDriverWait(this.driver, 10);

    }

    public WebElement findElement(By location) {
        return driver.findElement(location);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void inputContentInPromptAlert(String content) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(content);
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextOfAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void clickAndHoldButton(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }


    public void press_tab_key(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        element.sendKeys(Keys.TAB);
    }

    /**
     * move to element and perform click element
     * @param element you want to click
     */
    public void click(WebElement element) {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    /***
     * Input a text content in the text-field
     * @param element text-field you want to input text
     * @param text : content text want to input
     * @return
     */
    public void setText(WebElement element, String text) {
        try {
            //clear content text if it has before input text
            element.clear();
            //input content text if a text-field is enabled to input
            if (element.isEnabled()) {
                //input content text if is enable to input
                element.sendKeys(text);
            }

        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }

    }

    /***
     * perform select option of drop down list element
     * @param element drop down list
     * @param type: chose type you want to select by index/text or value
     * @param option value of option want to select
     * @throws Exception if method select has error
     */
    public void select(WebElement element, SelectType type, String option) throws Exception {
        Select select = new Select(element);

        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(option));
                } catch (Exception e) {
                    throw new Exception("Please input numberic on select by index");
                }
                break;

            case SELECT_BY_TEXT:
                select.selectByVisibleText(option);
                break;

            case SELECT_BY_VALUE:
                select.selectByValue(option);
                break;

            default:
                throw new Exception("Get error in using Selected");
        }
    }

    public enum SelectType {
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE
    }
}
