package testdata;

import core.helper.JSONHelper;
import org.testng.annotations.DataProvider;

public class InputTestData {

    /**
     * read data example for input method exercise
     * @return object[][] contain data
     */
    @DataProvider
    public static Object[][] exampleDataFromJson() {
        return JSONHelper.readJsonFromFile("src/test/java/data/example.json");
    }
}
