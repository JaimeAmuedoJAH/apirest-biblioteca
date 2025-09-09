package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;

import java.util.List;

public interface IAutor {

    Autor saveAutor(Autor autor);

    List<AutorDTO> findAll();

    AutorDTO findById(Integer id);

    Autor updateAutor(Autor autor);

    void deleteById(Integer id);
}
