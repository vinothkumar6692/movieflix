package io.egen.movieflix.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
public class Comment {
	
	@Id
	private String commentID;
	
	public String getCommentId() {
		return commentID;
	}

	private String comment;
	
	public Comment(){
		 this.commentID = UUID.randomUUID().toString(); 
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComment() {
		return comment;
	}
	

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
