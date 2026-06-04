package com.sergio.usermanagement.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {

    /**
     * Variable para mostrar el mensaje de error.
     * Se utiliza un Object por flexibilidad,
     * ya que puede ser un String simple o un Map de errores de validación.
     */
    private Object message;

    /**
     * Variable para mapear el código de error.
     */
    private int status;

    /**
     * Variable para mapear el momento en que ocurrió el error.
     */
    private LocalDateTime timestamp;

    /**
     * Variable para mapear el tipo de error.
     */
    private String error;

    public ErrorResponse(Object message, int status, LocalDateTime timestamp, String error) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
