package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException extends ResponseStatusException {

    public CustomException(HttpStatus status) {
        super(status);
    }
}
