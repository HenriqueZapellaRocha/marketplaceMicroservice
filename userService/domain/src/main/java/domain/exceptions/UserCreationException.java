package domain.exceptions;

public class UserCreationException extends RuntimeException {

    public UserCreationException( String message ) {
        super( message );
    }
}
