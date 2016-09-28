package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Comment;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository repository;

	@Override
	@Transactional
	public List<Movie> findMovies() {	
		return repository.findMovies();
	}

	@Override
	@Transactional
	public List<Movie> findTopRatedMovies() {
		return repository.findTopRatedMovies();
	}

	@Override
	@Transactional
	public List<Movie> findSeries() {
		return repository.findSeries();
	}

	@Override
	@Transactional
	public List<Movie> findTopRatedSeries() {
		return repository.findTopRatedSeries();
	}

	@Override
	@Transactional
	public List<Movie> filterMoviesByYear(String year) {
		return repository.filterMoviesByYear(year);
	}

	@Override
	@Transactional
	public List<Movie> filterMoviesByGenre(String genre) {
		return repository.filterMoviesByGenre(genre);
	}

	@Override
	@Transactional
	public List<Movie> filterSeriesByGenre(Object genre) {
		return repository.filterSeriesByGenre(genre);
	}

	@Override
	@Transactional
	public List<Movie> sortMovieByImdbRatings() {
		return repository.sortMovieByImdbRatings();
	}

	@Override
	@Transactional
	public List<Movie> sortSeriesByImdbRatings() {
		return repository.sortSeriesByImdbRatings();
	}

	@Override
	@Transactional
	public List<Movie> sortMovieByYear() {
		return repository.sortMovieByYear();
	}

	@Override
	@Transactional
	public List<Movie> sortSeriesByYear() {
		return repository.sortSeriesByYear();
	}

	@Override
	@Transactional
	public List<Movie> sortMoviesByvotes() {
		return repository.sortMoviesByvotes();
	}

	@Override
	@Transactional
	public List<Movie> sortSeriesByvotes() {
		return repository.sortSeriesByvotes();
	}

	@Override
	@Transactional
	public Movie findMovieDetails(String name) {
		return repository.findMovieDetails(name);
	}

	@Override
	public Movie addRating(String movieId, int rating) {
		return repository.addRating(movieId,rating);
	}

	@Override
	public Movie addComment(String movieId, Comment comment) {		
		return repository.addComment(movieId,comment);
	}
}
