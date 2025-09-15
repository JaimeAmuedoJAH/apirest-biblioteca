package com.JaimeAmuedoJAH.apirest_biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Entidad que representa un Género literario en la biblioteca.
 *
 * Ejemplos: Ciencia Ficción, Novela, Fantasía, Historia, etc.
 * Cada género puede estar asociado a múltiples libros.
 */

@Entity
@Table(name = "genero")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 50)
    private String nombre;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> listLibro;

    public Genero() {}

    public Genero(Integer id, String nombre, List<Libro> listLibro) {
        this.id = id;
        this.nombre = nombre;
        this.listLibro = listLibro;
    }

    public Genero(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getListLibro() {
        return listLibro;
    }

    public void setListLibro(List<Libro> listLibro) {
        this.listLibro = listLibro;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listLibro=" + listLibro +
                '}';
    }
}
