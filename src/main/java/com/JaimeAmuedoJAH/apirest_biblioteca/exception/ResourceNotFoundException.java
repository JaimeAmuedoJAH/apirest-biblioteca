package com.JaimeAmuedoJAH.apirest_biblioteca.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, Object id) {
        super(resourceName + " con id " + id + " no encontrado");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
