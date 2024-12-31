package com.example.kartiksapra.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

    String apiUrl = "https://omdbapi.com/?apikey=a8431cee&t="; // OMDB API URL for fetching movie ratings

    @SuppressWarnings("null")
    public String getMovieRating(String title) 
    {
        try 
        {
            // Attempt to fetch the movie rating from the OMDB API using RestTemplate
            RestTemplate template = new RestTemplate();
            
            // Send GET request to fetch movie details including rating
            ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);
            
            // Parse the response and retrieve IMDb rating
            ObjectNode jsonObject = response.getBody();
            System.out.println(jsonObject.path("imdbRating").asText()); // Print the IMDb rating
            return jsonObject.path("imdbRating").asText(); // Return the IMDb rating
        } 
        catch(Exception e) 
        {
            // If there is an error (movie not found or API is down), fall back to returning null
            System.out.println("Either movie name not available or api is down" + e.getMessage());
            return null; // Return null if an error occurs
        }
    }
}

