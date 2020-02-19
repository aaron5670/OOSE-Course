package nl.han.ica.oose.dea.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubService {

    public String getIndexHtml() {
        return getRequest("https://github.com/");
    }

    public String getReadme() {
        return getRequest("https://raw.githubusercontent.com/HANICA-DEA/exercise-http-client/master/README.md");
    }

    private String getRequest(String s) {
        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(URI.create(s)).build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response.body() != null ? response.body() : "Error can't fetch!";
    }
}
