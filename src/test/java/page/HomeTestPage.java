package page;

import core.configuration.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.List;

public class HomeTestPage extends BasePage{
    public HomeTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Edit")
    private WebElement btnEditInputFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Click")
    private WebElement btnButtonFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Drop-Down")
    private WebElement btnDropDownFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Dialog")
    private WebElement btnDialogFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Inner HTML")
    private WebElement btnInnerHTMLFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Toggle")
    private WebElement btnToggle;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Tabs")
    private WebElement btnTabs;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Find Elements")
    private WebElement btnFindElements;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "AUI - 1")
    private WebElement btnDragFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "AUI - 2")
    private WebElement btnDropFeature;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "AUI - 3")
    private WebElement btnSort;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "AUI - 4")
    private WebElement btnMultiSelect;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "AUI - 5")
    private WebElement btnSlider;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Simple table")
    private WebElement btnBasicTable;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Advance table")
    private WebElement btnAdvanceTable;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Date & Time")
    private WebElement btnDateAndTime;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Timeout")
    private WebElement btnTimeout;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "All in One")
    private WebElement btnForm;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "File management")
    private WebElement btnFile;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "DOM")
    private WebElement btnDOM;


    public void goingToPage(String pageName) throws IOException {
        Configuration configuration = new Configuration("src/test/resources/app.properties");

        try {
            driver.navigate().to("https://letcode.in/test/"+pageName);
        } catch (Exception e) {

        } finally {
            driver.navigate().to(configuration.getProperty("url"));
        }
    }

    public void goToPage(String pageName) {
        allureReport.saveScreenshot("Home Page");
        switch (pageName) {
            case "Edit":
                actionKeyword.click(btnEditInputFeature);
                allureReport.saveScreenshot("After click on 'Edit' to going to Input page");
                break;

            case "Click":
                actionKeyword.click(btnButtonFeature);
                allureReport.saveScreenshot("After click on 'Click' going to Button Page");
                break;

            case "Drop-Down" :
                actionKeyword.click(btnDropDownFeature);
                allureReport.saveScreenshot("After click on 'Drop-Down' to going to Drop-down page");
                break;

            case "Dialog" :
                actionKeyword.click(btnDialogFeature);
                allureReport.saveScreenshot("After click on 'Dialog' to going to Dialog page");
                break;

            case "Inner HTML" :
                actionKeyword.click(btnInnerHTMLFeature);
                allureReport.saveScreenshot("After click on 'Inner HTML' to going to Frame page");
                break;

            case "Toggle" :
                actionKeyword.click(btnToggle);
                allureReport.saveScreenshot("After click on 'Toggle' to going to Radio & Checkbox page");
                break;

            case "Tabs" :
                actionKeyword.click(btnTabs);
                allureReport.saveScreenshot("After click on 'Tabs' to going to Tabs page");
                break;

            case "Find Element" :
                actionKeyword.click(btnFindElements);
                allureReport.saveScreenshot("After click on 'Find Elements' to going to Find Elements page");
                break;

            case "AUI - 1" :
                actionKeyword.click(btnDragFeature);
                allureReport.saveScreenshot("After click on 'AUI - 1' to going to Drag page");
                break;

            case "AUI - 2" :
                actionKeyword.click(btnDropFeature);
                allureReport.saveScreenshot("After click on 'AUI - 2' to going to Drop page");
                break;

            case "AUI - 3" :
                actionKeyword.click(btnSort);
                allureReport.saveScreenshot("After click on 'AUI - 3' to going to Sort page");
                break;

            case "AUI - 4" :
                actionKeyword.click(btnMultiSelect);
                allureReport.saveScreenshot("After click on 'AUI - 4' to going to Multi Select page");
                break;

            case "AUI - 5" :
                actionKeyword.click(btnSlider);
                allureReport.saveScreenshot("After click on 'AUI - 5' to going to Slider page");
                break;

            case "Simple table" :
                actionKeyword.click(btnBasicTable);
                allureReport.saveScreenshot("After click on 'Simple table' to going to Simple table page");
                break;

            case "Advance table" :
                actionKeyword.click(btnAdvanceTable);
                allureReport.saveScreenshot("After click on 'Advance table' to going to Advance table page");
                break;

            case "Date & Time" :
                actionKeyword.click(btnDateAndTime);
                allureReport.saveScreenshot("After click on 'Date & Time' to going to Date & Time page");
                break;

            case "Timeout" :
                actionKeyword.click(btnTimeout);
                allureReport.saveScreenshot("After click on 'Timeout' to going to Waits page");
                break;

            case "All in One" :
                actionKeyword.click(btnForm);
                allureReport.saveScreenshot("After click on 'All in One' to going to Forms page");
                break;

            case "File management" :
                actionKeyword.click(btnFile);
                allureReport.saveScreenshot("After click on 'File management' to going to File management page");
                break;

            case "DOM" :
                actionKeyword.click(btnDOM);
                allureReport.saveScreenshot("After click on 'DOM' to going to DOM page");
                break;

            default:
                actionKeyword.click(btnEditInputFeature);
                driver.navigate().back();

        }
    }



}
