package com.album.albumrater.services;
import com.album.albumrater.logic.Album;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class SpotifyAPI {
    public static Album getAlbumsFromArtistWithSpotify(String artistInput, String accessToken) {
        try {
            String url = "https://api.spotify.com/v1/search?q=artist:" + artistInput.replace(" ", "+") + "&type=track&limit=1";
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
            connection.setRequestProperty("Content-Type", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                //response omzetten naar een json object
                JsonElement jsonElement = JsonParser.parseString(response.toString());
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                //de structuur van de json response is gecompliceerd, er zitten veel arrays in arrays
                //arrays van de response in objecten zetten
                JsonObject tracksObject = jsonObject.getAsJsonObject("tracks");
                JsonArray itemsArray = tracksObject.getAsJsonArray("items");

                String albumName = "";
                String artistName = artistInput;
                String albumRelease = "";
                String albumLink = "";
                String albumArt = "";


                for (JsonElement json : itemsArray) {
                    JsonObject itemObject = json.getAsJsonObject();
                    JsonObject albumObject = itemObject.getAsJsonObject("album");
                    albumName = albumObject.get("name").getAsString();
                    albumRelease = albumObject.get("release_date").getAsString();

                    JsonObject URLObject = albumObject.getAsJsonObject("external_urls");
                    albumLink = URLObject.get("spotify").getAsString();

                    JsonArray ImageArray = albumObject.getAsJsonArray("images");
                    for (JsonElement imageElement: ImageArray) { // Limit naar 1
                        JsonObject imageObject = imageElement.getAsJsonObject();
                        albumArt = imageObject.get("url").getAsString();
                    }
                }
                Album album = new Album(0, albumName, artistName, albumRelease, albumLink, albumArt);

                return album;
            } else {
                System.out.println("Request failed: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            System.out.println("RequestArtistInfo: " + e.getMessage());
            return null;
        }
    }
}