package com.JaimeAmuedoJAH.apirest_biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para representar errores de tipo "Bad Request" (400).
 *
 * Se lanza cuando el cliente envía datos inválidos o incompletos en la petición.
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
