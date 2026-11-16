package skyshop.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import skyshop.model.error.ShopError;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(String message) {
        super (message);
    }

    }

