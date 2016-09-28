package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Comment;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.User;
import io.egen.movieflix.service.MovieService;

@RestController
@RequestMapping(value="/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
	@Autowired
	private MovieService service;

		//find all movies
		@RequestMapping(method = RequestMethod.GET,path="/findmovies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> findMovies() {
			return service.findMovies();
		}
		
		//top rated movies
		@RequestMapping(method = RequestMethod.GET,path="/topratedmovies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> findTopRatedMovies() {
			return service.findTopRatedMovies();
		}
		//find all series
		@RequestMapping(method = RequestMethod.GET,path="/findseries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> findSeries() {
			return service.findSeries();
		}
		
		//top rated series
		@RequestMapping(method = RequestMethod.GET,path="/topratedseries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> findTopRatedSeries() {
			return service.findTopRatedSeries();
		}
		
		//filter movies by year
		@RequestMapping(method = RequestMethod.GET,path="/moviesfilter/year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterMoviesByYear(@PathVariable("year") String year) {
			return service.filterMoviesByYear(year);
		}
		
		//filter movies by specific genre 
		@RequestMapping(method = RequestMethod.GET,path="/moviesfilter/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterMoviesByGenre(@PathVariable("pgenre") String genre) {
			return service.filterMoviesByGenre(genre);
		}
		
		//filter series by specific genre
		@RequestMapping(method = RequestMethod.GET,path="/seriesfilter/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterSeriesByGenre(@PathVariable("pgenre") String genre) {
			return service.filterSeriesByGenre(genre);
		}	
		//sort movies by imdbratings
		@RequestMapping(method = RequestMethod.GET,path="/sortmovies/imdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByImdbRatings() {
			return service.sortMovieByImdbRatings();
		}
		
		//sort series by imdbratings
		@RequestMapping(method = RequestMethod.GET,path="/sorstseries/imdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByImdbRatings() {
			return service.sortSeriesByImdbRatings();
		}
		
		//sort movies by year
		@RequestMapping(method = RequestMethod.GET,path="/sortmovies/year", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByYear() {
			return service.sortMovieByYear();
		}
		
		//sort series by year
		@RequestMapping(method = RequestMethod.GET,path="/sortseries/year", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByYear() {
			return service.sortSeriesByYear();
		}
		
		
		//sort movies by imdb votes
		@RequestMapping(method = RequestMethod.GET,path="/sortmovies/imdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMoviesByvotes() {
			return service.sortMoviesByvotes();
		}
		
		//sort series by imdb votes
		@RequestMapping(method = RequestMethod.GET,path="/sortseries/imdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByvotes() {
			return service.sortSeriesByvotes();
		}	
		
		//Get details of a specific movie
		@RequestMapping(method = RequestMethod.GET,path="/moviedetails/{movie_name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movie findMovieDetails(@PathVariable("movie_name") String name) {
			return service.findMovieDetails(name);
		}
		
		@RequestMapping(method=RequestMethod.POST,path="/ratemovie/{movie_id}/{rating}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
		public Movie rateMovie(@PathVariable("movie_id") String movieId,@PathVariable("rating") int rating){	
			return service.addRating(movieId,rating);
		}
		
		@RequestMapping(method=RequestMethod.POST,path="/addcomment/{movie_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
		public Movie addComment(@PathVariable("movie_id") String movieId,@RequestBody Comment comment){	
			return service.addComment(movieId,comment);
		}
		
}
