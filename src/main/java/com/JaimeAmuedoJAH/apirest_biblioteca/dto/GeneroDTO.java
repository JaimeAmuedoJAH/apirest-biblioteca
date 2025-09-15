package com.JaimeAmuedoJAH.apirest_biblioteca.dto;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import java.util.List;

/**
 * DTO (Data Transfer Object) para la entidad Género.
 *
 * Se usa para transferir datos de género en operaciones CRUD
 * sin exponer directamente la entidad {@link Genero}.
 */

public class GeneroDTO {

    private String nombre;

    private List<String> listLibros;

    public GeneroDTO(Genero genero) {
        this.nombre = genero.getNombre();
        this.listLibros = obtenerNombreLibros(genero.getListLibro());
    }

    private List<String> obtenerNombreLibros(List<Libro> listLibro) {
        if(listLibro == null) return null;

        return listLibro.stream()
                .map(Libro::getTitulo)
                .toList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<String> listLibros) {
        this.listLibros = listLibros;
    }
}
