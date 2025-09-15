package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;

import java.util.List;

/**
 * Interfaz de servicio para gestionar operaciones relacionadas con los autores.
 */

public interface IAutor {

    Autor saveAutor(Autor autor);

    List<Autor> saveAllAutores(List<Autor> autorList);

    List<AutorDTO> findAll();

    AutorDTO findById(Integer id);

    Autor updateAutor(Autor autor);

    void deleteById(Integer id);
}
