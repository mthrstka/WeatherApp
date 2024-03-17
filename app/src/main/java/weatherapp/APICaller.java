package weatherapp;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

public class APICaller {
    // Look into using Google's AI for this as well
    HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.NORMAL).build();

    public String makeRequest(double latitude, double longitude) throws IOException, InterruptedException { // TODO: Could we add a lat/lon lookup class as well for location? Standard user would not know this info
        return sendRequest("https://api.weather.gov/points/" + latitude + "," + longitude);
    }

    private String sendRequest(String url) throws IOException, InterruptedException{
        HttpResponse<String> result;
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();


        /* Get response */
        result = client.send(request, BodyHandlers.ofString());

        return result.body();
    }

    public static void main(String[] args) {

    }
}
