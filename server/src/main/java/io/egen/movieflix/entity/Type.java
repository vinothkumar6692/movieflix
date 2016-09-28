package io.egen.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Type.findSeries", query ="Select t from Type t where t.type='series' "),
	@NamedQuery(name = "Type.findMovies", query ="Select t from Type t where t.type='movie' "),	
})
public class Type {
		
		@Id
		private String typeID;
		
		public Type(){
			this.typeID = UUID.randomUUID().toString(); 
		}

		public String getTypeId() {
			return typeID;
		}

		public void setTypeId(String typeId) {
			this.typeID = typeId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
		private String type;
		
		@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	    @JoinTable(name="Movie_Type",
	        joinColumns = @JoinColumn(name="typeID"),
	        inverseJoinColumns = @JoinColumn(name="movieID")
	              )
		private List<Movie> movies;

		public List<Movie> getMovies() {
			return movies;
		}

		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}

		

}
