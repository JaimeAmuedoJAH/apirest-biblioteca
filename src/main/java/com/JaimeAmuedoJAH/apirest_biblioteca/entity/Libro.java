package com.JaimeAmuedoJAH.apirest_biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "libro")
/* Evita ciclos infinitos en la serialización JSON.
   Usa la propiedad "id" como identificador único: la primera vez se serializa el objeto completo,
   y en las siguientes referencias solo se muestra el id.*/
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="genero_id")
    private Genero genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha_publicacion;

    public Libro() {}

    public Libro(Integer id, String titulo, String descripcion, Autor autor, Genero genero, LocalDate fecha_publicacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", autor=" + autor +
                ", genero=" + genero +
                ", fecha_publicacion=" + fecha_publicacion +
                '}';
    }
}
