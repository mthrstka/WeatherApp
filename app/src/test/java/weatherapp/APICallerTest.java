package weatherapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class APICallerTest {
    @Test void apiCallReturnsValue(){
        APICaller test = new APICaller();
        String result = null;
        try {
            result = test.makeRequest(44.0499, -91.63946 ); // Winona MN
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
