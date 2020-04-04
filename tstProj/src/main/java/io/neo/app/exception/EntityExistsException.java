package io.neo.app.exception;


public class EntityExistsException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

    public EntityExistsException(String str) {
        super(str);
    }

}
