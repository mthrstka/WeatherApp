package weatherapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class APICallerTest {
    @Test void apiCallReturnsValue(){
        APICaller test = new APICaller();
        String result = null;
        try {
            result = test.requestLocation(44.0499, -91.63946 ); // Winona MN
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    @Test void apiReturnsForecast() {
        APICaller apiCaller = new APICaller();
        try {
            JSON data = new JSON(apiCaller.requestLocation(44.0499, -91.63946));
            assertNotNull(apiCaller.sendRequest(data.getString("properties/forecast")));
            // TODO: Add a specific thing to check for as well instead of just 'is null'

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
