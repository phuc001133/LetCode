package page;

import core.actionkeyword.ActionKeyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage{
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "fruits")
    private WebElement ddlFruits;

    @FindBy(how = How.CLASS_NAME, using = "notification")
    private WebElement lblNotification;

    @FindBy(how = How.ID, using = "superheros")
    private WebElement selSuperheros;

    @FindBy(how = How.ID, using = "lang")
    private WebElement selLanguages;

    @FindBy(how = How.ID, using = "country")
    private WebElement selCountry;


    public void chooseFruit(String fruitName) throws Exception {
        allureReport.saveScreenshot("Before select item from drop down list");
        actionKeyword.select(ddlFruits, ActionKeyword.SelectType.SELECT_BY_TEXT, fruitName);
        allureReport.saveScreenshot("after selected item from drop down list");
    }


    public boolean isDisplayNotificationAfterChoseItem() {
        return lblNotification.isDisplayed();
    }

    public boolean isMultiple() {
        Select selectHero = new Select(selSuperheros);
        return selectHero.isMultiple();
    }

    public void choseSuperheroFromMultipleSelect_byValue(String superHeroName) throws Exception {
        allureReport.saveScreenshot("Before select");
        actionKeyword.select(selSuperheros, ActionKeyword.SelectType.SELECT_BY_TEXT, superHeroName);
        allureReport.saveScreenshot("After selected");

    }

    public void choseSuperheroFromMultipleSelect_byIndex(String index) throws Exception {
        allureReport.saveScreenshot("Before select");
        actionKeyword.select(selSuperheros, ActionKeyword.SelectType.SELECT_BY_INDEX, index);
        allureReport.saveScreenshot("After select");
    }

    public void choseLastProgrammingLanguage() throws Exception {
        allureReport.saveScreenshot("Before select");
        Select select = new Select(selLanguages);
        List<WebElement> allOptionLanguages = select.getOptions();
        actionKeyword.select(selLanguages, ActionKeyword.SelectType.SELECT_BY_INDEX, String.valueOf(allOptionLanguages.size() - 1));
        allureReport.saveScreenshot("After select");
    }

    public void selectIndiaUsingValue() throws Exception {
        allureReport.saveScreenshot("Before select");
        actionKeyword.select(selCountry, ActionKeyword.SelectType.SELECT_BY_VALUE, "India");
        allureReport.saveScreenshot("After select");
    }

    public boolean isIndiaAtCountrySelect() {
        return selCountry.getAttribute("value").contentEquals("India");
    }

}
