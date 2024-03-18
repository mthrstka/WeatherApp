package weatherapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JSONTest {
    @Test void readsJSONObject(){
        JSON json = new JSON("{\"Hello\": \"World\", \"Space\":{ \"Moon\":\"Cheese\"}}");
        assertEquals(json.getString("Hello").equals("World"), true);
        assertEquals(json.getString("Space/Moon").equals("Cheese"), true);
    }
}
