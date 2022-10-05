package azure.loc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TechnicalException extends RuntimeException{

    public TechnicalException(String message){
        super(message);
    }
}
