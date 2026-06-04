package com.sergio.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manejador de excepciones para UserNotFoundException.
     * Intercepta el error cuando el usuario no existe y transforma la respuesta.
     *
     * @param ex La excepción capturada que contiene el mensaje de error.
     * @return ResponseEntity con el código 404 y el mensaje de error en formato JSON.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.getReasonPhrase()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    /**
     * Manejador de excepciones para MethodArgumentNotValidException
     * Intercepta el error cuando el usuario no introduce datos válidos y transforma la respuesta.
     *
     * @param ex La excepción capturada que contiene el mensaje de error.
     * @return ResponseEntity con el código 400 y el mensaje de error en formato JSON.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        /*
         * Recorre la lista de errores de validación y los agrega al mapa 'errors'
         * siendo la clave el nombre de la variable que fallo y el valor el mensaje de error correspondiente.
         */
        ex.getBindingResult().getFieldErrors().forEach((error) ->
                errors.put(error.getField(), error.getDefaultMessage()));

        ErrorResponse errorResponse = new ErrorResponse(
                errors,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.getReasonPhrase()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
