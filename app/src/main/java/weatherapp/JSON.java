package weatherapp;

import org.json.JSONArray;
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
        if(location.equals(""))
            return object.toString();

        String[] locationArray = location.split("/");
        String result = null;


        for (String index : locationArray){
            try{
                if(index.contains("[")){
                    String arrayIndex = index.substring(0, index.indexOf("["));
                    int arrayNum = Integer.parseInt(index.substring(index.indexOf("[")+1, index.indexOf("]")));
                    JSONArray array = object.getJSONArray(arrayIndex);
                    object = array.getJSONObject(arrayNum); // NOTE: This assumes we do not have another array inside this array... If we do this will NOT work.
                } else
                    object = object.getJSONObject(index);
            } catch (JSONException e) { // This is fine, means we are at the last object
                return object.get(index).toString();
            }
        }

        return object.toString(); // If we ever reach this point, just return whatever is still left

    }

    // public static String[] getArray() {

    // }
}
