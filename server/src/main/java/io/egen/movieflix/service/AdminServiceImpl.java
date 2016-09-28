package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.exception.EntityAlreadyExistException;
import io.egen.movieflix.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository repository;
	
	@Transactional
	@Override
	public Movie create(Movie movie) {
		
		return repository.create(movie);
	}
	
	

}
