package core.helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JSONHelper {

    /***
     * Read .json file and handling data transfer from json to object[][]
     * @param filePath: file path contain json file
     * @return object[total object][attribute object]
     */
    public static Object[][] readJsonFromFile(String filePath) {
        //create obj var two dimension to contain data from file
        Object[][] dataProvider;

        //open and read the file containing the file path parameter
        try(Reader reader = new FileReader(filePath)) {

            //transfer all json node to json array
            JsonArray data = JsonParser.parseReader(reader).getAsJsonArray();

            //get first obj of json arr to define number of attributes
            JsonObject firstObject = (JsonObject) data.get(0);

            //get number of atts one obj
            int width = firstObject.size();

            //get number of object (node) in array
            int height = data.size();

            //init Object[][] with height and width below
            dataProvider = new Object[height][width];

            //iterate over all object in the array
            for (int i = 0; i < height; i++) {

                //get object at index i
                JsonObject object = (JsonObject) data.get(i);

                //create String key[] to contain all key of objects
                String key[] = object.keySet().toArray(new String[0]);

                //iterate over all attribute of an obj
                for (int j = 0; j < width; j++) {
                    //assign empty string if obj isn't contain any char
                    String dataFromKey = object.get(key[j]).toString();
                    String optimizeData = dataFromKey.substring(1, dataFromKey.length() - 1);
                    dataProvider[i][j] = optimizeData;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return empty object if it has error
        return new Object[0][0];
    }
}
