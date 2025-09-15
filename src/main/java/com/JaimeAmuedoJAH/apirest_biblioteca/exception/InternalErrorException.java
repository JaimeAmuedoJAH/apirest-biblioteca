package com.JaimeAmuedoJAH.apirest_biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para representar errores internos del servidor (500).
 *
 * Se utiliza cuando ocurre un fallo inesperado en la aplicación
 * que no depende del cliente.
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String message) {
        super(message);
    }
}
