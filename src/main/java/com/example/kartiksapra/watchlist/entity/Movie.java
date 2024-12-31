package com.example.kartiksapra.watchlist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.kartiksapra.watchlist.entity.validations.Priority;
import com.example.kartiksapra.watchlist.entity.validations.Rating;

@Entity // Marks this class as a JPA entity for persistence
public class Movie 
{
	@Id // Marks the id field as the primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // Automatically generates the ID value
	private Integer id;
	
	@NotBlank(message = "Please enter the title") // Validates that the title is not blank
	private String title;
	
	@Rating // Custom validation annotation for rating field
	private float rating;
	
	@Priority // Custom validation annotation for priority field
	private String priority;
	
	@Size(max = 50, message = "Comment should be maximum 50 characters") // Validates the size of the comment field
	private String comment;
	
	// Getter and setter methods for each field to allow access and modification
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public float getRating() 
	{
		return rating;
	}
	public void setRating(float rating) 
	{
		this.rating = rating;
	}
	public String getPriority() 
	{
		return priority;
	}
	public void setPriority(String priority) 
	{
		this.priority = priority;
	}
	public String getComment() 
	{
		return comment;
	}
	public void setComment(String comment) 
	{
		this.comment = comment;
	}	
}
