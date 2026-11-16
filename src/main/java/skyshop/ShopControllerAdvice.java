package skyshop;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import skyshop.model.error.ShopError;
import skyshop.exception.NoSuchProductException;

    @RestControllerAdvice
    public class ShopControllerAdvice {

        @ExceptionHandler(NoSuchProductException.class)
        public ResponseEntity<ShopError> handleNoSuchProduct(
                NoSuchProductException exception) {
            ShopError error = new ShopError(
                    "PRODUCT_NOT_FOUND",
                    exception.getMessage()
            );

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

