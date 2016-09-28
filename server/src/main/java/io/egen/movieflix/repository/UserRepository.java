package io.egen.movieflix.repository;

import io.egen.movieflix.entity.User;

public interface UserRepository {

	User create(User user);

	User findByEmail(String email);
	
	User login(User user);

}
