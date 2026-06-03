package com.sergio.usermanagement.exceptions;

/**
 * Excepción personalizada para cuando un usuario no es encontrado en el sistema.
 */
public class UserNotFoundException extends RuntimeException{

    /**
     * Constructor que recibe el mensaje personalizado.
     * 'super' le pasa el mensaje a la clase RuntimeException.
     *
     * @param message Mensaje que detalla el error.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
