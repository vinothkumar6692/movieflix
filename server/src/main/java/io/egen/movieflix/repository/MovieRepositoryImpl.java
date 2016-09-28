package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.*;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@PersistenceContext
	public EntityManager em;

	@Override
	public List<Movie> findMovies() {
		TypedQuery<Type> query = em.createNamedQuery("Type.findMovies", Type.class);
		List<Movie> movies=query.getResultList().get(0).getMovies();
		return movies;
	}

	@Override
	public List<Movie> findTopRatedMovies() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedMovies", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> findSeries() {
		TypedQuery<Type> query = em.createNamedQuery("Type.findSeries", Type.class);
		List<Movie> movies=query.getResultList().get(0).getMovies();
		return movies;
	}

	@Override
	public List<Movie> findTopRatedSeries() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedSeries", Movie.class);
		return query.getResultList(); 
	}

	@Override
	public List<Movie> filterMoviesByYear(String year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterMoviesByYear", Movie.class);
		query.setParameter("pyear", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> filterMoviesByGenre(String genre) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSpecificGenreMovies", Genre.class);
		query.setParameter("pgenre", genre);
		Genre movieGenre = query.getResultList().get(0);
		return movieGenre.getMovies();
	}

	@Override
	public List<Movie> filterSeriesByGenre(Object genre) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSpecificGenreSeries", Genre.class);
		query.setParameter("pgenre", genre);
		Genre movieGenre = query.getResultList().get(0);
		return movieGenre.getMovies();
	}

	@Override
	public List<Movie> sortSeriesByImdbRatings() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedSeries", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMovieByImdbRatings() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByImdbRatings", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMovieByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByYear", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortSeriesByYear", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMoviesByvotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByImdbVotes", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByvotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByImdbRatings", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findMovieDetails(String name) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findMovieDetails", Movie.class);
		query.setParameter("ptitle", name);
		Movie movie = query.getResultList().get(0);
		return movie;
	}

	@Override
	public Movie addRating(String movieId, int rating) {
		Movie currentMovie= em.find(Movie.class, movieId);
		int newMovieFlixRatingTotal = currentMovie.getMovieFlixRatingTotal() + rating;
		int newMovieFlixRatingVote = currentMovie.getMovieFlixRatingVotes() + 1;
		int newMovieFlixRating = newMovieFlixRatingTotal/newMovieFlixRatingVote;
		currentMovie.setMovieFlixRatingTotal(newMovieFlixRating);
		em.merge(currentMovie);
		return currentMovie;
	}

	@Override
	public Movie addComment(String movieId, Comment comment) {
		Movie currentMovie= em.find(Movie.class, movieId);
		List<Comment> comments = currentMovie.getComments();
		comments.add(comment);
		em.merge(currentMovie);
		return currentMovie;
	}
	

}
