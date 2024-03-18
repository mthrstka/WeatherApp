package weatherapp;

import java.io.IOException;

public class Forecast {
    double latitude, longitude;
    APICaller apiCaller = new APICaller();

    public Forecast(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Day getTodaysForecast() {
        try {
            String jsonString = apiCaller.requestLocation(latitude, longitude);
            JSON json = new JSON(jsonString);
            String forecastUrl = json.getString("properties/forecast");
            String forecastJSON = apiCaller.sendRequest(forecastUrl);
            json = new JSON(forecastJSON);
            return new Day(json.getString("properties/periods[0]"));
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        Forecast forecast = new Forecast(44.0499, -91.6394);
        forecast.getTodaysForecast();
    }
}
