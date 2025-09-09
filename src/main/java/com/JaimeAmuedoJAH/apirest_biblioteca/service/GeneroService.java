package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGenero{

    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Genero saveGenero(Genero genero) {
        return null;
    }

    @Override
    public List<Genero> findAll() {
        return List.of();
    }

    @Override
    public Genero findById(Integer id) {
        return null;
    }

    @Override
    public Genero updateGenero(Genero genero) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
