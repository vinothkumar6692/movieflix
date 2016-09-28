package io.egen.movieflix.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.UserService;

@RestController
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	private UserService service;
	@RequestMapping(method=RequestMethod.GET)
	public String findAll(){
	 return "Users";
	}
	@RequestMapping(method=RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createOne(@RequestBody User user){
		return service.create(user);
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public User login(@RequestBody User user){	
		return service.login(user);
	}

}
