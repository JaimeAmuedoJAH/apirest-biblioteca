package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.GeneroDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Genero;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.LanzaExcepciones;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de géneros literarios.
 *
 * Define operaciones CRUD para la entidad Género,
 * utilizando objetos {@link GeneroDTO}.
 */

@Service
public class GeneroService implements IGenero{

    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Genero saveGenero(Genero genero) {
        if(genero.getNombre() == null){
            LanzaExcepciones.lanzarBadRequest("El nombre del género no puede estar vacío");
        } else if(genero.getNombre().length() < 2 || genero.getNombre().length() > 50){
            LanzaExcepciones.lanzarBadRequest("El nombre tiene que estar entre 2 y 50 caracteres");
        }

        return generoRepository.save(genero);
    }

    @Override
    public List<Genero> saveAllGeneros(List<Genero> generoList) {
        if(generoList.isEmpty()){
            LanzaExcepciones.lanzarBadRequest("Rellena al menos un campo");
        }

        for(Genero genero : generoList){
            if(genero.getNombre() == null){
                LanzaExcepciones.lanzarBadRequest("El nombre de los géneros no puede estar vacío");
            }else if(genero.getNombre().length() < 2 || genero.getNombre().length() > 50){
                LanzaExcepciones.lanzarBadRequest("El nombre tiene que estar entre 2 y 50 caracteres");
            }
        }

        return generoRepository.saveAll(generoList);
    }

    @Override
    public List<GeneroDTO> findAll() {
        List<GeneroDTO> lista = generoRepository.findAll()
                .stream()
                .map(GeneroDTO::new)
                .toList();

        if(lista.isEmpty()){
            LanzaExcepciones.lanzarNotFound();
        }

        return lista;
    }

    @Override
    public GeneroDTO findById(Integer id) {
        GeneroDTO genero = generoRepository.findById(id)
                .map(GeneroDTO::new)
                .orElse(null);

        if(genero == null){
            LanzaExcepciones.lanzarNotFound("genero", id);
        }

        return genero;
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
