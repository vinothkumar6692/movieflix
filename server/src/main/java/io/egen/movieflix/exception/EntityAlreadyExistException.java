package io.egen.movieflix.exception;

public class EntityAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 5603051271523964879L;

	public EntityAlreadyExistException(String message){
		super(message);
	}

}
