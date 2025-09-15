package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import com.JaimeAmuedoJAH.apirest_biblioteca.exception.LanzaExcepciones;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de autores.
 *
 * Define las operaciones principales del CRUD para la entidad Autor,
 * trabajando con objetos {@link AutorDTO}.
 */

@Service
public class AutorService implements IAutor{

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor saveAutor(Autor autor) {
        if(autor.getNombre().isBlank() || autor.getApellidos().isBlank()){
            LanzaExcepciones.lanzarBadRequest("El nombre y el apellido no pueden estar vacíos");
        }

        if(autor.getNombre().length() < 2 || autor.getNombre().length() > 50){
            LanzaExcepciones.lanzarBadRequest("El nombre tiene que tener entre 2 y 50 caracteres");
        }else if(autor.getApellidos().length() < 2 || autor.getApellidos().length() > 150){
            LanzaExcepciones.lanzarBadRequest("El apellido tiene que tener entre 2 y 50 caracteres");
        }
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> saveAllAutores(List<Autor> autorList) {
        for(Autor autor : autorList){
            if(autor.getNombre().isBlank() || autor.getApellidos().isBlank()){
                LanzaExcepciones.lanzarBadRequest("El nombre y el apellido no pueden estar vacíos");
            }

            if(autor.getNombre().length() < 2 || autor.getNombre().length() > 50){
                LanzaExcepciones.lanzarBadRequest("El nombre tiene que tener entre 2 y 50 caracteres");
            }else if(autor.getApellidos().length() < 2 || autor.getApellidos().length() > 150){
                LanzaExcepciones.lanzarBadRequest("El apellido tiene que tener entre 2 y 50 caracteres");
            }
        }
        return autorRepository.saveAll(autorList);
    }

    @Override
    public List<AutorDTO> findAll() {
        List<AutorDTO> listaAutores = autorRepository.findAll()
                .stream()
                .map(AutorDTO::new)
                .toList();

        if(listaAutores.isEmpty()){
            LanzaExcepciones.lanzarNotFound();
        }

        return listaAutores;
    }

    @Override
    public AutorDTO findById(Integer id) {
        AutorDTO autorDTO = autorRepository.findById(id)
                .map(AutorDTO::new)
                .orElse(null);

        if(autorDTO == null){
            LanzaExcepciones.lanzarNotFound("autor", id);
        }

        return autorDTO;
    }

    @Override
    public Autor updateAutor(Autor autor) {

        Autor autorDB = autorRepository.findById(autor.getId()).get();

        autorDB.setNombre(autor.getNombre());
        autorDB.setApellidos(autor.getApellidos());
        autorDB.setBiografia(autor.getBiografia());
        autorDB.setFecha_nacimiento(autor.getFecha_nacimiento());
        autorDB.setListLibros(autor.getListLibros());

        return autorRepository.save(autorDB);
    }

    @Override
    public void deleteById(Integer id) {
        autorRepository.deleteById(id);
    }
}
