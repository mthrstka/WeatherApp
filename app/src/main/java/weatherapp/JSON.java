package weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class JSON {
    private JSONObject object;

    public JSON(String jsonString) {
        try {
            object = new JSONObject(jsonString);
        } catch (JSONException e) {
            System.err.println("The passed string is not a JSON object, or cannot be parsed as one.");
            System.err.println("JSON string: " + jsonString);
            e.printStackTrace();
        }
    }

    public String getString(String location) { // Get value in directory format, seperated by '/' (like a file system)

        String[] locationArray = location.split("/");
        String result = null;

        for (String index : locationArray){
            try{
                object = object.getJSONObject(index);
            } catch (JSONException e) { // This is fine, means we are at the last object
                result = object.get(index).toString();
            }
        }

        return result;

    }

    // public static String[] getArray() {

    // }
}
