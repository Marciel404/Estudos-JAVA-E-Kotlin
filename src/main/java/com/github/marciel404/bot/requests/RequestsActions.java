package com.github.marciel404.bot.requests;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestsActions {

    @NotNull
    public static String kissRequestGif(){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create("https://api.otakugifs.xyz/gif?reaction=kiss&format=gif"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject json = new JSONObject(response.body());

        return ""+json.get("url");

    }

    @NotNull
    public static String hugRequestGif(){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create("https://api.otakugifs.xyz/gif?reaction=hug&format=gif"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject json = new JSONObject(response.body());

        return ""+json.get("url");

    }

    @NotNull
    public static String slapRequestGif(){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create("https://api.otakugifs.xyz/gif?reaction=slap&format=gif"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject json = new JSONObject(response.body());

        return ""+json.get("url");

    }

    @NotNull
    public static String punchRequestGif(){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create("https://api.otakugifs.xyz/gif?reaction=punch&format=gif"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject json = new JSONObject(response.body());

        return ""+json.get("url");

    }
}
