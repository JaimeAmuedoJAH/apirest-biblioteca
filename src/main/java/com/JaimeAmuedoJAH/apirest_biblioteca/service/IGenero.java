package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;

import java.util.List;

public interface IGenero {

    Genero saveGenero(Genero genero);

    List<Genero> saveAllGeneros(List<Genero> generoList);

    List<GeneroDTO> findAll();

    GeneroDTO findById(Integer id);

    Genero updateGenero(Genero genero);

    void deleteById(Integer id);
}
