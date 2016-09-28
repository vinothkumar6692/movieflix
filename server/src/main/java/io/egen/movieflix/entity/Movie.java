package io.egen.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity 
@Table 
@NamedQueries({
	@NamedQuery(name = "Movie.findMovieDetails", query ="Select m from Movie m where m.title=:ptitle"),
	@NamedQuery(name = "Movie.filterMoviesByYear", query ="Select m from Movie m where m.year=:pyear"),
	@NamedQuery(name = "Movie.sortMoviesByImdbRatings", query ="Select m from Movie m order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.sortMoviesByYear", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.year desc"),
	@NamedQuery(name = "Movie.sortSeriesByYear", query ="Select m from Movie m join Type t1 with t1.type='series' order by m.year desc"),
	@NamedQuery(name = "Movie.sortMoviesByImdbVotes", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.sortSeriesByImdbVotes", query ="Select m from Movie m join Type t1 with t1.type='series' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.findTopRatedMovies", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.findTopRatedSeries",query ="Select m from Movie m join Type t1 with t1.type='series' order by m.imdbRatings desc"), 
})
public class Movie {
	
	@Id
	private String movieID;
	
	public Movie(){
		this.movieID = UUID.randomUUID().toString(); 
	}
	
	@JsonProperty("Rated")
	private String Rated;
	
	@JsonProperty("Year")
	private String Year;
	
	@JsonProperty("Language")
	private String Language;
	
	@JsonProperty("Country")
	private String Country;
	
	@JsonProperty("Awards")
	private String Awards;
	
	@JsonProperty("Poster")
	private String Poster;
	
	@JsonProperty("Plot")
	private String Plot;
	
	@JsonProperty("imdbRatings")
	private float imdbRatings;
	
	@JsonProperty("Director")
	private String Director;
	
	@JsonProperty("Writer")
	private String Writer;
	
	@JsonProperty("Actors")
	private String Actors;
	
	@JsonProperty("imdbVotes")
	private int imdbVotes;
	
	@JsonProperty("Title")
	private String Title;
	
	@JsonProperty("Released")
	private String Released;
	
	@JsonProperty("Runtime")
	private String Runtime;
	
	@JsonProperty("Metascore")
	private int Metascore;
	
	@JsonProperty("imdbID")
	private int imdbID;
	
	@JsonProperty("movieFlixRatingTotal")
	private int movieFlixRatingTotal;
	
	@JsonProperty("movieFlixRatingVotes")
	private int movieFlixRatingVotes;
	
	@JsonProperty("movieFlixRating")
	private float movieFlixRating;
	
	private List<Comment> comments;
	
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    @JoinTable(name="Movie_Genre",
        joinColumns = @JoinColumn(name="movieID"),
        inverseJoinColumns = @JoinColumn(name="genreID")
              )
	@JsonProperty("Genre")
	@JsonIgnore 
	private List<Genre> Genre;
	
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    @JoinTable(name="Movie_Type",
        joinColumns = @JoinColumn(name="movieID"),
        inverseJoinColumns = @JoinColumn(name="typeID")
              )
	@JsonProperty("Genre")
	@JsonIgnore 
	private List<Type> Type;
	
	public List<Genre> getGenres() {
		return Genre;
	}

	public void setGenres(List<Genre> genres) {
		this.Genre = genres;
	}


	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public float getImdbRatings() {
		return imdbRatings;
	}

	public void setImdbRatings(float imdbRatings) {
		this.imdbRatings = imdbRatings;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		Actors = actors;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getRated() {
		return Rated;
	}

	public void setRated(String rated) {
		Rated = rated;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public int getMetascore() {
		return Metascore;
	}

	public void setMetascore(int metascore) {
		Metascore = metascore;
	}

	public int getImdbID() {
		return imdbID;
	}

	public void setImdbID(int imdbID) {
		this.imdbID = imdbID;
	}

	public List<Genre> getGenre() {
		return Genre;
	}

	public void setGenre(List<Genre> genre) {
		Genre = genre;
	}

	public int getMovieFlixRatingTotal() {
		return movieFlixRatingTotal;
	}

	public void setMovieFlixRatingTotal(int movieFlixRatingTotal) {
		this.movieFlixRatingTotal = movieFlixRatingTotal;
	}

	public int getMovieFlixRatingVotes() {
		return movieFlixRatingVotes;
	}

	public void setMovieFlixRatingVotes(int movieFlixRatingVotes) {
		this.movieFlixRatingVotes = movieFlixRatingVotes;
	}

	public float getMovieFlixRating() {
		return movieFlixRating;
	}

	public void setMovieFlixRating(float movieFlixRating) {
		this.movieFlixRating = movieFlixRating;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Type> getType() {
		return Type;
	}

	public void setType(List<Type> type) {
		Type = type;
	}

	
	
	
}	

