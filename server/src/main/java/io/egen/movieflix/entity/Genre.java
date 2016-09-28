package io.egen.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Genre.findSpecificGenreSeries", query ="Select g from Genre g join Type t with t.type='series' and g.type=:pgenre"),
	@NamedQuery(name = "Genre.findSpecificGenreMovies", query ="Select g from Genre g join Type t with t.type='movie' and g.type=:pgenre"),
})
public class Genre {
		
		@Id
		
		private String genreID;
		
		public Genre(){
			this.genreID =UUID.randomUUID().toString(); 
		}

		public String getGenreId() { 
			return genreID;
		}

		public void setGenreId(String genreId) {
			this.genreID = genreId;
		}
		@JsonProperty("Genre")
		private String type;
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
		@JsonIgnore
		@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	    @JoinTable(name="Movie_Genre",
	        joinColumns = @JoinColumn(name="genreID"),
	        inverseJoinColumns = @JoinColumn(name="movieID")
	              )
		private List<Movie> movies;

		public List<Movie> getMovies() {
			return movies;
		}

		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}

		@Override
		public String toString() {
			return "Genre [type=" + type + "]";
		}

}

