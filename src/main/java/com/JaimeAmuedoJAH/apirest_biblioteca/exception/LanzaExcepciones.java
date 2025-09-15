package com.JaimeAmuedoJAH.apirest_biblioteca.exception;

/**
 * Clase de utilidad para lanzar excepciones personalizadas.
 *
 * Proporciona métodos estáticos que permiten verificar condiciones
 * y lanzar excepciones de negocio en caso de incumplimiento.
 */

public class LanzaExcepciones {

    public static BadRequestException lanzarBadRequest(String mensaje){
        throw new BadRequestException(mensaje);
    }

    public static ResourceNotFoundException lanzarNotFound(String clase, Integer id){
        throw new ResourceNotFoundException(clase, id);
    }

    public static ResourceNotFoundException lanzarNotFound(){
        throw new ResourceNotFoundException("No existe ningun registro");
    }

    public static ResourceNotFoundException lanzarNotFound(String mensaje){
        throw new ResourceNotFoundException(mensaje);
    }

    public static InternalErrorException lanzarInternal(String mensaje){
        throw new InternalErrorException(mensaje);
    }
}
