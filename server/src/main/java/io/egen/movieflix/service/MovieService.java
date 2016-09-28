package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Comment;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;

public interface MovieService {

	List<Movie> findMovies();

	List<Movie> findTopRatedMovies();

	List<Movie> findSeries();

	List<Movie> findTopRatedSeries();

	List<Movie> filterMoviesByYear(String y);

	List<Movie> filterMoviesByGenre(String genre);

	List<Movie> filterSeriesByGenre(Object genre);

	List<Movie> sortMovieByImdbRatings();

	List<Movie> sortSeriesByImdbRatings();

	List<Movie> sortMovieByYear();

	List<Movie> sortSeriesByYear();

	List<Movie> sortMoviesByvotes();

	List<Movie> sortSeriesByvotes();

	Movie findMovieDetails(String name);

	Movie addRating(String movieId, int rating);

	Movie addComment(String movieId, Comment comment);

}
