package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Libro;

import java.util.List;

public interface ILibro {

    Libro saveLibro(Libro libro);

    List<Libro> saveAllLibros(List<Libro> libroList);

    List<LibroDTO> findAll();

    LibroDTO findById(Integer id);

    Libro updateLibro(Libro libro);

    void deleteById(Integer id);

    List<LibroDTO> obtenerLibroPorGenero(Integer id);

    List<LibroDTO> obtenerLibroPorAutor(Integer id);
}
