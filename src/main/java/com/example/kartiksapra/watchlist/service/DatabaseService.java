package com.example.kartiksapra.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kartiksapra.watchlist.entity.Movie;
import com.example.kartiksapra.watchlist.repository.MovieRepo;

@Service 
public class DatabaseService 
{
    @Autowired
    MovieRepo movieRepo; // Movie repository for database operations
    
    @Autowired
    RatingService ratingService; // Service to fetch movie ratings
    
    public void create(Movie movie) 
    {
        // Fetch rating from RatingService and set it for the movie
        String rating = ratingService.getMovieRating(movie.getTitle());
        if(rating != null) 
        {
            movie.setRating(Float.parseFloat(rating));
        }
        movieRepo.save(movie); // Save movie to the repository
    }
    
    public List<Movie> getAllMovies() 
    {
        return movieRepo.findAll(); // Get all movies from the repository
    }
    
    public Movie getMovieById(Integer id) 
    {
        return movieRepo.findById(id).get(); // Fetch movie by ID
    }

    public void update(Movie movie, Integer id) 
    {
        Movie toBeUpdated = getMovieById(id); // Get movie to update
        // Update movie properties and save
        toBeUpdated.setTitle(movie.getTitle());
        toBeUpdated.setRating(movie.getRating());
        toBeUpdated.setComment(movie.getComment());
        toBeUpdated.setPriority(movie.getPriority());
        
        movieRepo.save(toBeUpdated); // Save the updated movie
    }
}
