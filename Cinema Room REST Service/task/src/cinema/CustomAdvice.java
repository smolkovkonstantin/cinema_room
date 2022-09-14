package cinema;

import exception.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class CustomAdvice {


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorMessage> returnOnlyReason(ResponseStatusException e) {
        return new ResponseEntity<>( new ErrorMessage( e.getReason() ), e.getStatus());
    }
}