package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.dto.LibroDTO;
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
        return generoRepository.save(genero);
    }

    @Override
    public List<Genero> saveAllGeneros(List<Genero> generoList) {
        return generoRepository.saveAll(generoList);
    }

    @Override
    public List<GeneroDTO> findAll() {
        return generoRepository.findAll()
                .stream()
                .map(GeneroDTO::new)
                .toList();
    }

    @Override
    public GeneroDTO findById(Integer id) {
        return generoRepository.findById(id)
                .map(GeneroDTO::new)
                .orElse(null);
    }

    @Override
    public Genero updateGenero(Genero genero) {
        Genero generoDB = generoRepository.findById(genero.getId()).get();

        generoDB.setNombre(genero.getNombre());
        generoDB.setListLibro(genero.getListLibro());

        return generoRepository.save(generoDB);
    }

    @Override
    public void deleteById(Integer id) {
        generoRepository.deleteById(id);
    }
}
