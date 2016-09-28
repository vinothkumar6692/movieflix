package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.User;
import io.egen.movieflix.exception.EntityAlreadyExistException;
import io.egen.movieflix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;
	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing!=null){
			throw new EntityAlreadyExistException("User already exists with same email");
		}
		return repository.create(user);
	}
	@Override
	@Transactional
	public User login(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing!=null && existing.getPassword().equals(user.getPassword())){
			return user;
		}
		return null;
	}

}
