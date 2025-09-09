package com.JaimeAmuedoJAH.apirest_biblioteca.dto;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDTO {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String biografia;
    private LocalDate fecha_nacimiento;
    private List<String> listLibros;

    /*Importante al crear el constructor tienes que tener como parametro un objeto del tipo al que quieras realizar un DTO
    * de esta forma consigues mapearlo para que puedas leerlo con el formato que le des.*/
    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellidos = autor.getApellidos();
        this.biografia = autor.getBiografia();
        this.fecha_nacimiento = autor.getFecha_nacimiento();
        this.listLibros = obtenerNombreLibros(autor.getListLibros());
    }

    private List<String> obtenerNombreLibros(List<Libro> listLibros){

        if(listLibros == null) return null;

        return listLibros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.toList());
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List<String> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<String> listLibros) {
        this.listLibros = listLibros;
    }
}
