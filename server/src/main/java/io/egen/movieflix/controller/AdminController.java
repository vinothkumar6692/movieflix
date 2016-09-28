package io.egen.movieflix.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.egen.movieflix.entity.*;
import io.egen.movieflix.service.AdminService;

@RestController
@RequestMapping(value="/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminController {
	@Autowired
	private AdminService service;
	
	@RequestMapping(method=RequestMethod.POST,path="/addmovie", consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createOne(@RequestBody String object) throws JsonParseException, JsonMappingException, IOException{
		//System.out.println(movie.getActors());
		ObjectMapper mapper = new ObjectMapper();
		Movie movie = mapper.readValue(object, Movie.class);
		Genre g = mapper.readValue(object, Genre.class);
		System.err.println(movie.getActors());
		System.err.println(g.getType());
		return service.create(movie);
	}

}
