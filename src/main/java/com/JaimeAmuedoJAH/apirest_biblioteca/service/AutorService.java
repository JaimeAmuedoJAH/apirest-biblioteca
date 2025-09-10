package com.JaimeAmuedoJAH.apirest_biblioteca.service;

import com.JaimeAmuedoJAH.apirest_biblioteca.dto.AutorDTO;
import com.JaimeAmuedoJAH.apirest_biblioteca.entity.Autor;
import com.JaimeAmuedoJAH.apirest_biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutor{

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> saveAllAutores(List<Autor> autorList) {
        return autorRepository.saveAll(autorList);
    }

    @Override
    public List<AutorDTO> findAll() {
        return autorRepository.findAll()
                .stream()
                .map(AutorDTO::new)
                .toList();
    }

    @Override
    public AutorDTO findById(Integer id) {
        return autorRepository.findById(id)
                .map(AutorDTO::new)
                .orElse(null);
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
