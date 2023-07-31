package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {
    @Test(priority = 1)
    public void verifyChoseDropDownItemSuccessfully() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        dropdownPage.chooseFruit("Apple");
        Assert.assertTrue(dropdownPage.isDisplayNotificationAfterChoseItem());
    }

    @Test(priority = 2)
    public void verifyIsMultipleSelection() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        Assert.assertTrue(dropdownPage.isMultiple());
    }

    @Test(priority = 3)
    public void verifyChoseSuperHeroFromMultipleSelectByValueSuccessfully() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        dropdownPage.choseSuperheroFromMultipleSelect_byValue("Hellboy");
        Assert.assertTrue(dropdownPage.isDisplayNotificationAfterChoseItem());
    }

    @Test(priority = 4)
    public void verifyChoseSuperHeroFromMultipleSelectByIndexSuccessfully() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        dropdownPage.choseSuperheroFromMultipleSelect_byIndex("16");
        Assert.assertTrue(dropdownPage.isDisplayNotificationAfterChoseItem());
    }

    @Test(priority = 5)
    public void verifySelectedTheLastProgrammingLanguageSuccessfully() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        dropdownPage.choseLastProgrammingLanguage();
        Assert.assertTrue(dropdownPage.isDisplayNotificationAfterChoseItem());
    }

    @Test(priority = 6)
    public void verifySelectIndiaUsingValueSuccessfully() throws Exception {
        homeTestPage.goToPage("Drop-Down");
        dropdownPage.selectIndiaUsingValue();
        Assert.assertTrue(dropdownPage.isIndiaAtCountrySelect());
    }

}
