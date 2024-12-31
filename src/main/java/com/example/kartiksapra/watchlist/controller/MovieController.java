package com.example.kartiksapra.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.kartiksapra.watchlist.entity.Movie;
import com.example.kartiksapra.watchlist.service.DatabaseService;

/**
 * Controller for handling requests related to movie watchlist operations.
 */
@RestController
public class MovieController 
{
	@Autowired
	DatabaseService databaseService; // Injecting the DatabaseService for CRUD operations on Movie entity

    /**
     * Displays the form for adding/editing a movie in the watchlist.
     * If an id is provided, it fetches the existing movie to edit.
     */
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) 
	{
		System.out.println(id);
		String viewName = "watchlistItemForm"; // View for adding/editing movies
		
		Map<String, Object> model = new HashMap<>();
		
		// If no id is provided, create a new Movie object, else fetch the existing movie
		if(id == null) 
		{
			model.put("watchlistItem", new Movie());
		} 
		else 
		{
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		
		return new ModelAndView(viewName, model);
	}
	
    /**
     * Handles the form submission for adding or updating a movie.
     * If there are validation errors, redisplays the form.
     */
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) 
		{
			System.out.println(bindingResult.hasErrors());
			// If errors are present, redisplay the form to correct them
			return new ModelAndView("watchlistItemForm");
		}
		
		// If the movie ID is null, create a new movie, otherwise update the existing movie
		Integer id = movie.getId();
		if(id == null) 
		{
			databaseService.create(movie);
		} 
		else 
		{
			databaseService.update(movie, id);
		}
		
		// Redirect to the watchlist page after successful submission
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		return new ModelAndView(rd);
	}
	
    /**
     * Fetches and displays all movies in the watchlist.
     */
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() 
	{
		String viewName = "watchlist"; // View for displaying the list of movies
		Map<String, Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getAllMovies(); // Fetching all movies from the database
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName, model);
	}

    /**
     * Displays the home page.
     */
	@GetMapping("/index")
	public ModelAndView showHomePage() 
	{
		String viewName = "index"; // View for the home page
		Map<String, Object> model = new HashMap<>();
		return new ModelAndView(viewName, model);
	}
}
