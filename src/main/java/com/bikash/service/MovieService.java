package com.bikash.service;

import com.bikash.model.Movie;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MovieService {
    private static final String API_KEY = "a2ddfee7";
    private static final String BASE_URL = "https://www.omdbapi.com/";

    public List<Movie> searchMovies(String title) {
        List<Movie> movies = new ArrayList<>();
        try {
            String encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
            String query = BASE_URL + "?s=" + encodedTitle + "&apikey=" + API_KEY;
            HttpURLConnection conn = (HttpURLConnection) new URL(query).openConnection();
            conn.setRequestMethod("GET");

            JsonObject json = JsonParser.parseReader(new InputStreamReader(conn.getInputStream())).getAsJsonObject();

            if (json.has("Response") && json.get("Response").getAsString().equals("False")) {
                System.out.println("API Error: " + json.get("Error").getAsString());
                return movies;
            }

            JsonElement searchElement = json.get("Search");
            if (searchElement != null && searchElement.isJsonArray()) {
                movies = new Gson().fromJson(searchElement, new TypeToken<List<Movie>>() {}.getType());
            }
        } catch (Exception e) {
            System.err.println("Error fetching movie data: " + e.getMessage());
        }
        return movies;
    }
}