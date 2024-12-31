package com.example.kartiksapra.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kartiksapra.watchlist.entity.Movie;

@Repository // Marks this interface as a Spring Data repository
public interface MovieRepo extends JpaRepository<Movie, Integer> 
{
	// JpaRepository provides basic CRUD operations for the Movie entity
	// No additional methods are required here unless custom queries are needed
}

