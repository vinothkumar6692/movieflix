package io.egen.movieflix.repository;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Genre;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@PersistenceContext
	private EntityManager em; 

	@Override
	public User create(User user) {

		
		em.persist(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(users.size()==1){
			return users.get(0);
		}
		else
			return null;
	}

	@Override
	public User login(User user) {
				TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
				query.setParameter("pEmail", user.getEmail());
				List<User> users = query.getResultList();
				if (users != null && users.size() == 1) {		
						return users.get(0);
				}
				
				return null;
	}

}
