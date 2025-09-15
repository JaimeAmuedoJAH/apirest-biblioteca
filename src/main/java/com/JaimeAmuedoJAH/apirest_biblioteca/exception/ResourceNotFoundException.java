package com.JaimeAmuedoJAH.apirest_biblioteca.exception;

/**
 * Excepción personalizada para representar errores de tipo "Not found" (404).
 *
 * Se lanza cuando el cliente no encuentra un recurso.
 */

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, Object id) {
        super(resourceName + " con id " + id + " no encontrado");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
