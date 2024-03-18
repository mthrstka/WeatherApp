package weatherapp;

public class Day {
    public String name, startTime, endTime, temperatureTrend, windSpeed, windDirection, forecast, longForecast, temperature, precipitationChance, dewPoint, humidity, temperatureUnit;
    public boolean isDaytime;

    public Day(String jsonString) { // Pass all of the APIs temp JSON info into here. We'll parse it with our JSON class
        JSON json = new JSON(jsonString);
        name = json.getString("name");
        startTime = json.getString("startTime");
        endTime = json.getString("endTime");
        isDaytime = Boolean.parseBoolean(json.getString("isDaytime"));
        temperature = json.getString("temperature");
        temperatureUnit = json.getString("temperatureUnit");
        // precipitationChance = json.getString("probabilityOfPrecipitation/value");
        // dewPoint = json.getString("dewpoint/value");
        // humidity = json.getString("relativeHumidity/value");
        // windSpeed = json.getString("windSpeed");
        // windDirection = json.getString("windDirection");
        forecast = json.getString("shortForecast");
        longForecast = json.getString("detailedForecast");

        System.out.println(name);
        System.out.println(temperature);
        System.out.println(longForecast);
    }
}
