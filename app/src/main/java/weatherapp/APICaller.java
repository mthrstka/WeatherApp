package weatherapp;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class APICaller {
    // Look into using Google's AI for this as well
    HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.NORMAL).build();

    public String requestLocation(double latitude, double longitude) throws IOException, InterruptedException { // TODO: Could we add a lat/lon lookup class as well for location? Standard user would not know this info
        return sendRequest("https://api.weather.gov/points/" + latitude + "," + longitude);
    }

    public String sendRequest(String url) throws IOException, InterruptedException{
        HttpResponse<String> result;
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();


        /* Get response */
        result = client.send(request, BodyHandlers.ofString());

        return result.body(); // TODO: Eventually, this should return a JSON variable
    }

    public static void main(String[] args) {
        APICaller apiCaller = new APICaller();
        try {
            JSON data = new JSON(apiCaller.requestLocation(44.0499, -91.63946));
            System.out.println(apiCaller.sendRequest(data.getString("properties/forecast")));

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
