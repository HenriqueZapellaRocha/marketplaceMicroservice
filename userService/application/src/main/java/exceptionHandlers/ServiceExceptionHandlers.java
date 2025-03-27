package exceptionHandlers;

import domain.exceptions.UserCreationErrorDTO;
import domain.exceptions.UserCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ServiceExceptionHandlers {

    @ResponseStatus( HttpStatus.CONFLICT )
    @ResponseBody
    @ExceptionHandler( UserCreationException.class )
    public Mono<UserCreationErrorDTO> handler( final UserCreationException e ) {
        return Mono.just( new UserCreationErrorDTO( e.getMessage() ) );
    }
}
