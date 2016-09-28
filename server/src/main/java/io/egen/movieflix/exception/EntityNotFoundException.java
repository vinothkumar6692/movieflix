package io.egen.movieflix.exception;

public class EntityNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 4278346932395947562L;

	public EntityNotFoundException(String message){
		super(message);
	}

}
