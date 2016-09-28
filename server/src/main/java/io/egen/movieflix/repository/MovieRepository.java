package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Comment;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;

public interface MovieRepository {

	List<Movie> findMovies();

	List<Movie> findTopRatedMovies();

	List<Movie> findSeries();

	List<Movie> findTopRatedSeries();

	List<Movie> filterMoviesByYear(String year);

	List<Movie> filterMoviesByGenre(String genre);

	List<Movie> filterSeriesByGenre(Object genre);

	List<Movie> sortSeriesByImdbRatings();

	List<Movie> sortMovieByImdbRatings();

	List<Movie> sortMovieByYear();

	List<Movie> sortSeriesByYear();

	List<Movie> sortMoviesByvotes();

	List<Movie> sortSeriesByvotes();

	Movie findMovieDetails(String name);

	Movie addRating(String movieId, int rating);

	Movie addComment(String movieId, Comment comment);

}
