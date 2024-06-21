package me.dioSantander.santanderAPIRest.Domain.Controller.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * Classe global de tratamento de exceções para controladores REST.
 * Utiliza @RestControllerAdvice para aplicar tratamento de exceções em todo o projeto.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Trata exceções do tipo IllegalArgumentException.
     *
     * @param bussinesException A exceção lançada.
     * @return ResponseEntity com a mensagem de erro e status UNPROCESSABLE_ENTITY.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBussinesException(IllegalArgumentException bussinesException) {
        return new ResponseEntity<>(bussinesException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Trata exceções do tipo NoSuchElementException.
     *
     * @param notFoundException A exceção lançada.
     * @return ResponseEntity com a mensagem "Resource ID not found" e status NOT_FOUND.
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
        return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
    }

    /**
     * Trata quaisquer outras exceções inesperadas (Throwable).
     *
     * @param unexpectedException A exceção lançada.
     * @return ResponseEntity com a mensagem "unexpected server error." e status NOT_FOUND.
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        var message = "unexpected server error, see the logs";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>("unexpected server error.", HttpStatus.NOT_FOUND);
    }
}