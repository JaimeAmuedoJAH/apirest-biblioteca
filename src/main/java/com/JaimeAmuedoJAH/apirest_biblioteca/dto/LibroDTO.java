package com.JaimeAmuedoJAH.apirest_biblioteca.dto;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class LibroDTO {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String nombreAutor;
    private String genero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_publicacion;

    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.descripcion = libro.getDescripcion();
        this.nombreAutor = libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos();
        this.genero = libro.getGenero().getNombre();
        this.fecha_publicacion = libro.getFecha_publicacion();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
}
