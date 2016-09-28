package io.egen.movieflix.service;

import io.egen.movieflix.entity.User;

public interface UserService {

	public User create(User user);

	public User login(User user);
}
